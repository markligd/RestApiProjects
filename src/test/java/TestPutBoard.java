import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class TestPutBoard extends Utils {

    public static final String boardId = "CcmMrthl";



    @Test
    public void testPut() {

        Response response = given()
                .spec(reqSpec)
                .queryParam("desc", "Board testing PUT")
                .when()
                .put(boardId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        id = json.getString("id");
        boardName = json.getString("name");
        boardDescription = json.getString("desc");

        Assertions.assertEquals(boardDescription, "Board testing PUT");

        System.out.println("Board ID: " + id + "\n" + "Board Name: " + boardName + "\n" + "Board description: " + boardDescription);
        System.out.println("Status Code: " + response.statusCode());

    }


}


