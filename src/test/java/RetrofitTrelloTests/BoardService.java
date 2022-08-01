package RetrofitTrelloTests;

import JavaTests.Board;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BoardService  {

    @POST("/1/boards/")
    public Call<Board> putBoard(
            @Query("key") String key,
            @Query("token") String token,
            @Body Board board
    );
}
