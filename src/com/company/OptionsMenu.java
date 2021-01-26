package com.company;

import java.util.Scanner;

public class OptionsMenu {
    static Scanner scanner = new Scanner(System.in);
    static int command;

    public static void showOptionsMenu() {
        do {
            System.out.println("\nMake your choice and press Enter\n" +
                    "1: Show current settings\n" +
                    "2: Change settings\n" +
                    "3: Exit");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Current settings:\n" +
                            "rows:\n" + //output
                            "columns:");//output
                    break;
                case 2:
                    System.out.println("Enter a new value for rows:");
                    //assignment
                    System.out.println("Enter a new value for columns:");
                    //assignment
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Command not recognised! Please, try again");
            }
        }
        while (command != 3);

    }
}
