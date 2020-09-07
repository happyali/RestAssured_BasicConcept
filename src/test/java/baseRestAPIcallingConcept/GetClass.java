package baseRestAPIcallingConcept;

import org.testng.annotations.Test;

import apiAuthConcept.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

// npm install -g json-server
// json-server --watch db.json
// http://localhost:3000/posts/1

public class GetClass extends BaseClass {

	@Test
	public void testResponseCode() {
		System.out.println("==== In Response Code Test ====");
		Response resp = RestAssured.get("https://reqres.in/api/unknown");
		int code = resp.getStatusCode();
		System.out.println("Status code is " + code);
		Assert.assertEquals(200, code);
	}

	@Test
	public void testResponseBody() {
		System.out.println("==== In Response Body Test ====");
		Response resp = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println("Data is " + resp.getBody().jsonPath().prettify()); // To get response as Json Object

		System.out.println("Response time = " + resp.getTime());
	}

	@Test
	public void testCallResponse() {
		System.out.println("==== In Response Call Time Test ====");
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		int code = resp.getStatusCode();
		System.out.println("Status code is : " + code);
		Assert.assertEquals(200, code);
		String dataBody = resp.asString(); // To get response as String
		System.out.println("Data is : " + dataBody);
		System.out.println("Response time : " + resp.getTime());
	}

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		// OR Response response = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		// OR Response response = httpRequest.get("/Hyderabad");
		// Now let us print the body of the message to see what response
		// we have received from the server

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals("Response body contains Hyderabad",true, responseBody.toLowerCase().contains("hyDeraBad"));
		 
		// First get the JsonPath object instance from the Response interface
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		JsonPath JsonResponse = response.jsonPath();
		System.out.println("Response Body is =>  " + JsonResponse.get("City"));
		
		int statusCode = response.getStatusCode();
		// Assert that correct status code is returned.
		Assert.assertEquals("Correct status code returned", 200, statusCode);
		
		 // Get the status line from the Response and store it in a variable called statusLine
		 String statusLine = response.getStatusLine();
		 Assert.assertEquals("Correct status code returned",statusLine, "HTTP/1.1 200 OK");
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Type
		 String contentType = response.header("Content-Type");
		 System.out.println("Content-Type value: " + contentType);
		 Assert.assertEquals(contentType, "application/json");
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Server
		 String serverType =  response.header("Server");
		 System.out.println("Server value: " + serverType);
		 Assert.assertEquals(serverType, "nginx/1.12.1");
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Encoding
		 String acceptLanguage = response.header("Content-Encoding");
		 System.out.println("Content-Encoding: " + acceptLanguage);

		 Assert.assertEquals(acceptLanguage, "gzip");
		 
		 Headers allHeaders = response.headers();
		 // Iterate over all the Headers
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 }
		}
}

