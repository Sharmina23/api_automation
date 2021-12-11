package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.basepage.BasePage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteMethod extends BasePage {
	String domain = "https://jsonplaceholder.typicode.com";
	
	@Test
	public void myDeleteMethod() {
		logger.info("*******Starting Delete Method*******");
		
		RestAssured.baseURI = domain;
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json; charset=utf-8");
		Response response = httpRequest.request(Method.DELETE, "/posts/1");
		
		//Print the Response Body
		String body = response.getBody().asString();
		System.out.println(body);
		
		//Verify the Status code
		int status = response.getStatusCode();
		System.out.println("The Status code is : "+status);	
		Assert.assertEquals(status, 200);
		
		//Verify the content-type header
		String header = response.header("Content-Type");
		System.out.println("The header is : "+header);
		Assert.assertEquals(header, "application/json; charset=utf-8");
		
		logger.info("*******Ending Delete Method*******");
				
	}

}
