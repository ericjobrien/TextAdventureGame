package com.revature.dao;

import com.revature.collections.GenericArrayList;
import com.revature.model.Player;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDAO {

    Connection conn;

    public PlayerDAO() {
        conn = ConnectionUtil.getConnection();
    }

    public GenericArrayList getAllPlayers() {


        int playerCount = 0;

        try {
            Statement statement1 = conn.createStatement();
            ResultSet rs1 = statement1.executeQuery("SELECT COUNT(player_id) AS numberOfPlayers FROM player");
            while (rs1.next()) {
                playerCount = rs1.getInt("numberOfPlayers");
            }
            rs1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Player[] playerArray = new Player[playerCount];
        GenericArrayList genericArrayList = new GenericArrayList(playerArray);

        try {
            Statement statement2 = conn.createStatement();
            ResultSet rs2 = statement2.executeQuery("SELECT * FROM player");
            while (rs2.next()) {
                Player nextPlayer = new Player( rs2.getInt("player_id"),
                                                rs2.getString("type_of_player"),
                                                rs2.getInt("max_health"),
                                                rs2.getInt("current_health"),
                                                rs2.getInt("health_potion_amount"));

                genericArrayList.addElement(nextPlayer);
            }
            rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genericArrayList;
    }

    public int getPlayerCount() {

        int playerCount = 0;

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(player_id) AS numberOfPlayers FROM player");
            while(rs.next()) {
                playerCount = rs.getInt("numberOfPlayers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playerCount;
    }
}
