package RetrofitTrelloTests;

import RestAssuredTrelloTests.Utils;
import okhttp3.OkHttpClient;
import org.testng.annotations.BeforeClass;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTestRetrofit extends Utils {

    String key;
    String token;
    Retrofit retrofit;

    @BeforeClass
    public void init() {

        Properties properties = new Properties();
        String pathToFile = "src/main/resources/trello.properties";

        try {
            properties.load(new FileInputStream(pathToFile));
            key = properties.getProperty("key");
            token = properties.getProperty("token");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://trello.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

}
