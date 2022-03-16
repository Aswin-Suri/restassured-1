package restassured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Ecommerce {
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	private Object AccessToken;
	@Test(priority=0)
	public void createcustomer()
	{RestAssured.baseURI = baseurl;
	
	String RequestBody = "{\n"
			+ "	\"email\": \"rosdduhnnjobakahd@gmail.com\",\n"
			+ "	\"password\": \"welcome\"\n"
			+ "}";
	 Response responses = given()
			 .header("Content-Type","application/json")
			 .body(RequestBody)
			 
			 .when()
			 .post("/user/signup") 
			 
			 .then()
				.assertThat().statusCode(201).contentType(ContentType.JSON)
				.extract().response();

	String jsonresponse = responses.asString();
	JsonPath js = new JsonPath(jsonresponse);
		Object message = js.get("message");
		System.out.println(message);
		
	}
	@Test(priority=1)
	public void login()
	{RestAssured.baseURI = baseurl;
	String RequestBody = "{\n"
			+ "	\"email\": \"broderdhd@gmail.com\",\n"
			+ "	\"password\": \"welcome\"\n"
			+ "}";
	Response responses = given()
			 .header("Content-Type","application/json")
			 .body(RequestBody)
			 
			 .when()
			 .post("/user/login") 
			 
			 .then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();
	String jsonresponse = responses.asString();
	JsonPath js = new JsonPath(jsonresponse);
		 AccessToken = js.get("accessToken");
		System.out.println(AccessToken);
	}

}
