package com.revature.model;

public class Room {

    int room_id;
    String description;
    String name;
    String north;
    String east;
    String south;
    String west;

    public Room() {
    }

    public Room(int room_id, String name, String description, String north, String east, String south, String west) {
        this.room_id = room_id;
        this.name = name;
        this.description = description;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id  +
                ", name='" + name + '\'' +
                ", description='" + description +
                ", north='" + north + '\'' +
                ", east='" + east + '\'' +
                ", south='" + south + '\'' +
                ", west='" + west + '\'' +
                '}';
    }
}
