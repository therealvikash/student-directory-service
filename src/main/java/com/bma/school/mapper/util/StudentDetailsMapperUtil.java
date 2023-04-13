package com.bma.school.mapper.util;

import java.util.List;

import org.mapstruct.factory.Mappers;

import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.mapper.StudentDetailsMapper;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;

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
}
