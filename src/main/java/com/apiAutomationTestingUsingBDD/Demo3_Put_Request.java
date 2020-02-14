package com.apiAutomationTestingUsingBDD;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utilities.RestUtils;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_Put_Request {

	public static HashMap<String, String> map = new HashMap<>();
	
	int EMPID = 4;
	
	String empName= RestUtils.empName();
	String empSalary= RestUtils.empSal();
	String empAge= RestUtils.empAge();

	/*
	 * For Put request, we need some data to be put to update existing data/record into
	 * the Database. Need to prepare data, which we want to send it to the server.
	 */
	@BeforeClass
	public void getPutData() {

		map.put("Name", empName);
		map.put("Salary", empSalary);
		map.put("Age", empAge);
		
	    RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	    RestAssured.basePath ="/update/"+EMPID;
		  
		 
	}

	@Test
	public void test_Put_Request() {

		given()
			.contentType("application/json")
			.body(map)

		.when()

			.put()
		
		.then() 
				.assertThat()
				.statusCode(200)// 200 OK
				.and()
				.log().all();
				
	}

}
