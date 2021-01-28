package com.company;

public class Flower extends Object {

    public Flower(String symbol) {
        setSymbol(symbol);
    }

    public static void addPoint(Player player) {
        System.out.println("Flower gives you +1pt");
        player.setPoints(Math.min(player.getPoints() + 1, 5));
    }
}
