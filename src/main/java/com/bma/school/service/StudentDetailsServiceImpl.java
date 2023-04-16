package com.bma.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bma.school.bo.StudentDetailsBO;
import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.mapper.util.StudentDetailsMapperUtil;
import com.bma.school.output.dto.StudentDetailsOutputDTO;
import com.bma.school.output.vo.StudentDetailsOutputVO;

@Service
@Component
public class StudentDetailsServiceImpl implements IStudentDetailsService {

	@Autowired
	private StudentDetailsMapperUtil studentDetailsMapperUtil;

	@Autowired
	private StudentDetailsBO studentDetailsBO;

	@Override
	public StudentDetailsOutputVO getStudentBill(StudentDetailsInputVO studentDetailsInputVO)
			throws StudentDetailsException {
		StudentDetailsInputDTO studentDetailsInputDTO = studentDetailsMapperUtil
				.populateStudentDetailsInputDTOFromStudentDetailsInputVO(studentDetailsInputVO);
		StudentDetailsOutputDTO studentDetailsOutputDTO = studentDetailsBO.getStudentBill(studentDetailsInputDTO);
		return studentDetailsMapperUtil
				.populateStudentDetailsOutputVOFromDTO(studentDetailsOutputDTO);
	}

}
