package utils;

import model.Player;

public class Printer {

    private static int count = 0;

    public static void printMenu() {
        System.out.println("------------------");
        System.out.println("-------MENU-------");
        System.out.println("1) Attack");
        System.out.println("2) Protect");
        System.out.println("3) Weapon skill");
        System.out.println("4) Class skill");
        System.out.println("5) Escape");
        System.out.println("------------------");
    }

    public static void printEscapeOptions(Player player) {
        count++;
        System.out.println("------ESCAPED " + count + "-----");
        System.out.println("1) New Enemy");
        System.out.println("2) See player");
        System.out.println("3) Surrender");
        if (player.getLevel() >= 5) System.out.println("4) Change class");

        if (count >= 6) {
            System.out.println("You have escaped more than 5 times, thank you for the participation!");
            System.exit(0);
        }
    }

    public static void printSurrender(Player player) {
        System.out.println("Thank you for participating!");
        System.out.println("----------------------------");
        System.out.println("-----------PLAYER-----------");
        System.out.println(player.toString());
        System.out.println("----------------------------");
        System.out.println("----------------------------\n");
    }

    public static void printSkills() {
        System.out.println("1) Priest");
        System.out.println("2) Warrior");
        System.out.println("3) Hunter");
    }
}
