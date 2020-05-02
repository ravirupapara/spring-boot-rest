package com.learning.portal.common;

public class PortalConstant {
	
	public static final String PERCENT = "%";
	public static final String FINAL_PRICE = "Final Price";
	public static final String BASIC_PRICE = "Basic Price";
	public static final String CURRENCY_SYMBOL = "CurrencySymbol";
	
	public static final String FREE = "Free";
	public static final String ONE_TIME = "One Time";
	public static final String SUBSCRIPTION = "Subscription";
	public static final String DAY = "Day";
	public static final String MONTH = "Month";
	public static final String YEAR = "Year";
	
	public static final int FREE_VALUE = 1;
	public static final int ONE_TIME_VALUE = 2;
	public static final int SUBSCRIPTION_VALUE = 3;
	public static final int DAY_VALUE = 11;
	public static final int MONTH_VALUE = 12;
	public static final int YEAR_VALUE = 13;
	

	public static final String getLable(int value) {
		switch (value) {
		case 1:
			return FREE;
		case 2:
			return ONE_TIME;
		case 3:
			return SUBSCRIPTION;
		case 11:
			return DAY;
		case 12:
			return MONTH;
		case 13:
			return YEAR;
		default:
			break;
		}

		return null;

	};
}
