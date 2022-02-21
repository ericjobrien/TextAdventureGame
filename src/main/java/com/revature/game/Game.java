package com.revature.game;

import com.revature.actions.Fight;
import com.revature.actions.Move;
import com.revature.collections.GenericArrayList;
import com.revature.dao.RoomDAO;
import com.revature.main.Main;
import com.revature.model.Player;
import com.revature.model.Room;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private int score;

    private final String playerOptions =  "What would you like to do? \n" +
            "M -- Move \n" +
            "P -- Drink a health potion \n" +
            "Q -- Quit game";

    private final Fight fight = new Fight();
    private final Move move = new Move();

    public Fight getFight() {
        return fight;
    }

    public Move getMove() {
        return move;
    }

    public String getPlayerOptions() {
        return playerOptions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void startGame() throws InterruptedException {
        System.out.println("Game is starting.....");

        System.out.println("**************************************************************************************************************");

        System.out.println("WW          WW          WW   EEEEEEEEEE   LL          CCCCCCCCCC   OOOOOOOOOO   MM             MM   EEEEEEEEEE");
        System.out.println(" WW        WW WW       WW    EE           LL          CC           OO      OO   MM MM       MM MM   EE");
        System.out.println("  WW      WW   WW     WW     EE           LL          CC           OO      OO   MM  MM     MM  MM   EE");
        System.out.println("   WW    WW     WW   WW      EEEEEE       LL          CC           OO      OO   MM   MM   MM   MM   EEEEEE");
        System.out.println("    WW  WW       WW WW       EE           LL          CC           OO      OO   MM    MM MM    MM   EE");
        System.out.println("      WW          WW         EEEEEEEEEE   LLLLLLLLL   CCCCCCCCCC   OOOOOOOOOO   MM      MM     MM   EEEEEEEEEE");

        System.out.println("**************************************************************************************************************");
        System.out.println();
        System.out.println();


        RoomDAO roomDAO = new RoomDAO();
        GenericArrayList allRooms = roomDAO.getAllRooms();
        Room[] roomArray = (Room[]) allRooms.getGenericArray();
        Character choice;

        Fight fight = this.fight;

        Player player = fight.getPlayer();
        move.setCurrentRoom(roomArray[0]);

        Thread.sleep(1000);
        System.out.println("\t You are playing as a " + player.getType_of_player());
        Thread.sleep(1000);
        System.out.println("\t You awaken in a dark cave..............");
        Thread.sleep(1000);
        System.out.println("\t Player Health is " + String.valueOf(player.getMax_health()));
        Thread.sleep(1000);
        System.out.println("\t You have " + String.valueOf(player.getHealth_potion_amount()) + " health potions");
        Thread.sleep(1000);
        System.out.println("\t Fight enemies for a chance to find more health potion.");
        Thread.sleep(1000);

        boolean running = true;

        int score = 0;

        int currentPlayerHelath = player.getCurrent_health();

        GAMESTART:
        while (running) {

            System.out.println("\t What would you like to do?");
            Thread.sleep(1000);
            System.out.println(playerOptions);


            CHOICE:
            while(true) {

                try {

                    String nextLine = scanner.nextLine();
                    choice = nextLine.toUpperCase().charAt(0);
                    if(nextLine.equals(0x0A)) {
                        System.out.println("\t Choose a valid option.");
                        continue GAMESTART;
                    }
                    if (choice.equals('M')) {
                        boolean willFight = fight.rollForFight();
                        if (willFight == true) {
                            fight.fightSequence();
                            int fightScore = fight.getScore();
                            fight.setScore(0);
                            this.score += fightScore;
                            Thread.sleep(1000);
                            System.out.println("\t Your current score is " + this.score);
                            Thread.sleep(1000);
                            System.out.println("\t Your fight is over and now you will move.");
                        }
                        move.move();
                        Thread.sleep(1000);
                        System.out.println("\t --------------------------------------------------------");
                        System.out.println("\t Your move has completed");
                        continue GAMESTART;
                    } else if (choice.equals('P')) {
                        Game game = new Game();
                        int healthAfterPotion = Player.useHealthPotion(player);
                        currentPlayerHelath = healthAfterPotion;
                        fight.getPlayer().setCurrent_health(currentPlayerHelath);
                        player.setCurrent_health(currentPlayerHelath);
                        Thread.sleep(1000);
                        System.out.println("\t Your current health is " + currentPlayerHelath + "!");
                        continue GAMESTART;
                    } else if (choice.equals('Q')) {

                        System.out.println("\t Your score for the game was " + this.score);

                        Thread.sleep(2000);

                        System.out.println("######################");
                        System.out.println("# THANKS FOR PLAYING #");
                        System.out.println("######################");

                        break GAMESTART;

                    } else if(choice.equals('\n')) {
                        System.out.println("\t Choose a valid option.");
                        continue GAMESTART;
                    } else {
                        System.out.println("\t Choose a valid option.");
                        continue GAMESTART;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    Main.log.warn(e + " Thrown at line 157, when the enter key is hit");
                    System.out.println("\t Choose a valid option.");
                    continue GAMESTART;
                }

            }
        }
    }

}