package com.bma.school.response.vo;
//import javax.validation.Valid;
//
//import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
public class StudentDtlsResponseVO {

	private String studentId;
	
//	@Schema(description = "Bills generated for given Student Name")
//	@Valid
	private String studentName;

	private String studentPermanentAddress;
	
	private String studentCurrentAddress;
	
	private String studentContact;
	
	private String studentEmailId;
	
}
