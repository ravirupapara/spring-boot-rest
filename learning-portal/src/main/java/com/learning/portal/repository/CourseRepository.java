package com.learning.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.portal.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("select c from Course c join fetch c.price as prices where c.id = :id and prices.countryCode = :countryCode ")
	public Course findByIdAndPriceCountryCode(Long id, int countryCode);
}
