package baseRestAPIcallingConcept;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

	// npm install -g json-server
	// json-server --watch db.json
	// http://localhost:3000/posts/1

	public class PostClass {

		@Test
		public void postCall() {

			System.out.println("==== In Post Call Test ====");
			RequestSpecification request=RestAssured.given();
			request.header("Content-Type","application/json");
			
			JSONObject jsonBody=new JSONObject();
			jsonBody.put("name","Test");
			jsonBody.put("job","Test 1");
			
			request.body(jsonBody.toJSONString());
			
			Response response=request.post("https://reqres.in/api/users");
			
			int code=response.getStatusCode();
			Assert.assertEquals(201, code);
			System.out.println("The response is: "+response.getBody().jsonPath().prettify());
			
		}
	
}
