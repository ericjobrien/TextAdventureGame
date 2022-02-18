package com.revature.model;

public class Player {

    int player_id;
    String type_of_player;
    int max_health;
    int current_health;
    int max_attack;
    int health_potion_amount;

    public Player() {
    }

    public Player(int player_id, String type_of_player, int max_health, int current_health,int health_potion_amount) {
        this.player_id = player_id;
        this.type_of_player = type_of_player;
        this.max_health = max_health;
        this.current_health = current_health;
        this.health_potion_amount = health_potion_amount;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getType_of_player() {
        return type_of_player;
    }

    public void setType_of_player(String type_of_player) {
        this.type_of_player = type_of_player;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(int current_health) {
        this.current_health = current_health;
    }

    public int getHealth_potion_amount() {
        return health_potion_amount;
    }

    public void setHealth_potion_amount(int health_potion_amount) {
        this.health_potion_amount = health_potion_amount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", type_of_player='" + type_of_player + '\'' +
                ", max_health=" + max_health +
                ", current_health=" + current_health +
                ", health_potion_amount=" + health_potion_amount +
                '}';
    }
}
