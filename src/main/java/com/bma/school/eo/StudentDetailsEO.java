package com.bma.school.eo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.output.dto.StudentDetailsOutputDTO;

public class StudentDetailsEO {

	private final static Logger logger = LoggerFactory.getLogger(StudentDetailsEO.class);

	private WebClient webClient;

//	@Autowired
//	private StudentDetailsEO(@Qualifier("jwtDecoratedStudentDetails") WebClient webClient) {
//		this.webClient = webClient;
//	}

	public StudentDetailsOutputDTO getStudentBill(StudentDetailsInputDTO studentDetailsInputDTO)
			throws StudentDetailsException {
		StudentDetailsOutputDTO studentDetailsOutputDTO = null;

		try {
			studentDetailsOutputDTO = 
					webClient.post()
					.uri("fghj")
					.accept(MediaType.APPLICATION_JSON)
					.header("fgg")
					.header("dfgh", "dfg")
					.bodyValue(studentDetailsInputDTO)
					.retrieve()
					.bodyToMono(StudentDetailsOutputDTO.class)
					.block();
			
			if(null == studentDetailsOutputDTO) {
				throw new StudentDetailsException();
			}

		} catch (Exception e) {
			String exceptionMesssage = "Failed to make web client call";
			logger.error(exceptionMesssage, e);
			throw new StudentDetailsException("", "", "Invalid Data");
		}

		return studentDetailsOutputDTO;
	}

}
