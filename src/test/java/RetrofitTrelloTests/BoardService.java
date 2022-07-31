package RetrofitTrelloTests;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BoardService {

    @POST("/1/boards/")
    public Call<BoardForTests> putBoard(
            @Query("key") String key,
            @Query("token") String token,
            @Body BoardForTests board
    );
}
