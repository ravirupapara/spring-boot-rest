package com.learning.portal.dto;

public class LabelValue {

	private String label;
	private String value;
	
	
	public LabelValue(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
