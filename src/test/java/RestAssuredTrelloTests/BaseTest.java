package RestAssuredTrelloTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static RequestSpecification reqSpec;


    @BeforeSuite
    public static void beforeAll() {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(Utils.BASE_URL);
        reqBuilder.setBasePath(Utils.BASE_PATH);
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addQueryParam("key", Utils.KEY);
        reqBuilder.addQueryParam("token", Utils.TOKEN);
        reqSpec = reqBuilder.build();

    }
}
