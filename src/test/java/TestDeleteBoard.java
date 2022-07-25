import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestDeleteBoard {

    @Test
    public void testDelete(){
        RestAssured.baseURI = "https://api.trello.com";
        given().log().all().queryParam("key", "80c7807cd589566a018e51c3e1d911b8")
                .queryParam("token", "893e8772811a373d58941385e7dbcf078aed468bdfcc3d928cc17fdb898ff85d")
                .contentType(ContentType.JSON)
                .when().delete("/1/boards/kiBE1t1J")
                .then().log().body().assertThat().statusCode(200);

        System.out.println("Response Status Code: " + get().statusCode());
    }
}
