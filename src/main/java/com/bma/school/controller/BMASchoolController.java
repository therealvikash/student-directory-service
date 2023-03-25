package com.bma.school.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMASchoolController {

	private transient Integer val = 0;
	
	@GetMapping(value = "/")
	public String getValue() {

		String result = "Learnng how to do jenkins staging " + val;
		return result;
	}
}