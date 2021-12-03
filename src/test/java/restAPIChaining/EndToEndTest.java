package restAPIChaining;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		//=========== Post Call ==============
		
		RequestSpecification PostRequest = RestAssured.given(); 
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "Gagan");
		PostBody.put("salary", "3000");
		
		Response PostResponse = PostRequest.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(PostBody)
									.post("/employees/create");
	
		String ResponseBody = PostResponse.body().asString();
		System.out.println(ResponseBody);
		
		JsonPath jpath = PostResponse.jsonPath();
        String ResponseID = jpath.get("id").toString();
        
        //=========== Put Call ================
        
        RequestSpecification PutRequest = RestAssured.given(); 
		
		Map<String, Object> PutBody = new HashMap<String, Object>();
		PutBody.put("name", "Rob");
		PutBody.put("salary", "3000");
		
		Response PutResponse = PutRequest.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(PutBody)
									.put("/employees/" + ResponseID);
		
		ResponseBody = PutResponse.body().asString();
		
		System.out.println(ResponseBody);
		
		
		//========== Delete Call ========
		
		RequestSpecification DeleteRequest = RestAssured.given();
		
		Response DeleteResponse = DeleteRequest.delete("/employees/" + ResponseID);
		
		int ActResponse = DeleteResponse.statusCode();
		int ExpResponse = 200;
		
		Assert.assertEquals(ActResponse, ExpResponse);
		
		// ======== Get Call =============
		
		RequestSpecification GetRequest = RestAssured.given();
		
		Response GetResponse = GetRequest.get("/employees/" + ResponseID);
		
		ActResponse = GetResponse.statusCode();
		ExpResponse = 404;
		
		Assert.assertEquals(ActResponse, ExpResponse);
			
	}
	

}


