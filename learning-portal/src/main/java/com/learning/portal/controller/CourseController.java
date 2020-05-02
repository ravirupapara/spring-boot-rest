package com.learning.portal.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.portal.common.PortalResponse;
import com.learning.portal.common.Validator;
import com.learning.portal.dto.CourseDTO;
import com.learning.portal.service.CourseService;

/**
 * @author ravi
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/get-course-details")
	public ResponseEntity<PortalResponse> getCourseDetailsByCourseId(@RequestParam String courseId, @RequestParam String countryCode) {
		if(!Validator.isValidString(courseId) || !Validator.isValidString(countryCode)) {
			return new PortalResponse(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Provide valid courseId or ContryCode", null).build();
		}
		
		CourseDTO course;
		try {
			course = courseService.getCourseDTOByCourseIdAndPriceContryCode(Long.parseLong(courseId), Integer.parseInt(countryCode));
		} catch (EntityNotFoundException e) {
			return new PortalResponse(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, e.getMessage(),null).build();
		} catch(Exception e) {
			return new PortalResponse(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Something Went wrong!",null).build();
		} 
		return new PortalResponse(HttpStatus.OK.value(), Boolean.TRUE, "",course).build();
	
	}
}
