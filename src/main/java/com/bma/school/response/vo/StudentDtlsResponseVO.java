package com.bma.school.response.vo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.validation.Valid;
//
//import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Entity
public class StudentDtlsResponseVO {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String studentId;
	
//	@Schema(description = "Bills generated for given Student Name")
//	@Valid
	private String studentName;

	private String studentPermanentAddress;
	
	private String studentCurrentAddress;
	
	private String studentContact;
	
	private String studentEmailId;
	
}
