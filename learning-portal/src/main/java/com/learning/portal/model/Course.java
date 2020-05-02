package com.learning.portal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Course Name
	@Column(unique = true)
	private String name;
	
	// Course Description
	@Column
	private String description;
	
	// Course Type 1->Free, 2->One Time, 3->Subscription
	@Column
	private int type;
	
	@OneToMany(mappedBy = "course",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<CoursePrice> price;
	
	
}
