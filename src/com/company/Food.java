package com.company;

public class Food extends Object {

    public Food(String symbol) {
        setSymbol(symbol);
    }

    public static void addHealth(Player player) {
        int h = ((int) (Math.random() * 10)) < 5 ? 2 : 4;
        player.setHealth(Math.min(player.getHealth() + h, 10));

        if (h == 2) {
            System.out.println("Apple gives you +2hp");
        } else {
            System.out.println("Apple gives you +4hp");
        }
    }
}
