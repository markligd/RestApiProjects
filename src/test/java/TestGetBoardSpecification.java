import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class TestGetBoardSpecification extends Utils {

    private static String id;
    private static String boardName;
    private static String boardDescription;
    public static final String boardId = "vBv8UutB";


    @Test
    public void testGet() {


        Response response = given()
                .spec(reqSpec)
                .when()
                .get(boardId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        //json.get();
        id = json.getString("id");
        boardName = json.getString("name");
        boardDescription = json.getString("desc");

        Assertions.assertEquals("Test Board", boardName);


        System.out.println("Board ID: " + id + "\n" + "Board Name: " + boardName + "\n" + "Board description: " + boardDescription);
        System.out.println("Status Code: " + response.statusCode());

    }


}
