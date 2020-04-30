package apiAuthConcept;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class OAuth2_Concept {
// Here you need to register in http://coop.apps.symfonycasts.com
	String token;
	
	public String generateToken(String clientId, String clientSecret, String grantType, String testUrl) {
		Response respToken=RestAssured.given()
				.formParam("client_id", clientId)
				.formParam("client_secret", clientSecret)
				.formParam("grant_type", grantType)
				.post(testUrl);
		token=respToken.jsonPath().get("access_token");		
		return token;		
	}
	
	@Test
	public void accessAuthorisedEndpoint() {
		
//		Same token can be generated in the method itself.
//		Response respToken=RestAssured.given()
//				.formParam("client_id", "TestApplication")
//				.formParam("client_secret", "718c77143ff0c2f459114c0b1f60bfe2")
//				.formParam("grant_type", "client_credentials")
//				.post("http://coop.apps.symfonycasts.com/token");
//		String token=respToken.jsonPath().get("access_token");
		
		generateToken("TestApplication", "618c66143ff0c2f459114c0b1f60bfe2", "client_credentials", "http://coop.apps.symfonycasts.com/token");
		
		Response resp=RestAssured.given()
				.auth()
				.oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/960/chickens-feed");
				
				Assert.assertEquals(200, resp.getStatusCode());
	}

	@Test
	// Here I don't have access to end point "/eggs-collect"
	public void accessUnAuthorisedEndpoint() {
		
		generateToken("TestApplication", "618c66143ff0c2f459114c0b1f60bfe2", "client_credentials", "http://coop.apps.symfonycasts.com/token");
			
		Response resp=RestAssured.given()
				.auth()
				.oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/960/eggs-collect");
				
				Assert.assertEquals(401, resp.getStatusCode());
	}
}
