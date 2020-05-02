package com.learning.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.portal.dto.CourseDTO;
import com.learning.portal.model.Course;

@Service
public interface CourseService {

	public List<Course> getCourses();
	public Course getCourseById(Long id);
	public CourseDTO getCourseDTOById(Long id);
	public Course getCourseByCourseIdAndPriceContryCode(Long id, int countryCode);
	public CourseDTO getCourseDTOByCourseIdAndPriceContryCode(Long id, int countryCode);
	public Course addCourse(Course course);
	public void deleteCourse(Long id);
}
