package com.revature.actions;

import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;
import com.revature.dao.PlayerDAO;
import com.revature.game.Game;
import com.revature.model.Monster;
import com.revature.model.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fight {

    private int score;
    private Random rand = new Random();
    private PlayerDAO playerDAO = new PlayerDAO();
    private GenericArrayList allPlayers = playerDAO.getAllPlayers();
    private Player[] playerArray = (Player[]) allPlayers.getGenericArray();
    private final Player player = playerArray[rand.nextInt(playerArray.length)];
    private int playerHealth;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public PlayerDAO getPlayerDAO() {
        return playerDAO;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public GenericArrayList getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(GenericArrayList allPlayers) {
        this.allPlayers = allPlayers;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "score=" + score +
                ", rand=" + rand +
                ", playerDAO=" + playerDAO +
                ", allPlayers=" + allPlayers +
                ", playerArray=" + Arrays.toString(playerArray) +
                ", player=" + player +
                '}';
    }

    public Boolean rollForFight() {
        int determineFight = rand.nextInt(6);

        if(determineFight > 2) {
            return true;
        } else {
            return false;
        }
    }

    public void fightSequence() throws InterruptedException {

        Game game = new Game();

        MonsterDAO monsterDAO = new MonsterDAO();
        PlayerDAO playerDAO = new PlayerDAO();

        GenericArrayList allMonsters = monsterDAO.getAllMonsters();
        GenericArrayList allPlayers = playerDAO.getAllPlayers();

        Scanner in = new Scanner(System.in);
        Random rand = this.rand; //creates a random number generator

        //Monster Variables
        Monster[] enemies = (Monster[]) allMonsters.getGenericArray();

        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;

        //Game variables
        int score = 0;

        //Player variables
        Player player = this.player;
        int health = player.getCurrent_health();
        int attackDamage = player.getAttack_damage();
        int numHealthPotions = player.getHealth_potion_amount();
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean fighting = true;

        Thread.sleep(500);
        System.out.println("Prepare for battle!");

        GAME:
        while (fighting) {
            System.out.println("--------------------------------------------------------");
            Monster enemyMonster = enemies[rand.nextInt(enemies.length)];

            maxEnemyHealth = enemyMonster.getMax_health();
            enemyAttackDamage = enemyMonster.getAttack_damage();

            int enemyHealth = 1 + rand.nextInt(maxEnemyHealth);

            String enemy = enemyMonster.getType_of_monster();
            Thread.sleep(500);
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                Thread.sleep(500);
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                Thread.sleep(500);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run away");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    player.setCurrent_health(health);
                    Thread.sleep(1000);
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    Thread.sleep(1000);
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        Thread.sleep(1000);
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        Thread.sleep(1000);
                        System.out.println("Your final score is " + game.getScore() + "!");
                        break;
                    }
                } else if (input.equals("2")) {

                    int healthAfterPotion = Player.useHealthPotion(player);
                    health = healthAfterPotion;
                    player.setCurrent_health(health);
                    System.out.println("Your current health is " + health + "!");

                } else if (input.equals("3")) { //attempting to flee the enemy
                    int hitChance = rand.nextInt(6);

                    if(hitChance > 4) {
                        enemyAttackDamage = rand.nextInt(enemyAttackDamage);
                        health -= enemyAttackDamage;
                        player.setCurrent_health(health);
                        System.out.println("\t The " + enemy + " strikes you before you are able to flee!");
                        System.out.println("\t You take " + enemyAttackDamage + "!");
                        System.out.println("\t> You run away from the " + enemy + "!");
                        break GAME;

                    } else {
                        System.out.println("\t> You run away from the " + enemy + "!");
                        break GAME;
                    }


                } else {
                    System.out.println("\tInvalid command!");
                }

            }

            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                System.out.println("Your final score is " + game.getScore() + "!");
                break;
            }

            System.out.println("--------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. #");
            score += 100;
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " droped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
            }

            break GAME;


            }
        this.score = score;
        }
    }



