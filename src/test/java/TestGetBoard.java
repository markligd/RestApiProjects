import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class TestGetBoard {



    private final String TOKEN = "893e8772811a373d58941385e7dbcf078aed468bdfcc3d928cc17fdb898ff85d";
    private final String KEY = "80c7807cd589566a018e51c3e1d911b8" ;
    private final String BASE_URL = "https://api.trello.com";

    @Test
    public void testGet(){

        RestAssured.baseURI = BASE_URL;
        given().log().all()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .contentType(ContentType.JSON)
                .when().get("/1/boards/9r5rRtNU")
                .then().log().body().assertThat().statusCode(200);

        System.out.println("Response Status Code: " + get().statusCode());
    }

}
