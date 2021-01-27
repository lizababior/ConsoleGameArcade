package com.company;

import java.util.Scanner;

public class OptionsMenu {
    static Scanner scanner = new Scanner(System.in);
    static int command;

    public static void showOptionsMenu(Grid grid) {
        do {
            System.out.println("\nMake your choice and press Enter\n" +
                    "1: Show current settings\n" +
                    "2: Change settings\n" +
                    "3: Exit");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Current settings:");
                    System.out.println(grid.toString());
                    break;
                case 2:
                    changeGridSettings(grid);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Command not recognised! Please, try again");
            }
        } while (command != 3);
    }

    private static void changeGridSettings(Grid grid) {
        int newWidth, newHeight;
        do {
            System.out.println("Enter a new value for rows (value should be more then 0):");
            newWidth = scanner.nextInt();
        } while (newWidth <= 0);
        grid.setWidth(newWidth);

        do {
            System.out.println("Enter a new value for columns (value should be more then 0):");
            newHeight = scanner.nextInt();
        } while (newHeight <= 0);
        grid.setHeight(newHeight);
    }
}
