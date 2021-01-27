package com.company;

public class Enemy extends Object {

    public Enemy(String symbol) {
        setSymbol(symbol);
    }

    public static void clashPlayer(Player player) {
        if (player.getHealth() - 4 <= 0) {
            System.out.println("Enemy beat you -4hp");
            player.setHealth(0);
        } else {
            player.setHealth(player.getHealth() - 4);
            player.setMoney(player.getMoney() + 2);
            if ((int) (Math.random() * 10) < 5) {
                System.out.println("You beat an enemy (-4hp, +2m, +1pt)");
                player.setPoints(player.getPoints() + 1);
            }
        }
    }
}
