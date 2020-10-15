package utils;

import javax.swing.*;

public class Printer {

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

    public static void printEscapeOptions() {
        System.out.println("-----ESCAPED-----");
        System.out.println("--GAME IS ENDED--");
        System.out.println("1) New Enemy");
        System.out.println("2) See player");
        System.out.println("3) Surrender");
    }
}
