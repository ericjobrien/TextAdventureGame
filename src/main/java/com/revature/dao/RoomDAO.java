package com.revature.dao;

import com.revature.model.Room;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    Connection conn;
    public RoomDAO() {
        conn = ConnectionUtil.getConnection();
    }

    public List<Room> getAllRooms() {

        List<Room> allRooms = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM room");
            while(rs.next()) {
                Room nextRoom = new Room(   rs.getInt("room_id"),
                                            rs.getString("name"),
                                            rs.getString("description"),
                                            rs.getString("north"),
                                            rs.getString("east"),
                                            rs.getString("south"),
                                            rs.getString("west"));
                allRooms.add(nextRoom);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allRooms;
    }
}
