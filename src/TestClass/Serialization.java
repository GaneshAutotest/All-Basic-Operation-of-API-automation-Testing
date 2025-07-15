package TestClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Serialization {
	
	public static void main(String[] args) {
		
		PojoClassAddDetailsOfPayload Pl=new PojoClassAddDetailsOfPayload();
		Pl.setAccuracy("50");
		Pl.setName("Frontline house");
		Pl.setPhone_number("(+91) 983 893 3937");
		Pl.setAddress("03, Gudemakki, Manjunath naik");
		Pl.setWebsite("http://google.com");
		Pl.setLanguage("Kannada");
		PojoClassForLocation lc=new PojoClassForLocation();
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		Pl.setLocation(lc);
		ArrayList<String> al=new ArrayList<String>();
		al.add("shoe park");
		al.add("shop");
		Pl.setTypes(al);
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		System.out.println("********************* Post Operation *******************");
		
		String PostResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Pl)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
		.extract().response().asString();
		
		JsonPath js=new JsonPath(PostResponse);
		String PalceId=js.getString("place_id");
	}
	
	
	
}
