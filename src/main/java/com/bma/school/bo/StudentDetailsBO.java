package com.bma.school.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.bma.school.eo.StudentDetailsEO;
import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.dto.StudentDetailsInputDTO;
import com.bma.school.output.dto.StudentDetailsOutputDTO;

public class StudentDetailsBO {

	@Autowired
	private StudentDetailsEO studentDetailsEO;

	public StudentDetailsOutputDTO getStudentBill(StudentDetailsInputDTO studentDetailsInputDTO)
			throws StudentDetailsException {
		return studentDetailsEO.getStudentBill(studentDetailsInputDTO);
	}

}
