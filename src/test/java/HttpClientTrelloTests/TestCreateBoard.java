package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;


public class TestCreateBoard extends BaseTestHttpClient {


    @Test
    public void testPostBoard() throws URISyntaxException, IOException {
        HttpPost httpPost = new HttpPost(Utils.BASE_URL + Utils.BASE_PATH);
        URI uri = new URIBuilder(httpPost.getURI())
                .addParameter("name", "newboard4")
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .build();
        httpPost.setURI(uri);
        response = client.execute(httpPost);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println("Response body: " + responseBody);
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(responseBody);


        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

        client.close();
    }
}