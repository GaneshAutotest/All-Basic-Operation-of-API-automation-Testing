package DataFiles;

public class PayLoad {

	
	public static String body01() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"03, Gudemakki, Manjunath naik\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		
	}
	
	public static String ComplexJsonBody() {
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}
	
	
	public static String Complex01() {
		return "{\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Leanne Graham\",\r\n"
				+ "    \"username\": \"Bret\",\r\n"
				+ "    \"email\": \"Sincere@april.biz\",\r\n"
				+ "    \"address\": {\r\n"
				+ "      \"street\": \"Kulas Light\",\r\n"
				+ "      \"suite\": \"Apt. 556\",\r\n"
				+ "      \"city\": \"Gwenborough\",\r\n"
				+ "      \"zipcode\": \"92998-3874\",\r\n"
				+ "      \"geo\": {\r\n"
				+ "        \"lat\": \"-37.3159\",\r\n"
				+ "        \"lng\": \"81.1496\"\r\n"
				+ "      }\r\n"
				+ "    },\r\n"
				+ "    \"phone\": \"1-770-736-8031 x56442\",\r\n"
				+ "    \"website\": \"hildegard.org\",\r\n"
				+ "    \"company\": {\r\n"
				+ "      \"name\": \"Romaguera-Crona\",\r\n"
				+ "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\r\n"
				+ "      \"bs\": \"harness real-time e-markets\"\r\n"
				+ "    }\r\n"
				+ "  }";
	}
	
	
	public static String LibrryPostBody(String isbn , String aisle) {
		
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		
		
		
	}
	
public static String CreatAnIssueBody(String IssueName) {
		
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \""+IssueName+",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
