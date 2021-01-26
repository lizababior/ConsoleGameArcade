package com.company;

import java.util.Scanner;

public class Game {

    int width;
    int height;
    private Grid grid;
    private boolean turn = false;
    private boolean isGameFinished = false;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Grid(width, height);
    }

    public void startGame(boolean multip) {
        Food food = new Food("\uD83C\uDF4E ");
        Bomb bomb = new Bomb("\uD83D\uDCA3 ");
        Enemy enemy = new Enemy("\uD83D\uDE20 ");
        GoldFish goldFish = new GoldFish("\uD83D\uDC1F ");
        Flower flower = new Flower("\uD83C\uDF39 ");

        grid.initScreen();
        for (int i = 0; i < width / 4; ++i) {
            grid.setObjectOnLocation(food, (int) (Math.random() * width), (int) (Math.random() * height));
            grid.setObjectOnLocation(bomb, (int) (Math.random() * width), (int) (Math.random() * height));
            grid.setObjectOnLocation(enemy, (int) (Math.random() * width), (int) (Math.random() * height));
            grid.setObjectOnLocation(flower, (int) (Math.random() * width), (int) (Math.random() * height));
        }
        grid.setObjectOnLocation(goldFish, (int) (Math.random() * width), (int) (Math.random() * height));

        if (!multip) {
            Player player = new Player("\uD83D\uDC40 ", (int) (Math.random() * width), (int) (Math.random() * height));
            grid.setObjectOnLocation(player, player.getX(), player.getY());
            while (!isGameFinished) {
                System.out.println(player.toString());
                grid.printScreen();
                player.playerTurn(grid);
                checkIfGameNotFinished(player);
            }

        } else {
            Player player1 = new Player("\uD83D\uDC40 ", "Player_1",
                                        (int) (Math.random() * width), (int) (Math.random() * height));
            Player player2 = new Player("\uD83D\uDC40 ","Player_2",
                                        (int) (Math.random() * width), (int) (Math.random() * height));
            grid.setObjectOnLocation(player1, player1.getX(), player1.getY());
            grid.setObjectOnLocation(player2, player2.getX(), player2.getY());

            while (!isGameFinished) {
                System.out.println(player1.toString());
                System.out.println(player2.toString());
                grid.printScreen();
                if (turn) {
                    turn = false;
                    player1.playerTurn(grid);
                } else {
                    turn = true;
                    player2.playerTurn(grid);
                }
                checkIfGameNotFinished(player1, player2);
            }
        }
    }

    private void checkIfGameNotFinished(Player player) {
        if (player.getHealth() == 0) isGameFinished = true;
        else if (player.getPoints() >= 5) isGameFinished = true;

        if (isGameFinished && player.getHealth() == 0)
            System.out.println("GAME OVER! YOU LOST!" + player.toString() + "\n");
        else if (isGameFinished && player.getPoints() >= 5)
            System.out.println("YOU WON! CONGRATULATIONS" + player.toString() + "\n");
    }

    private void checkIfGameNotFinished(Player player1, Player player2) {
        if (player1.getHealth() == 0 || player2.getHealth() == 0) isGameFinished = true;
        else if (player1.getPoints() >= 5 || player2.getPoints() >= 5) isGameFinished = true;

        if (isGameFinished) {
            if (player1.getHealth() == 0 || player1.getPoints() >= 5) {
                System.out.println(player1.toString() + " GAME OVER! YOU LOST!");
                System.out.println(player2.toString() + " YOU WON! CONGRATULATIONS!");
            } else {
                if (player2.getHealth() == 0 || player2.getPoints() >= 5) {
                    System.out.println(player2.toString() + " GAME OVER! YOU LOST!");
                    System.out.println(player1.toString() + " YOU WON! CONGRATULATIONS!");
                }
            }
        }
    }

}
