package com.bma.school.eo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.mapper.util.StudentDetailsMapperUtil;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.request.vo.StudentDetailsRequestVO;
import com.bma.school.response.vo.StudentDetailsResponseVO;

@Component
public class StudentDetailsEO {

	private final static Logger logger = LoggerFactory.getLogger(StudentDetailsEO.class);

	@Autowired
	private StudentDetailsMapperUtil studentDetailsMapperUtil;

	private WebClient webClient;

//	@Autowired
//	private StudentDetailsEO(@Qualifier("jwtDecoratedStudentDetails") WebClient webClient) {
//		this.webClient = webClient;
//	}

	public StudentDetailsOutputDTO getStudentDetails(StudentDetailsInputDTO studentDetailsInputDTO)
			throws StudentDetailsException {
		StudentDetailsOutputDTO studentDetailsOutputDTO = null;
		StudentDetailsResponseVO studentDetailsResponseVO = new StudentDetailsResponseVO();
		StudentDetailsRequestVO studentDetailsRequestVO = studentDetailsMapperUtil
				.populateReqVOFromInputVo(studentDetailsInputDTO);
		try {
			studentDetailsResponseVO = webClient.post()
					.uri("http://localhost:8083/student/directory/service/read/studentdetails")
					.accept(MediaType.APPLICATION_JSON)
//					.header("")
//					.header("", "")
					.bodyValue(studentDetailsRequestVO)
					.retrieve()
					.bodyToMono(StudentDetailsResponseVO.class)
					.block();
			if (null == studentDetailsResponseVO) {
				throw new StudentDetailsException();
			}
			studentDetailsOutputDTO = studentDetailsMapperUtil.populateOutputVoFromResVO(studentDetailsResponseVO);
		} catch (Exception e) {
			String exceptionMesssage = "Failed to make web client call";
			logger.error(exceptionMesssage, e);
			throw new StudentDetailsException("", "", "Invalid Data");
		}
		return studentDetailsOutputDTO;
	}
}
