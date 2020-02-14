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

public class Demo4_Delete_Request {

	
		  
	

	@Test
	public void test_Delete_Request() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath ="/delete/4";
		
		
		/*
		 * given()
		 * 
		 * .when()
		 * 
		 * .delete()
		 * 
		 * .then() .statusCode(200)// 200 OK .and() .statusLine("HTTP/1.1 200 OK")
		 * .log().all();
		 */
				
		
		//to verify the body whether the particular record has been deleted or not.
		Response response = given()
		
		.when()

			.delete()
		
		.then() 
			.statusCode(200)// 200 OK
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();  // this command will give us response in json format.
		
		String jsonAsString = response.asString(); // to convert json to string format, asString() is used.
		
		
		Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"),true);
	
		//for unsuccessful delete massage
//		Assert.assertEquals(jsonAsString.contains("Error! Not able to delete record"),true);
		
		
		
	}

}
