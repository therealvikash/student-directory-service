package com.bma.school.mapper;


import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;

public interface StudentDetailsMapper {
	public StudentDetailsInputDTO populateStudentDetailsInputDTOFromVO(
			StudentDetailsInputVO studentDetailsInputVO);

	public StudentDetailsOutputVO populateStudentDetailsOutputVOFromDTO(
			StudentDetailsOutputDTO studentDetailsOutputDTO);

}
