package com.learning.portal.dto;

import java.util.Map;

import com.learning.portal.common.CoursePriceCalculator;
import com.learning.portal.common.PortalConstant;
import com.learning.portal.configuration.TaxConfig;
import com.learning.portal.model.CoursePrice;

public class PriceDTO extends CoursePriceCalculator {


	private Long id;
	private LabelValue strategyType;
	private int strategyValue;
	private int countryCode;
	private Map<String, String> priceComponent;
	
	public PriceDTO(CoursePrice coursePrice, TaxConfig config) {
		super();
		setId(coursePrice.getId());
		setStrategyType(new LabelValue(PortalConstant.getLable(coursePrice.getStrategyType()), String.valueOf(coursePrice.getStrategyType())));
		setStrategyValue(coursePrice.getStrategyValue());
		setCountryCode(coursePrice.getCountryCode());
		setPriceComponent(calculatePrice(coursePrice, config));
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public LabelValue getStrategyType() {
		return strategyType;
	}

	public void setStrategyType(LabelValue strategyType) {
		this.strategyType = strategyType;
	}

	public int getStrategyValue() {
		return strategyValue;
	}

	public void setStrategyValue(int strategyValue) {
		this.strategyValue = strategyValue;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public Map<String, String> getPriceComponent() {
		return priceComponent;
	}

	public void setPriceComponent(Map<String, String> priceComponent) {
		this.priceComponent = priceComponent;
	}
	
}
