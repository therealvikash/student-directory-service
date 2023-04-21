package com.bma.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
	
	@Mapping(target="studentDtlsInputDTOs", source="studentDetailsInputVO.studentDtlsInputVOs")
	public StudentDetailsInputDTO populateStudentDetailsInputDTOFromVO(StudentDetailsInputVO studentDetailsInputVO);
	
	@Mapping(target="studentDetailsOutputs", source="studentDetailsOutputDTO.studentDtlsOutputDTOs")
	public StudentDetailsOutputVO populateStudentDetailsOutputVOFromDTO(
			StudentDetailsOutputDTO studentDetailsOutputDTO);

	@Mapping(target="studentDtlsInputVOs", source="studentDetailsInputDTO.studentDtlsInputDTOs")
	public StudentDetailsRequestVO populateReqVOFromInputDTO(StudentDetailsInputDTO studentDetailsInputDTO);

	@Mapping(target="studentDtlsOutputDTOs", source="studentDetailsResponseVO.studentDetailsOutputs")
	public StudentDetailsOutputDTO populateOutputDTOFromResVO(StudentDetailsResponseVO studentDetailsResponseVO);

}