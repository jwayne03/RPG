package model;

import manager.Manager;
import utils.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Player {

    protected String name;
    protected int level;
    protected int stamina;
    protected int magic;
    protected String weapon;
    protected boolean isDead;

    private Random random = new Random();
    private BufferedReader read;

    public Player(String name, int level, int stamina, int magic, String weapon, boolean dead) {
        this.name = name;
        this.level = level;
        this.stamina = stamina;
        this.magic = magic;
        this.weapon = weapon;
        this.isDead = dead;
    }

    public Player(String name, String weapon) {
        this.name = name;
        this.level = 1;
        this.stamina = 10;
        this.magic = 4;
        this.weapon = weapon;
        this.isDead = false;
    }

    public Player() {
        this.name = "Enemy";
        this.level = generateRandomNumber();
        this.stamina = this.level * 10;
        this.magic = this.level * 4;
        this.weapon = weapon;
        this.isDead = false;
    }

    private void init() {
        read = new BufferedReader(new InputStreamReader(System.in));
    }

    public void attack(Player player, Player enemy) {
        int playerDamage = generateRandomNumberAttack();
        int enemyDamage = generateRandomNumberAttack();

        playerDamage += player.getLevel();
        enemyDamage += enemy.getLevel();

        player.setStamina(player.getStamina() - enemyDamage);
        enemy.setStamina(enemy.getStamina() - playerDamage);

        checkIsPlayerDead(player, enemy);

        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves " + enemyDamage
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + playerDamage
                + "! Life remaining: " + enemy.getStamina());
    }

    private void checkIsPlayerDead(Player player, Player enemy) {
        if (player.getStamina() <= 0) {
            player.setStamina(0);
            player.setDead(true);
        } else {
            player.setLevel(player.getLevel() + 1);
        }

        if (enemy.getStamina() <= 0) {
            enemy.setStamina(0);
            enemy.setDead(true);
        }
    }

    public void protect(Player player, Player enemy) {
        System.out.println(player.getName() + " recieves 0! Remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves 0! Remaining: " + enemy.getStamina());
    }

    public void weaponSkill(Player player, Player enemy) { // TODO
        // hay que meter el daño recibido y el restante
        System.out.println(player.getName() + " recieves ");
        System.out.println(enemy.getName() + " recieves ");
    }

    public void classSkill(Player player, Player enemy) { // TODO
        int playerDamage = generateRandomNumberAttack();

        playerDamage += player.getLevel();

        enemy.setStamina(enemy.getStamina() - playerDamage);

        if (player.getMagic() <= 0) {
            System.out.println("You don't have enough power of magic");
            player.setMagic(0);
            return;
        } else {
            player.setMagic(player.getMagic() - 2);
        }

        checkIsPlayerDead(player, enemy);

        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + playerDamage
                + "! Life remaining: " + enemy.getStamina());
    }

    public void escape(Player player) { // TODO
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int option;
            do {
                Printer.printEscapeOptions(player);
                option = Integer.parseInt(br.readLine());
            } while (option < 1 && option > 3);
            switch (option) {
                case 1:
                    Manager.newGame();
                    break;
                case 2:
                    System.out.println(player.toString());
                    break;
                case 3:
                    Printer.printSurrender(player);
                    System.exit(0);
                    break;
                case 4:
                    if (player.getLevel() >= 5) skill();
                    break;
                default:
                    System.out.println("You need to choose a number");
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void skill() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int option;
            do {
                Printer.printSkills();
                option = Integer.parseInt(br.readLine());
            } while (option < 1 && option > 3);

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("You need to choose a number");
                    break;
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public int generateRandomNumber() {
        int randomNumber = random.nextInt(10) + 1;
        return randomNumber;
    }

    public int generateRandomNumberAttack() {
        int randomNumberAttack = random.nextInt(6) + 1;
        return randomNumberAttack;
    }

    @Override
    public String toString() {
        return "Player---> " +
                "Name: " + name +
                " Level: " + level +
                " Stamina: " + stamina +
                " Magic: " + magic +
                " Weapon: " + weapon +
                " Dead: " + isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }


}
