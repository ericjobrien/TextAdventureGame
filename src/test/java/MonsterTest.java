import com.revature.dao.MonsterDAO;
import com.revature.model.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonsterTest {

    @Test
    public void getAllMonsters() {

        MonsterDAO monsterDAO = new MonsterDAO();
        int monsterCount = monsterDAO.getMonsterCount();

        Monster[] monsterArray = new Monster[monsterCount];

        Assertions.assertTrue(monsterArray.length == monsterCount);

    }
}
