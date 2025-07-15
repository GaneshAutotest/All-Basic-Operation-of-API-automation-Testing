package HelperMethods;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderHelperClass {

	@Test
    public RequestSpecification requestSpecBuilder() {
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
	return req;
	
    }
	
	@Test
    public ResponseSpecification responseSpecBuilder() {
    	
    	ResponseSpecification res= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
    	return res;
    }
    
    
    
    
    
}
