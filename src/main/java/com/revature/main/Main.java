package com.revature.main;

import com.revature.dao.RoomDAO;
import com.revature.game.Game;
import com.revature.model.Room;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) {
//        Game game = new Game();
//        game.startGame();

        RoomDAO roomDAO = new RoomDAO();

        List<Room> allRooms = roomDAO.getAllRooms();

        System.out.println(allRooms.toString());


    }
}
