package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {


	@Test
	
	public void GetCall() {
		
		RestAssured.baseURI="http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response  = request.param("id","1").get("/employees");
		
		String ResponseBody = response.body().asString();
		
		System.out.println(ResponseBody);
		
		
		//==========verify the Response code==================
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		
		Assert.assertEquals(ActResponse, ExpResponse);
		
		//==========verify the header=========================
		//System.out.println(response.getHeaders());
		
		String ActHeader = response.getHeader("Content-Type");
		String ExpHeader = "application/json; charset=utf-8";
		
		Assert.assertEquals(ActHeader, ExpHeader);
		//==========verify the response body=========================
		
		Assert.assertTrue(ResponseBody.contains("Pankaj"));
		
		JsonPath jpath = response.jsonPath();
		
		List <String> Names = jpath.get("name");
		
		String ActName = Names.get(0);
		String ExpName = "Pankaj";
		
		Assert.assertEquals(ActName, ExpName);
		
		
		
		}
}