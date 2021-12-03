package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
@Test
	
	public void PutCall() {
	
	RestAssured.baseURI = "http://localhost:7000";
		
	RequestSpecification PutRequest = RestAssured.given(); 
	
	Map<String, Object> PutBody = new HashMap<String, Object>();
	PutBody.put("name", "Rob");
	PutBody.put("salary", "3000");
	
	Response PutResponse = PutRequest.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(PutBody)
								.put("/employees/8");
	
	String ResponseBody = PutResponse.body().asString();
	
	System.out.println(ResponseBody);
		

		int ActResponse = PutResponse.statusCode();
		int ExpResponse = 200;
		
		Assert.assertEquals(ActResponse, ExpResponse);

	}

}
