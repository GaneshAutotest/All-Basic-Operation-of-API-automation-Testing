package TestClass;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.asserts.SoftAssert;
import DataFiles.PayLoad;
import HelperMethods.SpecBuilderHelperClass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class SpecBuilder {

	public static void main(String[]args) {
		SoftAssert sa=new SoftAssert();
		SpecBuilderHelperClass SPEC=new SpecBuilderHelperClass();
		PojoClassPUToperation BD=new PojoClassPUToperation();
		PojoClassForDeleteOperation bd=new PojoClassForDeleteOperation();

		System.out.println("********************* Post Operation *******************");
		RequestSpecification request = given().spec(SPEC.requestSpecBuilder()).body(PayLoad.body01());		
		Response response = request.when().post("/maps/api/place/add/json")
		.then().spec(SPEC.responseSpecBuilder()).extract().response();
		JsonPath js=new JsonPath(response.asString());
		String PalceId=js.getString("place_id");
        System.out.println("place_id : "+PalceId);
		System.out.println("********************* Get Operation *******************");	
		RequestSpecification GetReposnse = given().spec(SPEC.requestSpecBuilder()).queryParam("place_id", PalceId);
		Response res = GetReposnse.when().get("/maps/api/place/get/json")
		.then().spec(SPEC.responseSpecBuilder()).extract().response();
		String AxpectedAddress="03, Gudemakki, Manjunath naik";
		JsonPath js1=new JsonPath(res.asString());
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
		BD.setPlace_id(PalceId);
		BD.setAddress("Raaam, Ayodhya");
		BD.setKey("qaclick123");		         
		given().spec(SPEC.requestSpecBuilder()).body(BD)
		.when().put("/maps/api/place/update/json")
		.then().log().all().spec(SPEC.responseSpecBuilder()).body("msg", equalTo("Address successfully updated"));	 

		System.out.println("********************* Delete Operation *******************");
		bd.setPlace_id(PalceId);
		given().spec(SPEC.requestSpecBuilder()).body(bd)
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().spec(SPEC.responseSpecBuilder()).body("status", equalTo("OK"));

	}

}
