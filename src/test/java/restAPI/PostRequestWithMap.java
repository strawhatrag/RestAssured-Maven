package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	public void PostCall() {
	
	RestAssured.baseURI ="http://localhost:7000";
	
	RequestSpecification request = RestAssured.given();
	
	Map<String, Object> PostBody = new HashMap<String, Object>();
	PostBody.put("name","Virat");
	PostBody.put("Salary","3000");
	
	
	Response response  = request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(PostBody)
								.post("employees/create");
	String ResponseBody = response.body().asString();
	
	System.out.println(ResponseBody);
	
	
	int ActResponse = response.statusCode();
	int ExpResponse = 200;
	
	Assert.assertEquals(ActResponse, ExpResponse);

}
	
}
