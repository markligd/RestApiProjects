package RestAssuredTrelloTests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteBoard extends BaseTest {

    public static final String boardId = "5mV7ac2i";


    @Test
    public void testDelete() {
         given()
                .spec(reqSpec)
                .when()
                .delete(boardId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Response secondResponse = given()
                .spec(reqSpec)
                .when()
                .get(boardId)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response();

        Assert.assertEquals(404, secondResponse.getStatusCode());
        System.out.println(secondResponse.getStatusCode());



    }

}
