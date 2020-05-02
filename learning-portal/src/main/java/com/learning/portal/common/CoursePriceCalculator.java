package com.learning.portal.common;

import java.util.HashMap;
import java.util.Map;

import com.learning.portal.configuration.TaxConfig;
import com.learning.portal.model.CoursePrice;


/**
 * @author ravi
 * Price calculator to calculate the price of course based on basic price and other charges added in properties
 */
public class CoursePriceCalculator {
	
	public Map<String, String> calculatePrice(CoursePrice price, TaxConfig config) {
		Map<String, Map<String, String>> countryTax = config.getCountryTax();
		Map<String, String> tax = new HashMap<String, String>(countryTax.get(String.valueOf(price.getCountryCode())));
		double finalPrice = price.getBasicPrice();
		double percent = 0.0;
		double flat = 0.0;
		Map<String, String> priceValues = new HashMap<String, String>();
		priceValues.put(PortalConstant.CURRENCY_SYMBOL, tax.remove(PortalConstant.CURRENCY_SYMBOL));
		// Accumulate all other charges apply on basic price with percentage or flat price
		for (Map.Entry<String, String> component: tax.entrySet()) {
			if(component.getValue().contains(PortalConstant.PERCENT)) {
				percent = Double.parseDouble(component.getValue().replace(PortalConstant.PERCENT, ""));
				percent = price.getBasicPrice() * (percent/100);
				finalPrice = finalPrice + percent;
				priceValues.put(component.getKey(), String.valueOf(percent));
			}
			else {
				if(price.getBasicPrice() != 0) {
					flat = Double.parseDouble(component.getValue());
					finalPrice = finalPrice + flat;
				}
				priceValues.put(component.getKey(), String.valueOf(flat));
			}
		}
		priceValues.put(PortalConstant.FINAL_PRICE, String.valueOf(finalPrice));
		priceValues.put(PortalConstant.BASIC_PRICE, String.valueOf(price.getBasicPrice()));
		return priceValues;
	}
}
