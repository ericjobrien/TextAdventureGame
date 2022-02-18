package com.revature.dao;

import com.revature.collections.GenericArrayList;
import com.revature.model.Room;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RoomDAO {

    Connection conn;
    public RoomDAO() {
        conn = ConnectionUtil.getConnection();
    }

    public GenericArrayList getAllRooms() {

        try {
            Statement statement = conn.createStatement();

            ResultSet rs2 = statement.executeQuery("SELECT COUNT(room_id) AS numberOfRooms FROM room");
            int roomCount = 0;
            while(rs2.next()) {
                roomCount = rs2.getInt("numberOfRooms");
            }

            Room[] rooms = new Room[roomCount];
            GenericArrayList genericArrayList = new GenericArrayList(rooms);

            ResultSet rs1 = statement.executeQuery("SELECT * FROM room");
            while(rs1.next()) {

                Room nextRoom = new Room(   rs1.getInt("room_id"),
                                            rs1.getString("name"),
                                            rs1.getString("description"),
                                            rs1.getString("north"),
                                            rs1.getString("east"),
                                            rs1.getString("south"),
                                            rs1.getString("west"));
                genericArrayList.addElement(nextRoom);
            }
            rs1.close();
            return genericArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
