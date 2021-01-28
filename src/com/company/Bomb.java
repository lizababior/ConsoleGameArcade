package com.company;

public class Bomb extends Object {

    public Bomb(String symbol) {
        setSymbol(symbol);
    }

    public static void subHealth(Player player) {
        int h = (int) (Math.random() * 10) < 5 ? 2 : 4;
        player.setHealth(Math.max(player.getHealth() - h, 0));

        if (h == 2) {
            System.out.println("\nBOOM! You lost -2hp");
        } else {
            System.out.println("\nBOOM! You lost -4hp");
        }
    }

}
