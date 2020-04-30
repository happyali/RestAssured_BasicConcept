package PojoConcept;
//This is based on DOCKER of JIRA CORE which require cookie based authentication.
//Google Search "docker jira" --> https://hub.docker.com/r/cptactionhank/atlassian-jira/
//Atlassian Core is required for this testing
//docker run --detach --publish XxxX:8080 cptactionhank/atlassian-jira:latest
//where XxxX is port number to be used

//To get the JIRA API: Google Search : "JIRA session cookie api"
//"https://developer.atlassian.com/server/jira/platform/cookie-based-authentication"

//Check the payload under test at the end of this test

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CookieBasedAuthPojo {

	@Test
	public void createJsessionId() {
	
		JSONObject json=new JSONObject();
		json.put("username", "happyali");
		json.put("password", "abcd@1234");
		
		Response resp=RestAssured.given()
				.header("Content-Type", "application/json")
				.body(json)
				.post("http://locahost:8086/rest/auth/1/session");
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		String sessionID=resp.getCookies().get("JSEESIONID");
 
		IssueType issue=new IssueType("Task");
		Projects project=new Projects("Project_name");
		Payload internalload=new Payload("Summary Demo", " Demo Description", issue, project);
		Fields finalload=new Fields(internalload);
		
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.cookie("JSESSIONID",sessionID)
				.body(finalload)
				.post("http://locahost:8086/rest/api/2/issue");
		System.out.println(response.getBody().jsonPath().prettify());
}
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

