package apiAuthConcept;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
//npm install -g json-server
//json-server --watch db.json
//http://localhost:3000/posts/1

// for OAuth1.0 (tweeter API) concept: 
// Refer "developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/"


// for OAuth2.0 ( ) concept:
// Refer "coop.apps.symfonycasts.com"


public class BaseClass {
	
	@BeforeClass
	public void setup() {
		RestAssured.authentication=RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckforAuthentication";		
	}
	
}
	