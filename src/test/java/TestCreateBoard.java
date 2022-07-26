import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestCreateBoard extends Utils {


    @Test
    void testPost() {

        Response response = given()
                .spec(reqSpec)
                .queryParam("name", "Trello Forest")
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        //json.get();
        id = json.getString("id");
        boardName = json.getString("name");
        boardDescription = json.getString("desc");

        Assertions.assertEquals("Trello Forest", boardName);


        System.out.println("Board ID: " + id + "\n" + "Board Name: " + boardName + "\n" + "Board description: " + boardDescription);
        System.out.println("Status Code: " + response.statusCode());


    }


}
