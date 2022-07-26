import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;


public class Utils {


    public static RequestSpecification reqSpec;

    public static final String TOKEN = "893e8772811a373d58941385e7dbcf078aed468bdfcc3d928cc17fdb898ff85d";
    public static final String KEY = "80c7807cd589566a018e51c3e1d911b8";
    public static final String BASE_URL = "https://api.trello.com/1";
    public static final String BASE_PATH = "/boards";


    public static String id;
    public static String boardName;
    public static String boardDescription;


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