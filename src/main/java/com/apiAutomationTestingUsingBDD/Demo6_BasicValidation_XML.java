package com.apiAutomationTestingUsingBDD;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo6_BasicValidation_XML {
/*
1) Verifying  Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go
4) XPath with text() function
5) Find values using XML path in XML response
 * 
 */
	
	//1) Verifying  Single content in XML Response
	@Test(priority = 1)
	public void testSingleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("5"))
			.log().all();	
		
	}
	
	
	//2) Verifying Multiple contents in XML Response
	@Test(priority = 2)
	public void testMultipleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("5"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upload Pl."))
			.body("CUSTOMER.CITY", equalTo("Seatle"));
				
		
	}
	
	//3) Verifying all the content in XML response in one go using text() of XML
	@Test(priority = 3)
	public void testMultipleContentInOneGo() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.text()", equalTo("5BillClancy319 Upload Pl.Seatle"));
	}
	
	
	//5) Find values using XML path in XML response
		@Test(priority = 4)
		public void testUsingXpath1() {
			
			given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			.then()
			 	.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));// Specifying XPath within Xml
		}
	
		
		@Test(priority = 5)
		public void testUsingXpath2() {
			
			given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/INVOICE/")
			.then()
			 	.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))// Specifying XPath within Xml
			 	.log().all();
		}
	
	
		  
	

}
