package com.learning.portal.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("price")
public class TaxConfig {

    private Map<String, Map<String, String>> countryTax;

    public Map<String, Map<String, String>> getCountryTax() {
		return countryTax;
	}

	public void setCountryTax(Map<String, Map<String, String>> countryTax) {
		this.countryTax = countryTax;
	}
}