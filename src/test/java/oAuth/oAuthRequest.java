package oAuth;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class oAuthRequest {

	@Test
	public void PostCall() {
		
		RestAssured.given()
					.auth()
					.oauth2("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")
					.baseUri("https://api.github.com")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body("{\r\n"
							+ "    \"name\": \"PostmanTest124\",\r\n"
							+ "    \"desription\": \"Test Repo\",\r\n"
							+ "    \"homepage\": \"https://github.com/\",\r\n"
							+ "    \"private\": false,\r\n"
							+ "    \"has_issues\": true,\r\n"
							+ "    \"has_projects\": true,\r\n"
							+ "    \"has_wiki\": true\r\n"
							+ "}")
					.when()
					.post("/user/repos")
					.then()
					.statusCode(201)
					.log()
					.all();
		}
}