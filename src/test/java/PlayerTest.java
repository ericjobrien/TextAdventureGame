import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;
import com.revature.dao.PlayerDAO;
import com.revature.model.Monster;
import com.revature.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static final PlayerDAO PLAYER_DAO = new PlayerDAO();
    private static final int PLAYER_COUNT = PLAYER_DAO.getPlayerCount();
    private static final GenericArrayList ALL_PLAYERS = PLAYER_DAO.getAllPlayers();
    private static final Player[] PLAYER_ARRAY = (Player[]) ALL_PLAYERS.getGenericArray();


    @Test
    public void checkPlayerCount() {

        Assertions.assertTrue(PLAYER_ARRAY.length == PLAYER_COUNT);

    }

    @Test
    public void PlayersAreLoadingIntoGame() {

        String playerType = "";

        for (Player player : PLAYER_ARRAY) {
            playerType = player.getType_of_player();
            Assertions.assertTrue(!playerType.equals(null));
        }

    }

}
