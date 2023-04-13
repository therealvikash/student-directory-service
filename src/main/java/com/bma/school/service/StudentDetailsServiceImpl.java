package com.bma.school.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bma.school.bo.StudentDetailsBO;
import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.mapper.StudentDetailsMapper;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;

public class StudentDetailsServiceImpl implements IStudentDetailsService {

	@Autowired
	private StudentDetailsMapper studentDetailsMapper;

	@Autowired
	private StudentDetailsBO studentDetailsBO;

	@Override
	public StudentDetailsOutputVO getStudentBill(StudentDetailsInputVO studentDetailsInputVO)
			throws StudentDetailsException {
		StudentDetailsInputDTO studentDetailsInputDTO = studentDetailsMapper
				.populateStudentDetailsInputDTOFromVO(studentDetailsInputVO);
		StudentDetailsOutputDTO studentDetailsOutputDTO = studentDetailsBO.getStudentBill(studentDetailsInputDTO);
		StudentDetailsOutputVO studentDetailsOutputVO = studentDetailsMapper
				.populateStudentDetailsOutputVOFromDTO(studentDetailsOutputDTO);
		return studentDetailsOutputVO;
	}

}
