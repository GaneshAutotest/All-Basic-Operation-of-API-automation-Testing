package TestClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataFiles.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class LibraryAPI {

	@Test(dataProvider = "Data")
	public void library(String isbn, String aisle ) {

		RestAssured.baseURI="http://216.10.245.166";

		System.out.println("**************************** Add Book ***************************");

		String response = given().body(PayLoad.LibrryPostBody(isbn, aisle))
				.when().post("/Library/Addbook.php")
				.then().assertThat().statusCode(200).extract().response().asString();

		System.out.println("AddBBook response:-"+response);

		JsonPath js=new  JsonPath(response);
		String ID=js.getString("ID");
		System.out.println("ID:"+ID);

		System.out.println("**************************** Get Book ***************************");
		String Getresponse=given().queryParam("ID", ID)
				.when().get("/Library/GetBook.php")
				.then().assertThat().statusCode(200).extract().response().asString();

		System.out.println("Get Book response:-"+Getresponse);

		System.out.println("**************************** Delete Book ***************************");

		given().body("{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+ID+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "")
		.when().delete("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200).body("msg", equalTo("book is successfully deleted"));
		System.out.println("book is successfully deleted");


	}

	@Test
	public void LibraryAPIBodyFromOutSideFile() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";

		System.out.println("**************************** Static Json payLoad ***************************");

		String response = given().body(new String (Files.readAllBytes(Paths.get("D://GaneshNaik//Udemi//LibraryAPI.json"))))
				.when().post("/Library/Addbook.php")
				.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Static Json payLoad response:-"+response);
		
		
		
	}
	
	
	
	
	
	

	@DataProvider(name = "Data")
	public Object[][] dataSet() {
		return new Object [][] {
			{"ganesh","1210"},{"praveen","1321"},{"balu","12654"}
		};
	}







}
