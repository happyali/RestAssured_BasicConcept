package baseRestAPIcallingConcept;

import org.testng.annotations.Test;

import apiAuthConcept.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

// npm install -g json-server
// json-server --watch db.json
// http://localhost:3000/posts/1


public class GetClass extends BaseClass {	

	@Test
	public void testResponseCode () {
		System.out.println("==== In Response Code Test ====");
			Response resp =RestAssured.get("https://reqres.in/api/unknown");
			int code=resp.getStatusCode();		
		System.out.println("Status code is "+code);
			Assert.assertEquals(200, code);
	}
	
	@Test
	public void testResponseBody () {
		System.out.println("==== In Response Body Test ====");
			Response resp =RestAssured.get("https://reqres.in/api/users/2");
		System.out.println("Data is "+resp.getBody().jsonPath().prettify()); // To get response as Json Object
		
		System.out.println("Response time = "+resp.getTime());
	}
	
	@Test
	public void testCAllResponse () {
		System.out.println("==== In Response Call Time Test ====");
			Response resp =RestAssured.get("https://reqres.in/api/users?page=2");
			int code=resp.getStatusCode();		
		System.out.println("Status code is : "+code);
			Assert.assertEquals(200, code);
			String dataBody=resp.asString();		// To get response as String
		System.out.println("Data is : "+dataBody);		
		System.out.println("Response time : "+resp.getTime());
	}
}
