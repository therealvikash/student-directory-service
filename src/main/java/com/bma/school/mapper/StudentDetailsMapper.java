package com.bma.school.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;
import com.bma.school.request.vo.StudentDetailsRequestVO;
import com.bma.school.response.vo.StudentDetailsResponseVO;

@Mapper(componentModel = "spring")
@Component
public interface StudentDetailsMapper {
	public StudentDetailsInputDTO populateStudentDetailsInputDTOFromVO(StudentDetailsInputVO studentDetailsInputVO);

	public StudentDetailsOutputVO populateStudentDetailsOutputVOFromDTO(
			StudentDetailsOutputDTO studentDetailsOutputDTO);

	public StudentDetailsRequestVO populateReqVOFromInputDTO(StudentDetailsInputDTO studentDetailsInputDTO);

	public StudentDetailsOutputDTO populateOutputDTOFromResVO(StudentDetailsResponseVO studentDetailsResponseVO);

}