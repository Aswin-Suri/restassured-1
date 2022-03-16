package restassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class trellosecond {
	public static String baseurl = "https://api.trello.com/";
	@Test(priority=0)
	public void createboard()
	{RestAssured.baseURI = baseurl;
	given().queryParam("name","automa1on")
	 .queryParam("key","97a110253d7fc8bb2323a4097eac580f")
	 .queryParam("token","fb7c0c22d17122007363fa02788d7cef3187217d6b8244383f70efda58600951")
	 .header("Content-Type","application/json")
	 .when()
	 .post("1/boards/")
	 
	 .then()
	 .assertThat().statusCode(200).contentType(ContentType.JSON)
	 .extract().response();
	}
	@Test(priority=1)
	public void getboard()
	{RestAssured.baseURI = baseurl;
	given()
    .queryParam("key","97a110253d7fc8bb2323a4097eac580f")
	 .queryParam("token","fb7c0c22d17122007363fa02788d7cef3187217d6b8244383f70efda58600951")
	 .header("Content-Type","application/json")
	 .when()
	 .get("1/boards/nqXI01Z9")
	 .then()
	 .assertThat().statusCode(200).contentType(ContentType.JSON)
	 .extract().response();
	}
}
