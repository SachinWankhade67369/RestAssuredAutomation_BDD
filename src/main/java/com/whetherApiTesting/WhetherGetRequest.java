package com.whetherApiTesting;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.CoreMatchers.*;



public class WhetherGetRequest {
	/*
	given()
	set cookies, add authorization, add param, set headers info etc.

    when()
	get,push,put,delete..

    then() 
	validate status code, extract response, extract headers cookies & response body...
	*/
	
	
	@Test
	public void test_NumberOfCircuitsFor2017_Season() {
		
			given().
			when().
			get("http://ergast.com/api/f1/2017/circuits.json").
			then().
			assertThat().
			statusCode(200);
//			and().
//			header("Content-Length", equalTo(4551));
//			body("MRData.CircuitTable.Circuits.circuitId",equalTo("albert_park, americas, bahrain, BAK, catalunya, hungaroring, interlagos, marina_bay, monaco, monza, red_bull_ring, rodriguez, sepang, shanghai, silverstone, sochi, spa, suzuka, villeneuve, yas_marina"));
		
	}

	@Test
	public void demo_GET_Request_01() {
		
		given().
		when().
		get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").
		then().
		statusCode(200).
		statusLine("HTTP/1.1 200 OK").
		header("Content-Type", "application/json").
		assertThat().
		body("City", equalTo("Hyderabad"));
		
		
	}
	

}
