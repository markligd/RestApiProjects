package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class TestDeleteBoard extends BaseTestHttpClient {

    public static final String boardId = "5XjlpXBh";

    @Test
    public void testDeleteBoard() throws URISyntaxException, IOException {
        HttpDelete httpDelete = new HttpDelete(Utils.BASE_URL + Utils.BASE_PATH + boardId);
        URI uri = new URIBuilder(httpDelete.getURI())
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .build();
        httpDelete.setURI(uri);
        httpDelete.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response = client.execute(httpDelete);

        //Get
        HttpGet httpGet = new HttpGet(Utils.BASE_URL + Utils.BASE_PATH + boardId);
        URI uri2 = new URIBuilder(httpGet.getURI())
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .build();
        httpGet.setURI(uri2);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response = client.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println("Response body: " + responseBody);

        Assert.assertEquals(404, response.getStatusLine().getStatusCode());
        System.out.println("Response Status Code: " + response.getStatusLine().getStatusCode());

        client.close();


    }
}
