package RestAssuredTrelloTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestGetBoardSpecification extends BaseTest {


    public static final String boardId = "JF4FwK5E";


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
        Utils.id = json.getString("id");
        Utils.boardName = json.getString("name");
        Utils.boardDescription = json.getString("desc");

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("Trello Forest", Utils.boardName);
        Assert.assertEquals("Board testing PUT", Utils.boardDescription);



        System.out.println("Board ID: " + Utils.id + "\n" + "Board Name: " + Utils.boardName + "\n" + "Board description: " + Utils.boardDescription);
        System.out.println("Status Code: " + response.statusCode());

    }


}
