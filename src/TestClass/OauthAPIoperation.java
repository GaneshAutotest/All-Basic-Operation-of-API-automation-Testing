package TestClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import HelperMethods.reusableMethods;
public class OauthAPIoperation {

	
	@Test
	public void AuthorizationServer() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		System.out.println("***************************** Authorization Server ********************************");
		String Res=given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("/oauthapi/oauth2/resourceOwner/token")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Res);
		
		JsonPath js = reusableMethods.getJsonPath(Res);
		String AccessToken=js.get("access_token");
		
		System.out.println("***************************** Course Details ********************************");
		
		String CourseDetails=given().queryParam("access_token", AccessToken)
		.when().get("/oauthapi/getCourseDetails")
		.then().log().all().extract().response().asString();
		
		JsonPath Js01 = reusableMethods.getJsonPath(CourseDetails);
		
	System.out.println("Web automation Course Details: "+Js01.get("courses.webAutomation[1].courseTitle"));
		
		
		
		
	}
	
	
	
}
