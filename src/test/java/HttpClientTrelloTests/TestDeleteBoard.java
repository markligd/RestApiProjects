package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class TestDeleteBoard extends BaseTestHttpClient{

    public static final String boardId = "wTCTc0EN";

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

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println("Response body: " + responseBody);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        client.close();

    }
}
