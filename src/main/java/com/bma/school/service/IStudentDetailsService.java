package com.bma.school.service;

import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.output.vo.StudentDetailsOutputVO;

public interface IStudentDetailsService {

	public StudentDetailsOutputVO getStudentBill(StudentDetailsInputVO studentDetailsInputVO) throws StudentDetailsException;
}
