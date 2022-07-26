import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDeleteBoard extends BaseTest {

    public static final String boardId = "vBv8UutB";


    @Test
    @Order(1)
    public void testDelete() throws InterruptedException {
        Response response = given()
                .spec(reqSpec)
                .when()
                .delete(boardId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();


        JsonPath json = response.jsonPath();
        id = json.getString("id");
        boardName = json.getString("name");
        boardDescription = json.getString("desc");

        System.out.println("Board ID after deleting: " + id + "\n" + "Board Name after deleting: " + boardName + "\n" + "Board description after deleting: " + boardDescription);

    }

    @Test
    @Order(2)
    public void testOfDeletedBoard() {
        Response response = given()
                .spec(reqSpec)
                .when()
                .get(boardId)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response();

        System.out.println("Status code after deleting: "+ response.getStatusCode());
        Assertions.assertEquals(404, response.getStatusCode());


    }
}
