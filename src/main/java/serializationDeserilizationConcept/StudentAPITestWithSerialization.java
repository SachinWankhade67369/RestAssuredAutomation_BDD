package serializationDeserilizationConcept;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestWithSerialization {
	
	
	@Test(priority = 1)
	public void createNewStudentSerialization() {
		
		ArrayList<String>  coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu = new Student();
		
		stu.setId(101);
		stu.setFirstName("Joy");
		stu.setLastName("Toppo");
		stu.setEmail("joy@gmail.com");
		stu.setProgramme("IT");
		stu.setCourses(coursesList);
		
		
		
		given()
			
			.contentType(ContentType.JSON)
			.body(stu) //pass stu object as body. 
			
	   .when()
	   	
	   		.post("http://localhost:8085/student")
	   		
	   	.then()
	   	
	   		.statusCode(201)
	   		.assertThat()
	   		.body("msg", equalTo("Student added"));
			
		
	}
	
	
	//Get Request to retrieve Student details
	@Test(priority = 2)
	public void getStudentRecordDeSerialization() {
		
		/*
		 * Whatever the response we got it from get() method, it is in the form of File format.
		   and .as(classname.class) will extract those record from file which is related to Student class.
		*/
		
		Student stu = get("http://localhost:8085/student").as(Student.class);
		
		System.out.println(stu.getStudentRecord());
		
		int id =stu.getId();
		
		Assert.assertEquals(id, 101, "Student id doesn't match.");
		
//		System.out.println(stu.getId());
		
		
	}
	
	
}
