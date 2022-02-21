package com.revature.actions;

import com.revature.collections.GenericArrayList;
import com.revature.dao.RoomDAO;
import com.revature.model.Player;
import com.revature.model.Room;

import java.util.Random;
import java.util.Scanner;

public class Move {


    private Scanner scanner = new Scanner(System.in);
    private Random rand;
    private RoomDAO roomDAO = new RoomDAO();
    private GenericArrayList allRooms = roomDAO.getAllRooms();
    private Room[] roomArray = (Room[]) allRooms.getGenericArray();

    private static Room currentRoom;

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public RoomDAO getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public GenericArrayList getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(GenericArrayList allRooms) {
        this.allRooms = allRooms;
    }

    public Room[] getRoomArray() {
        return roomArray;
    }

    public void setRoomArray(Room[] roomArray) {
        this.roomArray = roomArray;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
        return newRoom;
    }

    public static String moveDirection(Character direction, Room room) {

        if(direction.equals('N')) {
            return room.getNorth();
        } else if(direction.equals('E')) {
            return room.getEast();
        } else if(direction.equals('S')) {
            return room.getSouth();
        } else if(direction.equals('W')) {
            return room.getWest();
        } else {
            return "Not a valid direction";
        }
    }

    public void moveNorth() {

        Room[] roomArray = this.roomArray;
        Room currentRoom = this.currentRoom;
        Room previousRoom;
        Move move = new Move();

        if(currentRoom.getNorth().equals("No Exit")) {
            System.out.println("\t " + currentRoom.getNorth());
        } else {
            previousRoom = currentRoom;
            currentRoom = Room.getRoomByName(currentRoom.getNorth());
            Move.currentRoom = currentRoom;
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t You have moved to a new room.");
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t " + currentRoom.getDescription());
        }
    }

    public void moveEast() {

        Room[] roomArray = this.roomArray;
        Room currentRoom = this.currentRoom;

        Room previousRoom;

        Move move = new Move();

        if(currentRoom.getEast().equals("No Exit")) {
            System.out.println("\t " + currentRoom.getEast());
        } else {
            previousRoom = currentRoom;
            currentRoom = Room.getRoomByName(currentRoom.getEast());
            Move.currentRoom = currentRoom;
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t You have moved to a new room.");
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t " + currentRoom.getDescription());
        }
    }

    public void moveSouth() {

        Room[] roomArray = this.roomArray;
        Room currentRoom = this.currentRoom;

        Room previousRoom;

        Move move = new Move();

        if(currentRoom.getSouth().equals("No Exit")) {
            System.out.println("\t " + currentRoom.getSouth());
        } else {
            previousRoom = currentRoom;
            currentRoom = Room.getRoomByName(currentRoom.getSouth());
            Move.currentRoom = currentRoom;
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t You have moved to a new room.");
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t " + currentRoom.getDescription());
        }
    }

    public void moveWest() {

        Room[] roomArray = this.roomArray;
        Room currentRoom = this.currentRoom;

        Room previousRoom;

        Move move = new Move();

        if(currentRoom.getWest().equals("No Exit")) {
            System.out.println("\t " + currentRoom.getWest());
        } else {
            previousRoom = currentRoom;
            currentRoom = Room.getRoomByName(currentRoom.getWest());
            Move.currentRoom = currentRoom;
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t You have moved to a new room.");
            System.out.println("\t --------------------------------------------------------");
            System.out.println("\t " + currentRoom.getDescription());
        }
    }

    public void move() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("--------------------------------------------------------");
        Thread.sleep(500);
        System.out.println("\t You have chosen to move.");
        Thread.sleep(500);
        System.out.println("\t Which direction would you like to move?");
        Thread.sleep(500);
        System.out.println("\t Type N for north, E for east, S for south, W for west");

        Character moveValue = scanner.nextLine().toUpperCase().charAt(0);
        Room[] roomArray = this.roomArray;
        Room previousRoom;


        try {
            while(true) {
                Move move = new Move();
                Room currentRoom = this.getCurrentRoom();
                if(moveValue.equals('N')) {
                    move.moveNorth();
                    break;
                } else if(moveValue.equals('E')) {
                    move.moveEast();
                    break;
                } else if(moveValue.equals('S')) {
                    move.moveSouth();
                    break;
                } else if(moveValue.equals('W')) {
                    move.moveWest();
                    break;
                } else {
                    System.out.println("\t Please enter a valid direction");
                    System.out.println("\t Type N for north, E for east, S for south, W for west");
                    moveValue = scanner.nextLine().charAt(0);
                    continue;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }



    }

}
