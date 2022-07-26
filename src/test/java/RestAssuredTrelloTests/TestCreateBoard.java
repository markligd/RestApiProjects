package RestAssuredTrelloTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCreateBoard extends BaseTest {


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
        Utils.id = json.getString("id");
        Utils.boardName = json.getString("name");
        Utils.boardDescription = json.getString("desc");

        Assert.assertEquals("Trello Forest", Utils.boardName);


        System.out.println("Board ID: " + Utils.id + "\n" + "Board Name: " + Utils.boardName + "\n" + "Board description: " + Utils.boardDescription);
        System.out.println("Status Code: " + response.statusCode());


    }


}
