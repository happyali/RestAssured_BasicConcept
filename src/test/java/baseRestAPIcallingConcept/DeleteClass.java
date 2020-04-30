package baseRestAPIcallingConcept;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteClass {
	

	@Test
	public void deleteCall() {
		RequestSpecification request=RestAssured.given();
		Response response=request.delete("https://reqres.in/api/users/2");
		
		int code=response.getStatusCode();
		Assert.assertEquals(204, code);
		
	}
}
