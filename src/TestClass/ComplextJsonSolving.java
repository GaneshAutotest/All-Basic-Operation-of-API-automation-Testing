package TestClass;

import java.util.Iterator;

import org.testng.annotations.Test;

import DataFiles.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplextJsonSolving {
/* 
 1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount
 */
	
	
	@Test(priority = 0)
	public void ComplexJson() {

		
		System.out.println("**********************************************************************");
		JsonPath js=new JsonPath(PayLoad.ComplexJsonBody());

		int NoOfCourse = js.getInt("courses.size()");
		System.out.println("NoOfCourse:"+NoOfCourse);

		int PurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("PurchaseAmount:"+PurchaseAmount);

		String FirstCourseTitle = js.get("courses[0].title");
		System.out.println("FirstCourseTitle:"+FirstCourseTitle);


		System.out.println("All course titles and their respective Prices");
		for (int i = 0; i < NoOfCourse; i++) {

			String Title=js.get("courses["+i+"].title");
			int Price = js.get("courses["+i+"].price");

			System.out.println("Title:"+Title);
			System.out.println("Price:"+Price);
		}


		for (int i = 0; i < NoOfCourse; i++) {

			String Title=js.get("courses["+i+"].title");
			if (Title.equalsIgnoreCase("RPA")) {
				int Copies=js.getInt("courses["+i+"].copies");
				System.out.println("No of copies sold by RPA Course:"+Copies);
				break;
			}
		}

		int sum=0;
		for (int i = 0; i < NoOfCourse; i++) {

			int CoursePrice=js.getInt("courses["+i+"].price");
			int Copies=js.getInt("courses["+i+"].copies");

			int amount=CoursePrice*Copies;
			sum=sum+amount;

		}

		if (sum==PurchaseAmount) {
			System.out.println("sum:"+sum);
			System.out.println("PurchaseAmount:"+PurchaseAmount);
			System.out.println(" Sum of all Course prices matches with Purchase Amount");
		}else {
			System.out.println(" Sum of all Course prices not matches with Purchase Amount");
		}


	}
	
	@Test(priority = 1)
	public void ComplexData01() {
		
	  JsonPath js= new JsonPath(PayLoad.Complex01());
		System.out.println("**********************************************************************");
	 String zipcode =js.get("address.zipcode");
	  System.out.println("zipcode:"+zipcode);
	String CompanyName= js.get("company.name");
	  System.out.println("CompanyName:"+CompanyName);
	float Lat = js.getFloat("address.geo.lat");
	  System.out.println("Lat:"+Lat);
		
	}
	
	
	
	
	
	
	
}
