package com.revature.game;

import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    String playerOptions =  "What would you like to do? \n" +
            "M -- Move \n" +
            "P -- Drink a health potion \n" +
            "Decision: ";

    public void startGame() {
        System.out.println("Game is starting.....");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");

        System.out.println("WW          WW          WW   EEEEEEEEEE   LL          CCCCCCCCCC   OOOOOOOOOO   MM             MM   EEEEEEEEEE");
        System.out.println(" WW        WW WW       WW    EE           LL          CC           OO      OO   MM MM       MM MM   EE");
        System.out.println("  WW      WW   WW     WW     EE           LL          CC           OO      OO   MM  MM     MM  MM   EE");
        System.out.println("   WW    WW     WW   WW      EEEEEE       LL          CC           OO      OO   MM   MM   MM   MM   EEEEEE");
        System.out.println("    WW  WW       WW WW       EE           LL          CC           OO      OO   MM    MM MM    MM   EE");
        System.out.println("      WW          WW         EEEEEEEEEE   LLLLLLLLL   CCCCCCCCCC   OOOOOOOOOO   MM      MM     MM   EEEEEEEEEE");

        System.out.println("You awaken in a dark cave.  It smells like spoiled seafood and trash.");


        Character[] move = {'N', 'E', 'S', 'W'}; //Right, Left, Up, Down
        Character moveValue;
        boolean running = true;

        GAMESTART:
        while(running) {

            System.out.println(this.playerOptions);

            Character nextChar  = scanner.next().toUpperCase().charAt(0);

            if(nextChar.equals('M')) {
                System.out.println("You have chosen to move.  Use N (north), S (south), E (east), W (west) to move.");
                nextChar = scanner.next().toUpperCase().charAt(0);


            for (int i = 0; i < move.length; i++) {
                moveValue = move[i];
                if (moveValue.equals(nextChar)) {
                    break;
                } else if(!moveValue.equals(nextChar)) {
                    continue;
                } else {
                    System.out.println("Choose N (north), S (south), E (east), W (west) to move.");
                    nextChar = scanner.next().toUpperCase().charAt(0);
                    continue;
                }
            }
            boolean isTrue = true;

            FIRSTROOM:
            while (isTrue) {
                if (nextChar.equals('E')) {
                    System.out.println("You enter a small dark room. \n");
                    System.out.println();
                    System.out.println();
                    isTrue = false;
                    continue GAMESTART;
                } else {
                    System.out.println("You are trapped!");
                    nextChar = scanner.next().toUpperCase().charAt(0);
                    continue FIRSTROOM;
                }
            }

//                    case 'E':
//                        System.out.println("You enter a small room full of rotting flesh and cheese. \n" +
//                                            "You are attacked by a zombie and it eats you.");
//                        isTrue = false;
//                        break;
            }
        }
    }
}