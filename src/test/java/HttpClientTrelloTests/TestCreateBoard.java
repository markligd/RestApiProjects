package HttpClientTrelloTests;

import RestAssuredTrelloTests.Utils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
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
                .addParameter("name", "New HttpClient Trello Board")
                .addParameter("key", Utils.KEY)
                .addParameter("token", Utils.TOKEN)
                .build();
        httpPost.setURI(uri);
        response = client.execute(httpPost);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        JSONObject jsonObj = new JSONObject(responseBody);
        System.out.println("Id of a Board: " + jsonObj.getString("id"));
        System.out.println("Name of a Board: " + jsonObj.getString("name"));
        System.out.println("Description of a Board: " + jsonObj.getString("desc"));

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        client.close();
    }
}