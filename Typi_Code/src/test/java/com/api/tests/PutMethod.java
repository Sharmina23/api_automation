package com.api.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.basepage.BasePage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod extends BasePage {
	String domain = "https://jsonplaceholder.typicode.com";
	
	@Test
	public void myPutMethod() {	
		logger.info("*******Starting Put Method*******");
		
		RestAssured.baseURI = domain;
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject data = new JSONObject();
		data.put("title", "UPDATED API from Automation");
		data.put("body", "This is body from Rest Assured");
		
		httpRequest.header("Content-Type", "application/json; charset=utf-8");
		httpRequest.body(data.toJSONString());
		
		//Print the response body
		Response response = httpRequest.request(Method.PUT, "/posts/1");
		String body = response.getBody().asString();
		System.out.println(body);
		
		//Verify updated title from response body
		String title = response.jsonPath().get("title");
		System.out.println("The updated title is : "+title);
		String expected = "UPDATED API from Automation";
		Assert.assertEquals(title, expected);
		
		//Verify the Status code
		int status = response.getStatusCode();
		System.out.println("The Status code is : "+status);	
		Assert.assertEquals(status, 200);
		
		//Verify the content-type header
		String header = response.header("Content-Type");
		System.out.println("The header is : "+header);
		Assert.assertEquals(header, "application/json; charset=utf-8");
		
		logger.info("*******Ending Put Method*******");
	
	}


}
