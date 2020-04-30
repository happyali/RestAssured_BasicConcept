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

	public class PutClass {

		@Test
		public void postCall() {
	
			RequestSpecification request=RestAssured.given();
			request.header("Content-Type","application/json");
			
			JSONObject jsonBody=new JSONObject();
			jsonBody.put("name","Test");
			jsonBody.put("job","Test 01");
			
			request.body(jsonBody.toJSONString());
			
			Response response=request.put("https://reqres.in/api/users/2");
			
			int code=response.getStatusCode();
			Assert.assertEquals(200, code);
			System.out.println("The response is: "+response.getBody().jsonPath().prettify());
			
		}
	
}
