package com.learning.portal.common;

/**
 * @author ravi
 * Validator class
 */
public class Validator {

	public static boolean isValidString(String str) {
		return !(null == str || str.isEmpty()); 
	}
}
