//package com.bma.school.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//import org.springframework.web.reactive.function.client.ClientRequest;
//import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Configuration
//public class WebClientConfig {
//	
//	private static final Logger logger = LoggerFactory.getLogger(WebClientConfig.class);
//
//    private final String JWT_TOKEN = "YOUR_JWT_TOKEN_HERE";
//
//    @Bean(name = "jwtDecoratedStudentDetails")
//    public WebClient webClient() {
//        return WebClient.builder()
//                .baseUrl("https://api.example.com")
//                .clientConnector(new ReactorClientHttpConnector())
//                .defaultHeader("Authorization", "Bearer " + JWT_TOKEN)
//                .filter(jwtFilter())
//                .filter(logRequest())
//                .build();
//    }
//
//    private ExchangeFilterFunction jwtFilter() {
//        return (request, next) -> {
//            try {
//            	return next.exchange(ClientRequest.from(request)
//            			.header(JWT_TOKEN, JWT_TOKEN)
//            			.build());
//            } catch (Exception jwtException) {
//				logger.error("JWTEXCEPTION", jwtException);
//			}
//            return next.exchange(request);
//        };
//    }
//
//    private ExchangeFilterFunction logRequest() {
//        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
//            clientRequest.headers().forEach((name, values) -> values.forEach(value -> System.out.println(name + ": " + value)));
//            return Mono.just(clientRequest);
//        });
//    }
//}
