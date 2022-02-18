package com.revature.main;

import com.revature.collections.GenericArrayList;
import com.revature.dao.RoomDAO;
import com.revature.game.Game;
import com.revature.model.Room;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;

public class Main {
    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) {
//        Game game = new Game();
//        game.startGame();

        RoomDAO roomDAO = new RoomDAO();

        GenericArrayList allRooms = roomDAO.getAllRooms();

        GenericArrayList.genericToString(allRooms);


    }
}
