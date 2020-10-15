package manager;

import model.Player;
import utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    private Player player;
    private Player enemy;
    private BufferedReader read;

    public void init() {
        read = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        try {
            init();
            System.out.print("Player's name: ");
            String name = read.readLine();
            System.out.print("Name of your weapon:");
            String weapon = read.readLine();

            player = new Player(name, weapon);
            enemy = new Player();

            System.out.println(player.toString());
            System.out.println(enemy.toString());
            System.out.println("----PLAYER----");
            System.out.println(player.getName() + " of level " + player.getLevel());
            System.out.println("----ENEMY----");
            System.out.println(enemy.getName() + " of level " + enemy.getLevel());
            menu();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void menu() {
        try {
            boolean exit = false;
            while (!exit) {
                Printer.printMenu();

                int option;
                do {
                    option = Integer.parseInt(read.readLine());
                } while (option < 1 && option > 5);

                switch (option) {
                    case 1:
                        player.attack(player, enemy);
                        break;
                    case 2:
                        player.protect(player, enemy);
                        break;
                    case 3:
                        player.weaponSkill(player, enemy);
                        break;
                    case 4:
                        player.classSkill();
                        break;
                    case 5:
                        player.escape(player);
                        break;
                    default:
                        System.out.println("You need to choose a number");
                        break;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("You need to put a number");
            e.printStackTrace();
        }
    }
}
