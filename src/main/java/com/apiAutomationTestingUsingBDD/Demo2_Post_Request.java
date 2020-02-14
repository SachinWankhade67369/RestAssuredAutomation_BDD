package com.apiAutomationTestingUsingBDD;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utilities.RestUtils;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_Post_Request {

	public static HashMap<String, String> map = new HashMap<>();

	/*
	 * For POST request, we need some data to be post to create new data/record into
	 * the Database. Need to prepare data, which we want to send it to the server.
	 */
	@BeforeClass
	public void getPostData() {

		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		
		  RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		  RestAssured.basePath ="/register";
		  
		 
	}

	@Test
	public void test_Post_Request() {

		given().contentType("application/json").body(map)

		.when()

				.post()
		
		.then() 
				.assertThat()
				.statusCode(201)// 201 Created 
				.and()
				.body("SuccessCode",equalTo("OPERATION_SUCCESS")) 
				.and()
				.body("Message",equalTo("Operation completed successfully"));
		 
		  int code = get().getStatusCode();
		  System.out.println(code);
	}

}
