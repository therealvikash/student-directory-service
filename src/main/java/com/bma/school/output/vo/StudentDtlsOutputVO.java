package com.bma.school.output.vo;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentDtlsOutputVO {

	@Schema(description = "Bills generated for given Student Name")
	@Valid
	private String studentName;

	@Schema(description = "Bills generated for given Student Id")
	@Valid
	private String studentId;

	@Schema(description = "Bills generated for respective month")
	private String thisMonth;
}
