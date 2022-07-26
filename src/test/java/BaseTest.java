import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends Utils{
    public static RequestSpecification reqSpec;


    @BeforeAll
    public static void beforeAll() {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(BASE_URL);
        reqBuilder.setBasePath(BASE_PATH);
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addQueryParam("key", KEY);
        reqBuilder.addQueryParam("token", TOKEN);
        reqSpec = reqBuilder.build();

    }
}
