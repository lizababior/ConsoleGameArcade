package com.company;

import java.util.Scanner;

public class GoldFish extends Object {

    public GoldFish(String symbol) {
        setSymbol(symbol);
    }

    //takes money and can make an upgrade of your player
    public static void upgradePlayer(Player player, Grid grid) {
        Scanner scanner = new Scanner(System.in);
        String command;

        if(player.getMoney() >= 5) {
            System.out.println("Do you want to upgrade your Player for 5m? (y/n)");
            command = scanner.nextLine();
            switch (command){
                case "y":
                    System.out.println("Your player have been updated");
                    player.setMoney(player.getMoney() - 5);
                    player.setUpgraded(true);
                    break;
                case "n":
                    grid.setObjectOnLocation(new GoldFish("\uD83D\uDC1F "),
                            (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));
                    break;
                default:
                    System.out.println("Command not recognised! Please, try again");
            }
        } else {
            System.out.println("You have not enough money to upgrade your Player");
            grid.setObjectOnLocation(new GoldFish("\uD83D\uDC1F "),
                    (int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getHeight()));

        }
    }
}
