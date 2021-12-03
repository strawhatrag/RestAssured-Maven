package restAPIBDD;

import java.util.HashMap;
import java.util.Map;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {

	
	@Test
	public void PutCall() {
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "alice");
		PostBody.put("salary", "3000");
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(PostBody)
					.when()
					.put("/employees/17")
					.then()
					.statusCode(200)
					.log()
					.all();
		}
}

