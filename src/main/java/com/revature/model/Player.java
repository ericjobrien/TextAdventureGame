package com.revature.model;

import com.revature.collections.GenericArrayList;
import com.revature.dao.PlayerDAO;
import com.revature.dao.RoomDAO;

public class Player {

    int player_id;
    String type_of_player;
    int max_health;
    int current_health;
    int attack_damage;
    int health_potion_amount;

    public Player() {
    }

    public Player(int player_id, String type_of_player, int max_health, int current_health, int attack_damage, int health_potion_amount) {
        this.player_id = player_id;
        this.type_of_player = type_of_player;
        this.max_health = max_health;
        this.current_health = current_health;
        this.attack_damage = attack_damage;
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

    public int getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(int attack_damage) {
        this.attack_damage = attack_damage;
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
                ", attack_damage=" + attack_damage +
                ", health_potion_amount=" + health_potion_amount +
                '}';
    }

    public static Player getPlayerByType(String playerType) {

        Player player = new Player();
        PlayerDAO playerDAO = new PlayerDAO();
        GenericArrayList allPlayers = playerDAO.getAllPlayers();
        Player[] playerArray = (Player[]) allPlayers.getGenericArray();

        for(int i = 0; i < playerArray.length; i++) {
            if(playerArray[i].getType_of_player().equals(playerType))  {
                player = playerArray[i];
                break;
            } else if(!playerArray[i].getType_of_player().equals(playerType)){
                continue;
            } else {
                System.out.println("No player exits by that name");
                return null;
            }
        }

        return player;
    }
    public static int useHealthPotion(Player player) {


        int numberOfHealthPotions = player.getHealth_potion_amount();
        int currentPlayerHealth = player.getCurrent_health();
        int healthPotionBenefit = 30;

        System.out.println("Player from potion: " + player.getType_of_player());

        if(numberOfHealthPotions <= 0) {
            System.out.println("\t You do not have any health potions left.");
            System.out.println("\t Defeat enemies for a chance to find health potions.");
        } else {
            numberOfHealthPotions --;
            player.setHealth_potion_amount(numberOfHealthPotions);
            currentPlayerHealth += healthPotionBenefit;
        }


        return currentPlayerHealth;

    }
}
