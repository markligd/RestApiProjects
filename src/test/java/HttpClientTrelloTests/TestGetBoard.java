package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class TestGetBoard extends BaseTestHttpClient {

    public static final String boardId = "ZLDQpn1L";


    @Test
    public void testGetBoard() throws URISyntaxException, IOException {
        HttpGet httpGet = new HttpGet(Utils.BASE_URL + Utils.BASE_PATH + boardId);
        URI uri = new URIBuilder(httpGet.getURI())
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .build();

        httpGet.setURI(uri);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response = client.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println("Response body: " + responseBody);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        client.close();

    }
}


