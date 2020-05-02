package com.learning.portal.dto;

import java.util.List;

import com.learning.portal.common.CoursePriceCalculator;
import com.learning.portal.common.PortalConstant;
import com.learning.portal.common.PortalUtil;
import com.learning.portal.configuration.TaxConfig;
import com.learning.portal.model.Course;

public class CourseDTO extends CoursePriceCalculator {

	private Long id;
	private String name;
	private String description;
	private LabelValue type;
	private List<PriceDTO> price;
	
	
	public CourseDTO() {
		super();
	}
	
	public CourseDTO(Course course, TaxConfig config) {
		super();
		setId(course.getId());
		setName(course.getName());
		setDescription(course.getDescription());
		setType(new LabelValue(PortalConstant.getLable(course.getType()), String.valueOf(course.getType())));
		setPrice(PortalUtil.getPriceDTOList(course.getPrice(), config));
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LabelValue getType() {
		return type;
	}

	public void setType(LabelValue type) {
		this.type = type;
	}

	public List<PriceDTO> getPrice() {
		return price;
	}

	public void setPrice(List<PriceDTO> price) {
		this.price = price;
	}

}
