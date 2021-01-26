package com.company;

public class Bomb extends Object {

    public Bomb(String symbol) {
        setSymbol(symbol);
    }

    public static void subHealth(Player player) {
        int h = 0;
        if((int) (Math.random() * 10) < 5) h = 2;
        else h = 4;

        if(player.getHealth() - h <= 0) player.setHealth(0);
        else player.setHealth(player.getHealth() - h);

        if(h == 2) System.out.println("\nBOOM! You lost -2hp");
        else System.out.println("\nBOOM! You lost -4hp");
    }

}
