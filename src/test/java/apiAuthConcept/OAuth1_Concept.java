package apiAuthConcept;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth1_Concept {
// To test this you need to Create an Twitter Developer account
// And note the API KEY, API SECRET, CONSUMER KEY, CONSUMER SECRET
    
	String tweetId;
	
	@Test
	public void postTweet() {
			Response resp=RestAssured.given()
				.auth()
				.oauth("SDKjf84490sDKJFSld9485lsfs",
						"ASE45543-kjsdfSdsnf4235FJNSI4",
						"JSkdi495sfdsSD84fgsjd43asdfkldjtW4Sdgst45s",
						"lksjdfw454esDFgr654wDFy6rssdrhy5y5")
				.post("https://api.twitter.com/1.1/statuses/update.josn?status=This is my tweet using API");
// Parameters:
//			consumerKey, consumerSecret, accessToken, secretToken,
// 			Returns: The request io.restassured.specification		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		
		JsonPath json=resp.jsonPath();		
		tweetId=json.get("id_str");		
		System.out.println("My Tweet id is "+tweetId);
	}
	
	@Test
	public void deleteTweet() {
		Response resp=RestAssured.given()
				.auth()
				.oauth("SDKjf84490sDKJFSld9485lsfs",
						"ASE45543-kjsdfSdsnf4235FJNSI4",
						"JSkdi495sfdsSD84fgsjd43asdfkldjtW4Sdgst45s",
						"lksjdfw454esDFgr654wDFy6rssdrhy5y5")
				.post("https://api.twitter.com/1.1/statuses/destroy/"+tweetId+".json");
				
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());	
		System.out.println("My Tweet is deleted");
	}

}
