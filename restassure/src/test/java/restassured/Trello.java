package restassured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Trello {
	//need to give base url
	public static String baseurl = "https://api.trello.com/";
	private Object id;
	
	@Test(priority=0)
	public void createBoard()
	{//i want to fetch the base url so that i can add the rest of the urls onto it
	 //first step for adding base url
	 RestAssured.baseURI = baseurl;
	 
	 Response response = given().queryParam("name","automa1on")
	 .queryParam("key","97a110253d7fc8bb2323a4097eac580f")
	 .queryParam("token","fb7c0c22d17122007363fa02788d7cef3187217d6b8244383f70efda58600951")
	 .header("Content-Type","application/json")
	 
	 .when()
	 .post("1/boards/")
	 
	 .then()
	 .assertThat().statusCode(200).contentType(ContentType.JSON)
	 .extract().response();
	 String jsonresponse = response.asString();
	 JsonPath js = new JsonPath(jsonresponse);
	  id = js.get("id");
	}
   @Test(priority=1)
   public void getboard()
   {
	   RestAssured.baseURI = baseurl;
	   Response response =given()
	     .queryParam("key","97a110253d7fc8bb2323a4097eac580f")
		 .queryParam("token","fb7c0c22d17122007363fa02788d7cef3187217d6b8244383f70efda58600951")
		 .header("Content-Type","application/json")
		 .when()
		 .get("1/boards/"+id)
		 .then()
		 .assertThat().statusCode(200).contentType(ContentType.JSON)
		 .extract().response();
		 String jsonresponse = response.asString();
		 System.out.print(jsonresponse);
	   
   }
   @Test(priority = 2)
	public void DeleteBoard()
	{
		RestAssured.baseURI = baseurl;
		
		
	Response response =	given()
		.queryParam("key", "97a110253d7fc8bb2323a4097eac580f")
		.queryParam("token", "fb7c0c22d17122007363fa02788d7cef3187217d6b8244383f70efda58600951")
		.header("Content-Type","application/json")
		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		String jsonresponse = response.asString();
		
		System.out.println(jsonresponse);
	}
}
