package com.revature.main;

import com.revature.actions.Fight;
import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;
import com.revature.dao.PlayerDAO;
import com.revature.dao.RoomDAO;
import com.revature.game.Game;
import com.revature.model.Monster;
import com.revature.model.Room;
import com.revature.util.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;

public class Main {

    public static final Logger log = Logger.getLogger(Main.class);
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) {
        Game game = new Game();


        RoomDAO roomDAO = new RoomDAO();
        MonsterDAO monsterDAO = new MonsterDAO();
        PlayerDAO playerDAO = new PlayerDAO();

        GenericArrayList allRooms = roomDAO.getAllRooms();
        GenericArrayList allMonsters = monsterDAO.getAllMonsters();
        GenericArrayList allPlayers = playerDAO.getAllPlayers();

        Monster monster1 = (Monster) allMonsters.getElementAtIndex(0);
        Monster monster2 = (Monster) allMonsters.getValueFromIndex(2);

        log.info("Monster 2 info: " + monster2.toString());

        log.info("Monster 1 info: " + monster1.toString());

        log.info(monsterDAO.getMonsterCount());
        log.info(playerDAO.getPlayerCount());

        Monster[] monsterArray = new Monster[monsterDAO.getMonsterCount()];

        monsterArray = (Monster[]) allMonsters.getGenericArray();

        String monsterType = monsterArray[0].getType_of_monster();
        log.info(monsterType);

        Monster monster3 = Monster.findByType("Skeleton");

        log.info(monster3.toString());

        Fight fight = new Fight();

        System.out.println(fight.getPlayer().getType_of_player());

    }
}
