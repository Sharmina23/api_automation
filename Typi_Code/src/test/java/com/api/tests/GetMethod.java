package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.basepage.BasePage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod extends BasePage {	
	String domain = "https://jsonplaceholder.typicode.com";
	
		@Test
		public void myGetMethod() {	
			logger.info("*******Starting Get Method*******");
			
			RestAssured.baseURI = domain;				
			RequestSpecification httpRequest = RestAssured.given();	
			httpRequest.header("Content-Type", "application/json; charset=utf-8");
			Response response = httpRequest.request(Method.GET, "/posts/1");
			
			//Print the Response body 
			String body = response.getBody().asString();		
			System.out.println(body);
			
			//Verify the Id and the title
			int id = response.jsonPath().get("id");
			System.out.println("The id is : "+id);
			Assert.assertEquals(id, 1);	
			
			String title = response.jsonPath().get("title");
			System.out.println("The title is : "+title);
			String expected = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
			Assert.assertEquals(title, expected);
			
			//Verify the Status code		
			int status = response.getStatusCode();
			System.out.println("The Status code is : "+status);	
			Assert.assertEquals(status, 200);
			
			//Verify the content-type header
			String header = response.header("Content-Type");
			System.out.println("The header is : "+header);
			Assert.assertEquals(header, "application/json; charset=utf-8");
			
			//verify the content-encoding header
			String contentEncoding = response.header("Content-Encoding");
			System.out.println("Content Encoding is:" + contentEncoding);
			Assert.assertEquals(contentEncoding, "gzip");
			
			logger.info("********** Ending Get Method**********");
		}

}
