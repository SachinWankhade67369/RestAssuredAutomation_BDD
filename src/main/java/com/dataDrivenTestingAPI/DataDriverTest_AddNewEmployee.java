package com.dataDrivenTestingAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriverTest_AddNewEmployee {

	// Create New Employee Record using HardCoded Values.
//	@Test
	void postNewEmployee() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Here we need to create data which we need to send along with the post
		// request.
		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "SMITH");
		requestParams.put("salary", "50000");
		requestParams.put("age", "29");

		// Add header stating the request body is JSON

		httpRequest.header("Content-Type", "application/json");

		// Add the JSON to the body of the Request
		httpRequest.body(requestParams.toJSONString());

		// POST Request
		Response response = httpRequest.request(Method.POST, "/create");

		// Capture response body to perform validations

		String responseBody = response.getBody().asString();

		Assert.assertEquals(responseBody.contains("SMITH"), true);
		Assert.assertEquals(responseBody.contains("50000"), true);
		Assert.assertEquals(responseBody.contains("29"), true);

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);
	}

	// Create New Employee Record using different TestData through Data Provider.
	@Test(dataProvider = "empDataProvider")
	void postNewEmployeeByDataProvider(String empName, String empSal, String empAge) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Here we need to create data which we need to send along with the post
		// request.
		JSONObject requestParams = new JSONObject();

		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);

		// Add header stating the request body is JSON

		httpRequest.header("Content-Type", "application/json");

		// Add the JSON to the body of the Request
		httpRequest.body(requestParams.toJSONString());

		// POST Request
		Response response = httpRequest.request(Method.POST, "/create");

		// Capture response body to perform validations

		String responseBody = response.getBody().asString();

		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSal), true);
		Assert.assertEquals(responseBody.contains(empAge), true);

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);
	}

	@DataProvider(name = "empDataProvider")
	public String[][] getEmpData() throws Exception {

		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\dataDrivenTestingAPI\\EmpDataAPITesting.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cellnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] empData = new String[rownum][cellnum];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < cellnum; j++) {

				empData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i , j);

			}
		}

//		String[][] empData = { { "abc", "4545", "25" }, { "xyz", "7548", "24" }, { "lkjh", "6645", "26" } };
		return empData;

	}

}
