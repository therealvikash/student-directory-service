package com.bma.school.request.vo;

import lombok.Data;

@Data
public class StudentDtlsRequestVO {

	private String studentId;
	
	private String studentName;

	private String studentPermanentAddress;

	private String studentCurrentAddress;

	private String studentContact;

	private String studentEmailId;
}
