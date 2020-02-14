package com.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	//Utilities methods to register random candidate
	
	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}
	
	
	public static String getLastName() {
		String genaratedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kendy"+ genaratedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}
	
	
	public static String getPassword() {
		String genaratedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+ genaratedString);
	}
	
	public static String getEmail() {
		String genaratedString = RandomStringUtils.randomAlphabetic(1);
		return (genaratedString+"gmail.com");
	}

	
    //Utilities For employee Data
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}
	
	
	public static String empSal() {
		String genaratedString = RandomStringUtils.randomAlphabetic(1);
		return (genaratedString+" Rs");
	}
	
	public static String empAge() {
		String genaratedString = RandomStringUtils.randomAlphabetic(1);
		return (genaratedString);
	}
	
	
	
	
}
