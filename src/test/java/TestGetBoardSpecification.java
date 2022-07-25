import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class TestGetBoardSpecification {

    private static RequestSpecBuilder reqBuilder;
    private static RequestSpecification reqSpec;

    private static final String TOKEN = "893e8772811a373d58941385e7dbcf078aed468bdfcc3d928cc17fdb898ff85d";
    private static final String KEY = "80c7807cd589566a018e51c3e1d911b8";
    private static final String BASE_URL = "https://api.trello.com/1";
    private static final String BASE_PATH = "/boards";
    String boardId = "/9r5rRtNU";

    private static String id;
    private static String boardName;
    private static String boardDescription;


    @BeforeAll
    public static void beforeAll(){
        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addQueryParam("key", KEY);
        reqBuilder.addQueryParam("token", TOKEN);
        reqSpec = reqBuilder.build();

    }


    @Test
    public void testGet() {

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + BASE_PATH + boardId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        id = json.getString("id");
        boardName = json.getString("name");
        boardDescription = json.getString("desc");

        Assertions.assertEquals("Trello Board", json.getString("name"));



        System.out.println("Board ID: "+ id + "\n" + "Board Name: " + boardName + "\n" + "Board description: " + boardDescription);
        System.out.println("Status Code: " + response.statusCode());

    }
}
