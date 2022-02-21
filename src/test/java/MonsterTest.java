import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;
import com.revature.model.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonsterTest {

    private static final MonsterDAO MONSTER_DAO = new MonsterDAO();
    private static final int MONSTER_COUNT = MONSTER_DAO.getMonsterCount();
    private static final GenericArrayList ALL_MONSTERS = MONSTER_DAO.getAllMonsters();
    private static final Monster[] MONSTER_ARRAY = (Monster[]) ALL_MONSTERS.getGenericArray();


    @Test
    public void checkMonsterCount() {

        Assertions.assertTrue(MONSTER_ARRAY.length == MONSTER_COUNT);

    }

    @Test
    public void monstersAreLoadingIntoGame() {

        String monsterType = "";

        for (Monster monster : MONSTER_ARRAY) {
            monsterType = monster.getType_of_monster();
            Assertions.assertTrue(!monsterType.equals(null));
        }

    }

}
