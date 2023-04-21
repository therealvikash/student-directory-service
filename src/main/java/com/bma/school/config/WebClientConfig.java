package com.bma.school.config;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
@Component
public class WebClientConfig {

	private static final Logger logger = LoggerFactory.getLogger(WebClientConfig.class);

	@Value("${webClient.config.connectTimeOut}")
	private int connectTimeOut;

	@Value("${webClient.config.readTimeOut}")
	private int readTimeOut;

	@Value("${webClient.config.mask.headers}")
	List<String> headersToMask;

	@Value("${webClient.config.maxLifeTimeInMinutes}")
	private int maxLifeTimeInMinutes;

	@Value("${webClient.config.maxConnections}")
	private int maxConnections;

	@Value("${webClient.config.maxIdleTime}")
	private int maxIdleTime;

	@Value("${webClient.config.pendingAcquireTimeout}")
	private int pendingAcquireTimeout;

	private final String JWT_TOKEN = "YOUR_JWT_TOKEN_HERE";

	@Bean(name = "jwtDecoratedStudentDetails")
	public WebClient webClient() {
		ConnectionProvider connectionProvider = ConnectionProvider.builder("webclient-config")
				.maxLifeTime(Duration.ofMinutes(maxLifeTimeInMinutes)).maxConnections(maxConnections)
				.maxIdleTime(Duration.ofMillis(maxIdleTime))
				.pendingAcquireTimeout(Duration.ofMillis(pendingAcquireTimeout)).fifo().build();

		HttpClient httpClient = HttpClient.create(connectionProvider)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeOut)
				.doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeOut, TimeUnit.MILLISECONDS)));

		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

		return WebClient.builder()
//				.filter(jwtFilter())
//				.filter(logRequest())
				.clientConnector(connector)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	private ExchangeFilterFunction jwtFilter() {
		return (request, next) -> {
			try {
				return next.exchange(ClientRequest.from(request).header(headersToMask.get(0), JWT_TOKEN).build());
			} catch (Exception jwtException) {
				logger.error("JWTEXCEPTION", jwtException);
			}
			return next.exchange(request);
		};
	}

	private ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Request: ").append(clientRequest.method()).append(" ").append(clientRequest.url());
			sb.append(" Headers: [");
			clientRequest.headers().forEach((name, values) -> values.forEach(value -> {
				if (headersToMask.contains(name)) {
					sb.append(name).append(": ####, ");
				} else {
					sb.append(name).append(": ").append(value).append(", ");
				}
			}));
			sb.append("]");
			logger.debug(sb.toString());
			return Mono.just(clientRequest);
		});
	}
}
