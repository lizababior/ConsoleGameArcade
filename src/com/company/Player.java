package com.company;

import java.util.Scanner;

public class Player extends Object {

    private String name;
    private int health;
    private int points;
    private int money;
    private boolean isUpgraded = false;

    public Player(String symbol, int xStarting, int yStarting) {
        this.health = 5;
        this.money = 3;
        this.points = 0;
        setSymbol(symbol);
        setX(xStarting);
        setY(yStarting);
    }

    public Player(String symbol, String name, int xStarting, int yStarting) {
        this.name = name;
        this.health = 5;
        this.money = 3;
        this.points = 0;
        setSymbol(symbol);
        setX(xStarting);
        setY(yStarting);
    }

    public int getHealth() {
        return health;
    }
    public int getMoney() {
        return money;
    }
    public int getPoints() {
        return points;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setUpgraded(boolean upgraded) { isUpgraded = upgraded; }

    public void moveLeft(Grid grid, Player player) {
        player.setX(getX() - 1);
        grid.checkCell(this);
        grid.setObjectOnLocation(player, player.getX(), player.getY());
        grid.clearScreenLocation(player.getX() + 1, player.getY());
    }

    public void moveRight(Grid grid, Player player) {
        player.setX(getX() + 1);
        grid.checkCell(this);
        grid.setObjectOnLocation(player, player.getX(), player.getY());
        grid.clearScreenLocation(player.getX() - 1, player.getY());
    }

    public void moveUp(Grid grid, Player player) {
        player.setY(getY() - 1);
        grid.checkCell(this);
        grid.setObjectOnLocation(player, player.getX(), player.getY());
        grid.clearScreenLocation(player.getX(), player.getY() + 1);
    }

    public void moveDown(Grid grid, Player player) {
        player.setY(getY() + 1);
        grid.checkCell(this);
        grid.setObjectOnLocation(player, player.getX(), player.getY());
        grid.clearScreenLocation(player.getX(), player.getY() - 1);
    }

    public void playerTurn(Grid grid){
        Scanner scanner = new Scanner(System.in);
        String input;
        switch (input = scanner.nextLine()) {
            case "a"://west - left
                this.moveLeft(grid, this);
                break;
            case "d"://east - right
                this.moveRight(grid, this);
                break;
            case "w"://north - up
                this.moveUp(grid, this);
                break;
            case "s"://south - down
                this.moveDown(grid, this);
                break;
            default:
                System.out.println("Command not recognised! Please, try again\n");
        }
    }

    @Override
    public String toString() {
        if(this.name == null)
            return "\nPlayer: " + "health=" + health + ", points=" + points + ", money=" + money;
        else
            return "\n" + name + ": health=" + health + ", points=" + points + ", money=" + money;
    }
}
