package TestClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import DataFiles.PayLoad;


public class CrudOperation {

	public static void main(String [] args) {
	   SoftAssert sa=new SoftAssert();
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		System.out.println("********************* Post Operation *******************");
		
		String PostResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.body01())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
		.extract().response().asString();
		
		JsonPath js=new JsonPath(PostResponse);
		String PalceId=js.getString("place_id");
		
		System.out.println("********************* Get Operation *******************");
		
	    String GetReposnse = given().queryParam("key", "qaclick123").queryParam("place_id", PalceId)
	   .when().get("/maps/api/place/get/json")
	   .then().assertThat().statusCode(200).extract().response().asString();
		String AxpectedAddress="03, Gudemakki, Manjunath naik";
	    JsonPath js1=new JsonPath(GetReposnse);
        String ActualAddress = js1.get("address");
		  
	    try {
			if (AxpectedAddress.contentEquals(ActualAddress))
				System.out.println("Get response properly extracted");
		} catch (Exception e) {
			sa.assertTrue(false);
			System.out.println("Get response not properly extracted");
			sa.assertAll();
		}
	   
	    System.out.println("********************* Put Operation *******************");
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+PalceId+"\",\r\n"
				+ "\"address\":\"Raaam, Ayodhya\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "} ")
	    .when().put("/maps/api/place/update/json")
	    .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));		
		
		 System.out.println("********************* Delete Operation *******************");
		
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\":\""+PalceId+"\"\r\n"
				+ "}")
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
