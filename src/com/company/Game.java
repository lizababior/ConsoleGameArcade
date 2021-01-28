package com.company;

public class Game {

    private final Grid grid;
    private boolean turn = false;
    private boolean isGameFinished = false;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void startGame(boolean multip) {
        Food food = new Food("\uD83C\uDF4E ");
        Bomb bomb = new Bomb("\uD83D\uDCA3 ");
        Enemy enemy = new Enemy("\uD83D\uDE20 ");
        GoldFish goldFish = new GoldFish("\uD83D\uDC1F ");
        Flower flower = new Flower("\uD83C\uDF39 ");

        grid.initScreen();
        for (int i = 0; i < grid.getWidth() / 4; ++i) {
            grid.setObjectOnLocation(food, (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
            grid.setObjectOnLocation(bomb, (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
            grid.setObjectOnLocation(enemy, (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
            grid.setObjectOnLocation(flower, (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
        }
        grid.setObjectOnLocation(goldFish, (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));

        if (!multip) {
            Player player = new Player("\uD83D\uDC40 ", (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
            grid.setObjectOnLocation(player, player.getX(), player.getY());
            while (!isGameFinished) {
                System.out.println(player.toString());
                grid.printScreen();
                player.playerTurn(grid);
                checkIfGameNotFinished(player);
            }

        } else {
            Player player1 = new Player("\uD83D\uDC40 ", "Player_1",
                    (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
            Player player2 = new Player("\uD83D\uDC40 ", "Player_2",
                    (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
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
        if (player.getHealth() == 0) {
            isGameFinished = true;
            System.out.println("GAME OVER! YOU LOST!" + player.toString() + "\n");
        } else if (player.getPoints() >= 5) {
            isGameFinished = true;
            System.out.println("YOU WON! CONGRATULATIONS" + player.toString() + "\n");
        }
    }

    private void checkIfGameNotFinished(Player player1, Player player2) {
        if (player1.getHealth() == 0 || player1.getPoints() >= 5) {
            isGameFinished = true;
            System.out.println(player1.toString() + " GAME OVER! YOU LOST!");
            System.out.println(player2.toString() + " YOU WON! CONGRATULATIONS!");
        } else if (player2.getHealth() == 0 || player2.getPoints() >= 5) {
            isGameFinished = true;
            System.out.println(player2.toString() + " GAME OVER! YOU LOST!");
            System.out.println(player1.toString() + " YOU WON! CONGRATULATIONS!");
        }
    }
}
