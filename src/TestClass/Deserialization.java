package TestClass;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import HelperMethods.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Deserialization {

	@Test
	public void GetCourseDetails() {

		RestAssured.baseURI="https://rahulshettyacademy.com";

		System.out.println("***************************** Authorization Server ********************************");
		String Res=given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.when().post("/oauthapi/oauth2/resourceOwner/token")
				.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=reusableMethods.getJsonPath(Res);
		String AccessToken=js.getString("access_token");
		System.out.println("Access Token : "+AccessToken);





		System.out.println("***************************** Course Details ********************************");

		PojoClassForCourseDetails cl=given().queryParam("access_token", AccessToken)
				.when().get("/oauthapi/getCourseDetails")
				.then().log().all().extract().response().as(PojoClassForCourseDetails.class);


		System.out.println("***************************** Instructor Details ********************************");
		System.out.println("Instructor :  "+cl.getInstructor());

		System.out.println("***************************** URL Details ********************************");
		System.out.println("URL : "+cl.getUrl());

		System.out.println("***************************** Print 'SoapUI Webservices testing' course title ********************************");

		System.out.println(cl.getCourses().getApi().get(1).getCourseTitle());

		System.out.println("***************************** Print all web automation course details ********************************");

		int sizeWebAutomation = cl.getCourses().getWebAutomation().size();

		for (int i = 0; i < sizeWebAutomation; i++) {

			String Title= cl.getCourses().getWebAutomation().get(i).getCourseTitle();
			int Price = cl.getCourses().getWebAutomation().get(i).getPrice();

			System.out.println(Title +" : "+Price );
		}

		System.out.println("***************************** Print total amount of each individual course ********************************");


		int Total=0;
		int webAutomationTotalPrice=0;
		int APITotalPrice=0;
		int MobileTotalPrice=0;

		for (int j = 0; j < sizeWebAutomation; j++) {
			int price = cl.getCourses().getWebAutomation().get(j).getPrice();
			webAutomationTotalPrice=webAutomationTotalPrice+ price;
		}
		Total=Total+webAutomationTotalPrice;
		int sizeAPI= cl.getCourses().getApi().size();
		for (int h = 0; h < sizeAPI; h++) {
			int price = cl.getCourses().getApi().get(h).getPrice();
			APITotalPrice=APITotalPrice+ price;
		}
		Total=Total+APITotalPrice;

		int price = cl.getCourses().getMobile().get(0).getPrice();
		MobileTotalPrice=MobileTotalPrice+ price;
		Total=Total+MobileTotalPrice;

		System.out.println("Total amount of all course : "+Total);





	}


}
