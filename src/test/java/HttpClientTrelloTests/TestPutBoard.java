package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class TestPutBoard extends BaseTestHttpClient {

    public static final String boardId = "r9puEYA5";

    @Test
    public void testGetBoard() throws URISyntaxException, IOException {
        HttpPut httpPut = new HttpPut(Utils.BASE_URL + Utils.BASE_PATH + boardId);
        URI uri = new URIBuilder(httpPut.getURI())
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .addParameter("desc", "This is a new trello board!")
                .build();
        httpPut.setURI(uri);
        httpPut.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response = client.execute(httpPut);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        JSONObject jsonObj = new JSONObject(responseBody);
        System.out.println("Id of a Board: " + jsonObj.getString("id"));
        System.out.println("Name of a Board: " + jsonObj.getString("name"));
        System.out.println("Description of a Board: " + jsonObj.getString("desc"));


        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        client.close();

    }
}
