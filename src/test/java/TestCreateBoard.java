import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestCreateBoard {


    @Test
    void testPost(){

        RestAssured.baseURI = "https://api.trello.com";
        given().log().all().queryParam("key", "80c7807cd589566a018e51c3e1d911b8")
                .queryParam("token", "893e8772811a373d58941385e7dbcf078aed468bdfcc3d928cc17fdb898ff85d")
                .queryParam("name", "Trello Board")
                .contentType(ContentType.JSON)
                .when().post("/1/boards/")
                .then().log().all().assertThat().statusCode(200);

        System.out.println("Response Status Code: " + get().statusCode());





}


}
