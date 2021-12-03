package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {

	@Test
	public void GetCall() {
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.when()
					.get("/employees")
					.then()
					.statusCode(200)
					.body("[0].name", Matchers.equalTo("Pankaj"))
					.body("[0].salary", Matchers.equalTo("10000"))
					.log()
					.all();
		}
}
