package RetrofitTrelloTests;

import JavaTests.Board;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TrelloRestApiTest extends BaseTestRetrofit{

    @Test
    public void creatingNewBoardTest() throws IOException {

        Board board = new Board();
        board.setName("NewRETROFITf");
        board.setDesc("This is new board!");
        board.setClosed(false);

        BoardService service = retrofit.create(BoardService.class);
        Call<Board> callSync = service.putBoard(key, token, board);

        Response<Board> response = callSync.execute();
        Board createdBoard = response.body();

        assertNotEquals(createdBoard, null);

        assertEquals(response.code(), 200);
        assertThat(createdBoard).hasFieldOrPropertyWithValue("name", board.getName())
                .hasFieldOrPropertyWithValue("desc", board.getDesc())
                .hasFieldOrPropertyWithValue("closed", board.getClosed());
    }
}
