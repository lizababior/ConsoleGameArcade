package com.company;

public class Flower extends Object {

    public Flower(String symbol) {
        setSymbol(symbol);
    }

    public static void addPoint(Player player) {
        System.out.println("Flower gives you +1pt");
        if(player.getPoints() + 1 >= 5) player.setPoints(5);
        else player.setPoints(player.getPoints() + 1);
    }
}
