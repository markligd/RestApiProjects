package RestAssuredTrelloTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestPutBoard extends BaseTest {

    public static final String boardId = "JF4FwK5E";



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
        Utils.id = json.getString("id");
        Utils.boardName = json.getString("name");
        Utils.boardDescription = json.getString("desc");

        Assert.assertEquals("Board testing PUT", Utils.boardDescription);

        System.out.println("Board ID: " + Utils.id + "\n" + "Board Name: " + Utils.boardName + "\n" + "Board description: " + Utils.boardDescription);
        System.out.println("Status Code: " + response.statusCode());

    }


}


