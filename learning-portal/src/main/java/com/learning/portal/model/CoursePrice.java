package com.learning.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "coursePrice")
@Data
public class CoursePrice{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
	@JsonIgnore
	private Course course;
	
	// Strategy Type would be: 11->day, 12->month, 13->year
	@Column
	private int strategyType;
	
	// Strategy Value would any integer number
	@Column
	private int strategyValue;
	
	// Basic price of course for particular strategy
	@Column
	private double basicPrice;
	
	// Country code on which price is applicable
	@Column
	private int countryCode;
	
}
