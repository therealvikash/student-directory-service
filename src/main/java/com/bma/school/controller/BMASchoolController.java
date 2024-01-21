package com.bma.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bma.error.CommonErrorVO;
import com.bma.school.exception.StudentDetailsException;
import com.bma.school.input.vo.StudentDetailsInputVO;
import com.bma.school.output.vo.StudentDetailsOutputVO;
import com.bma.school.service.IStudentDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/bma/studentdirectory")
@RestController
@Tag(name = "/bma/studentdirectory")
public class BMASchoolController {

	@Autowired
	private IStudentDetailsService iStudentDetailsService;

	@Operation(method = "POST", summary = "Gets the billing details of students."
			+ "Sample URL -http://{....}/bma/studentdirectory/abc", description = "Gets the bill generated for student")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = StudentDetailsOutputVO.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class))
			}),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class))
			}),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class))
			}),
			@ApiResponse(responseCode = "404", description = "Not Found", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class))
			}),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class))
			}), })

	@PostMapping(value = "/abc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDetailsOutputVO> getStudentBill(
			@RequestBody StudentDetailsInputVO studentDetailsInputVO) throws StudentDetailsException {
		StudentDetailsOutputVO studentDetailsOutputVO = iStudentDetailsService.getStudentBill(studentDetailsInputVO);
		return new ResponseEntity<>(studentDetailsOutputVO, HttpStatus.OK);
	}
}