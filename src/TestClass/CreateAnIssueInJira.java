package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import DataFiles.PayLoad;
import HelperMethods.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateAnIssueInJira {


	@Test
	public void CreateAnIssue() {

		RestAssured.baseURI="https://ganeshnaik638.atlassian.net";	
		String createIssueResponse 	= given()		
				.header("Content-Type","application/json")		
				.header("Authorization","Basic R2FuZXNobmFpazYzOEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdFBIU1hPd2k3akNwbTloTllSMVN3MnJGaFNaYVFGbGVCQlNiMHdQbWpNSmEzOGdzREs0cmt6cnpZSlZaM0I1cGV5RFNvclIxYk9OQXBaNDFfRjNMTDVrM2wxZExVYll3SzNabk1EdXhCTVVXbDh2Sjl4REZxdnRzMVFGVEl2ZFhVR3pCVF9iNWRLTm5jX1owc2M2dk9XZGdiLU9jQWhhX1lVdVNsRmNoaEhnPUQ1RkU0NkJC")		
				.body("{\n"				+ "    \"fields\": {\n"				+ "       \"project\":\n"				+ "       {\n"				+ "          \"key\": \"SCRUM\"\n"				+ "       },\n"				+ "       \"summary\": \"Issue is creating by API automation 02\",\n"				+ "       \"issuetype\": {\n"				+ "          \"name\": \"Bug\"\n"				+ "       }\n"				+ "   }\n"				+ "}")		.log().all()		
				.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).contentType("application/json").extract().response().asString();	
		JsonPath js = new JsonPath(createIssueResponse);		
		String issueId = js.getString("id");		 
		System.out.println(issueId);		 		 

		given()			
		.pathParam("key", issueId)
		.header("X-Atlassian-Token","no-check")	
		.header("Authorization","Basic R2FuZXNobmFpazYzOEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdFBIU1hPd2k3akNwbTloTllSMVN3MnJGaFNaYVFGbGVCQlNiMHdQbWpNSmEzOGdzREs0cmt6cnpZSlZaM0I1cGV5RFNvclIxYk9OQXBaNDFfRjNMTDVrM2wxZExVYll3SzNabk1EdXhCTVVXbDh2Sjl4REZxdnRzMVFGVEl2ZFhVR3pCVF9iNWRLTm5jX1owc2M2dk9XZGdiLU9jQWhhX1lVdVNsRmNoaEhnPUQ1RkU0NkJC")			
		.multiPart("file",new File("D://GaneshNaik//Udemi//Jira.png")).log().all()			
		.post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);






	}

































}
