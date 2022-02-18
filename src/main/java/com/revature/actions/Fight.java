package com.revature.actions;

import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;
import com.revature.dao.PlayerDAO;
import com.revature.model.Monster;
import com.revature.model.Player;

import java.util.Random;

public class Fight {

    Monster monster;
    Player player;
    Random fightChance;
    Random dropPotionChance;

    public Fight(Monster monster, Player player) {
        this.monster = monster;
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "monster=" + monster +
                ", player=" + player +
                '}';
    }

    public void startFight(Player player, Monster monster) {

        MonsterDAO monsterDAO = new MonsterDAO();
        PlayerDAO playerDAO = new PlayerDAO();

        GenericArrayList allMonsters = monsterDAO.getAllMonsters();
        GenericArrayList allPlayers = playerDAO.getAllPlayers();
    }


}
