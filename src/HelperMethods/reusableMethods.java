package HelperMethods;

import io.restassured.path.json.JsonPath;

public class reusableMethods {

	 public static JsonPath getJsonPath(String response) {
	        return new JsonPath(response);
	    }
	

	
}
