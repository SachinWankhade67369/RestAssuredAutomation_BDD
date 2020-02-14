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

public class Demo5_BasicValidation_JSON {
/*
1) Test Status Code
2) Log Response
3) Verifying single content in response body
4) Verifying Multiple contents in response body
5) Setting parameters & headers
 * 
 */
	
	//1.Test Status Code
	@Test(priority = 1)
	public void testStatusCode() {
		
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	
//		given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200).log().all();	
		
	}
	
	
	//2.Log Response
	@Test(priority = 2)
	public void testLoggingResponse() {
		
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();	
		
	}
	
	//3.Verifying single content in response body
	@Test(priority = 3)
	public void testSingleContent() {
		
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", equalTo("India"));
	}
	
	
	//4.Verifying Multiple content in response body
		@Test(priority = 4)
		public void testMultipleContent() {
			
			given()
			.when()
				.get("http://services.groupkt.com/country/get/All")
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", hasItems("India","Australia","United States of America"));
		}
	
	
	//5) Setting parameters & headers
		
		@Test(priority = 5)
		public void testParameterAndHeaders() {
			
			given()
				.param("MyName", "Abc")
				.header("MyHeader","Indian")
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.log().all();
		}
	
		  
	

}
