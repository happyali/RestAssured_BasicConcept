package apiAuthConcept;
// This is based on DOCKER of JIRA CORE which require cookie based authentication.
// Google Search "docker jira" --> https://hub.docker.com/r/cptactionhank/atlassian-jira/
// Atlassian Core is required for this testing
// docker run --detach --publish XxxX:8080 cptactionhank/atlassian-jira:latest
// where XxxX is port number to be used

// To get the JIRA API: Google Search : "JIRA session cookie api"
// "https://developer.atlassian.com/server/jira/platform/cookie-based-authentication"

// Check the payload under test at the end of this test

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CookieBasedAuth {
	
	@Test
	public void createJsessionId() {
		JSONObject json=new JSONObject();
		json.put("username", "happyali");   // This local user credentials
		json.put("password", "abcd@1234");  // from docker jira core instance
		
		// First create the JSESSION id for docker JIRA core instance with 
		// user created in Docker Jira instance.
		// This user wont be actual JIRA user, it will just local docker Jira user
		Response resp=RestAssured.given()
				.header("Content-Type", "application/json")
				.body(json)
				.post("http://localhost:8086/rest/auth/1/session");
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		String sessionID=resp.getCookies().get("JSEESIONID");
 
		// Create issue in docker JIRA Core
		Response response=RestAssured.given()
				.contentType(ContentType.JSON) // another method to provide header
				.cookie("JSESSIONID",sessionID)
				.body("{\"fields\":{\"project\": {\"key\": \"Proj_Name\"},\"summary\": \"This is crated using API\",\"description\": \"Creating an issue using project key-issue name via API\",\"issuetype\": {\"name\": \"TASK\"}}}")
				.post("http://localhost:8086/rest/api/2/issue");
		System.out.println(response.getBody().jsonPath().prettify());
}
	
	
/* {
	"fields":{
	"project": {
	"key": "TEST"
	},
	"summary": "This is created using API",
	"description": "Creating an issue using project key-issue name via API",
	"issuetype": {
		"name": "TASK"
	}
	}
}
*/
















	}