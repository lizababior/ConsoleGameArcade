package com.company;

public class Food extends Object {

    public Food(String symbol) {
        setSymbol(symbol);
    }

    public static void addHealth(Player player) {
        int h = 0;
        if((int) (Math.random() * 10) < 5) h = 2;
        else h = 4;

        if(player.getHealth() + h >= 10) player.setHealth(10);
        else player.setHealth(player.getHealth() + h);

        if(h == 2) System.out.println("Apple gives you +2hp");
        else System.out.println("Apple gives you +4hp");
    }

}
