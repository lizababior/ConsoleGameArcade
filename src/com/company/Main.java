package com.company;

import java.util.Scanner;

public class Main {

    static final int SCREEN_WIDTH = 20;
    static final int SCREEN_HEIGHT = 12;
    
    /*  List of features:
    - Store information about player
    - Place player on the grid
    - Allow player to move on the board
    - Add some elements on map
    - Add randomness
    - Add 4 types of elements
    - Add NPCs
    - Allow to lose / win
    - Make it for two players
 */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command;
        boolean multip = false;

        do {
            System.out.println("Welcome to the hardest arcade ever. Please, make your choice and press Enter");
            System.out.println("1: Start new game");
            System.out.println("2: Options");
            System.out.println("3: Exit");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Do you want to play multiplayer? (y/n)");
                    command = scanner.nextLine();
                    switch (command) {
                        case "y":
                            multip = true;
                            startNewGame(multip);
                            break;
                        case "n":
                            startNewGame(multip);
                            break;
                        default:
                            System.out.println("Command not recognised! Please, try again\n");
                    }
                case "2":
                    OptionsMenu.showOptionsMenu();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Command not recognised! Please, try again\n");
            }
        }
        while (!command.equals("3"));
    }

    private static void startNewGame(boolean multip) {
        System.out.println("~~~~~~~~~Welcome to the game~~~~~~~~~\n");
        System.out.println("Collect flowers to increase your score\n");
        System.out.println("Controls: w = UP, a = LEFT, s = DOWN, d = RIGHT\n");
        Game game = new Game(SCREEN_WIDTH, SCREEN_HEIGHT);
        game.startGame(multip);
    }
}
