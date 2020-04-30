package apiAuthConcept;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthConcept { //extends BaseClass {
	
	@Test
	public void basicWay() {
		int code=RestAssured.given()
				.auth().preemptive()
				.basic("ToolsQA", "TestPassword")
				.when()
				.get("http://restapi.demoqa.com/quthentication/CheckforAuthentication/")
				.getStatusCode();
		System.out.println("Basic Auth Concept : Response Code: "+code);
	}

	
	
//	If you want to pass the credentials and basic url from BASE class then
// create a BASE CLASS and extend here
	
//	@Test
//	public void newAuthCheck() {
//		int code=RestAssured.given()
//				.get()
//				.getStatusCode();
//		
//		System.out.println("Newway : Response code: "+code);
//	}

}
