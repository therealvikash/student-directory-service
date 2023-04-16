package com.bma.school.mapper.util;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.mapper.StudentDetailsMapper;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;
import com.bma.school.request.vo.StudentDetailsRequestVO;
import com.bma.school.response.vo.StudentDetailsResponseVO;

@Component
public class StudentDetailsMapperUtil {

	public StudentDetailsInputDTO populateStudentDetailsInputDTOFromStudentDetailsInputVO(
			StudentDetailsInputVO studentDetailsInputVO) {
		StudentDetailsMapper studentDetailsMapper = Mappers.getMapper(StudentDetailsMapper.class);
		return studentDetailsMapper.populateStudentDetailsInputDTOFromVO(studentDetailsInputVO);
	}
	
	public StudentDetailsOutputVO populateStudentDetailsOutputVOFromDTO(
			StudentDetailsOutputDTO studentDetailsOutputDTO) {
		StudentDetailsMapper studentDetailsMapper = Mappers.getMapper(StudentDetailsMapper.class);
		return studentDetailsMapper.populateStudentDetailsOutputVOFromDTO(studentDetailsOutputDTO);
	}
	
	public StudentDetailsRequestVO populateReqVOFromInputVo(StudentDetailsInputDTO studentDetailsInputDTO) {
		StudentDetailsMapper studentDetailsMapper = Mappers.getMapper(StudentDetailsMapper.class);
		return studentDetailsMapper.populateReqVOFromInputDTO(studentDetailsInputDTO);
	}
	
	public StudentDetailsOutputDTO populateOutputVoFromResVO(StudentDetailsResponseVO studentDetailsResponseVO) {
		StudentDetailsMapper studentDetailsMapper = Mappers.getMapper(StudentDetailsMapper.class);
		return studentDetailsMapper.populateOutputDTOFromResVO(studentDetailsResponseVO);
	}
}
