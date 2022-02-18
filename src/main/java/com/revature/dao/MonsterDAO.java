package com.revature.dao;

import com.revature.collections.GenericArrayList;
import com.revature.model.Monster;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MonsterDAO {

    Connection conn;

    public MonsterDAO() {
        conn = ConnectionUtil.getConnection();
    }

    public GenericArrayList getAllMonsters() {


        int monsterCount = 0;
        try {
            Statement statement1;
            statement1 = conn.createStatement();
            ResultSet rs1 = statement1.executeQuery("SELECT COUNT(monster_id) AS numberOfMonsters FROM monster");

            while(rs1.next()) {
                monsterCount = rs1.getInt("numberOfMonsters");
            }
            rs1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Monster[] monsterArray = new Monster[monsterCount];
        GenericArrayList genericArrayList = new GenericArrayList(monsterArray);

        try {
            Statement statement2 = conn.createStatement();
            ResultSet rs2 = statement2.executeQuery("SELECT * FROM monster");
            while (rs2.next()) {
                Monster nextMonster = new Monster(  rs2.getInt("monster_id"),
                                                    rs2.getString("type_of_monster"),
                                                    rs2.getInt("max_health"),
                                                    rs2.getInt("current_health"),
                                                    rs2.getInt("potion_drop_chance"));

                genericArrayList.addElement(nextMonster);
            }
            rs2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return genericArrayList;
    }

    public int getMonsterCount() {

        int monsterCount = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(monster_id) AS numberOfMonsters FROM monster");
            while (rs.next()) {
                monsterCount = rs.getInt("numberOfMonsters");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monsterCount;
    }
}
