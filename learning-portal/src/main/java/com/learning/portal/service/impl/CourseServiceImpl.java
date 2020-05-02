package com.learning.portal.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.portal.configuration.TaxConfig;
import com.learning.portal.dto.CourseDTO;
import com.learning.portal.model.Course;
import com.learning.portal.repository.CourseRepository;
import com.learning.portal.service.CourseService;

@Component
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TaxConfig config;
	
	@Override
	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		Optional<Course> optinalCourse =  courseRepository.findById(id);
		return optinalCourse.orElseThrow(() -> new EntityNotFoundException("Couldn't find a Course with id: " + id));
	}
	
	@Override
	public CourseDTO getCourseDTOById(Long id) {
		try {
			Course course = getCourseById(id);
			return new CourseDTO(course, config);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Couldn't find a Course with id: " + id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Course getCourseByCourseIdAndPriceContryCode(Long id, int countryCode) {
		Course course = courseRepository.findByIdAndPriceCountryCode(id, countryCode);
		if(course == null)
			throw new EntityNotFoundException("Couldn't find a Course with id: " + id + " and countryCode: " + countryCode );
		return course;
	}
	
	@Override
	public CourseDTO getCourseDTOByCourseIdAndPriceContryCode(Long id, int countryCode) {
		Course course = getCourseByCourseIdAndPriceContryCode(id,countryCode);
		return new CourseDTO(course, config);
	}
	
	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}


}
