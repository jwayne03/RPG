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
    protected Weapon weapon;
    protected boolean isDead;

    private Random random = new Random();
    private BufferedReader read;

    public Player(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        this.name = name;
        this.level = level;
        this.stamina = stamina;
        this.magic = magic;
        this.weapon = weapon;
        this.isDead = dead;
    }

    public Player(String name, Weapon weapon) {
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
        this.weapon = new Weapon("Katana");
        this.isDead = false;
    }

    private void init() {
        read = new BufferedReader(new InputStreamReader(System.in));
    }

    public void attack(Player player, Player enemy) {
        if (whoIsDead(player, enemy)) return;

        int playerDamage = generateRandomNumberAttack();
        int enemyDamage = generateRandomNumberAttack();

        playerDamage += player.getLevel();
        enemyDamage += enemy.getLevel();

        player.setStamina(player.getStamina() - enemyDamage);
        enemy.setStamina(enemy.getStamina() - playerDamage);

        checkIsPlayerDead(player, enemy);

        showDamage(player, enemy, playerDamage, enemyDamage);
    }

    private boolean whoIsDead(Player player, Player enemy) {
        if (player.isDead) {
            System.out.println(player.getName() + " is dead");
            return true;
        }
        if (enemy.isDead) {
            System.out.println(enemy.getName() + " is dead");
            return true;
        }
        return false;
    }

    public void showDamage(Player player, Player enemy, int playerDamage, int enemyDamage) {
        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves " + enemyDamage
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + playerDamage
                + "! Life remaining: " + enemy.getStamina());
    }

    public void checkIsPlayerDead(Player player, Player enemy) {
        if (player.getStamina() <= 0) {
            player.setStamina(0);
            player.setDead(true);
        }
//        else {
//            levelUp(player);
//        }

        if (enemy.getStamina() <= 0) {
            enemy.setStamina(0);
            enemy.setDead(true);
        }
    }

    private void levelUp(Player player) {
        player.setLevel(player.getLevel() + 1);
        player.setStamina(player.getLevel() * 10);
        player.setMagic(player.getLevel() * 4);
    }

    public void reset(Player player, Player enemy) {
        checkIsPlayerDead(player, enemy);
        player.setStamina(player.getLevel() * 10);
        player.setMagic(player.getLevel() * 4);
        player.setDead(true);
    }

    public void protect(Player player, Player enemy) {
        if (whoIsDead(player, enemy)) return;
        System.out.println(player.getName() + " recieves 0! Remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves 0! Remaining: " + enemy.getStamina());
    }

    public void weaponSkill(Player player, Player enemy) {
        if (whoIsDead(player, enemy)) return;

        if (player.getMagic() <= 0) {
            Printer.printWeaponDamage(false);
            int playerDamage = generateRandomNumberAttack();
            int enemyDamage = generateRandomNumberAttack();

            playerDamage += player.getLevel();
            enemyDamage += enemy.getLevel();

            player.setStamina(player.getStamina() - enemyDamage);
            enemy.setStamina(enemy.getStamina() - playerDamage);

            checkIsPlayerDead(player, enemy);

            showDamage(player, enemy, playerDamage, enemyDamage);
        } else {
            Printer.printWeaponDamage(true);
            int playerDamage = weapon.weaponAbility();
            int enemyDamage = generateRandomNumberAttack();

            playerDamage += player.getLevel();
            enemyDamage += enemy.getLevel();

            player.setStamina(player.getStamina() - enemyDamage);
            enemy.setStamina(enemy.getStamina() - playerDamage);

            checkIsPlayerDead(player, enemy);
            showDamage(player, enemy, playerDamage, enemyDamage);
        }
        player.setMagic(player.getMagic() - 1);
    }

    public void classSkill(Player player, Player enemy) {
        if (whoIsDead(player, enemy)) return;

        int playerDamage = 0;
        int damage = 0;

        for (int i = 0; i < 3; i++) {
            playerDamage += generateRandomNumberAttack();
            damage = playerDamage / 3;
        }

        enemy.setStamina(enemy.getStamina() - damage);

        if (checkPlayerMagic(player, 2)) return;

        checkIsPlayerDead(player, enemy);
        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + playerDamage
                + "! Life remaining: " + enemy.getStamina());
    }

    private boolean checkPlayerMagic(Player player, int magic) {
        if (player.getMagic() <= 0) {
            System.out.println("You don't have enough power of magic");
            player.setMagic(0);
            return true;
        } else {
            player.setMagic(player.getMagic() - magic);
        }
        return false;
    }

    public void escape(Player player, Player enemy) {
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
                    if (player.getLevel() >= 5) skill(player, enemy);
                    break;
                default:
                    System.out.println("You need to choose a number");
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void skill(Player player, Player enemy) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int option;
            do {
                Printer.printSkills();
                option = Integer.parseInt(br.readLine());
            } while (option < 1 && option > 3);

            switch (option) {
                case 1:
                    player = new Priest(player.getName(), player.getLevel(), player.getStamina(),
                            player.getMagic(), player.getWeapon(), player.isDead());
                    player.attack(player, enemy);
                    break;
                case 2:
                    player = new Warrior(player.getName(), player.getLevel(), player.getStamina(),
                            player.getMagic(), player.getWeapon(), player.isDead());
                    player.attack(player, enemy);
                    break;
                case 3:
                    player = new Hunter(player.getName(), player.getLevel(), player.getStamina(),
                            player.getMagic(), player.getWeapon(), player.isDead());
                    player.attack(player, enemy);
                    break;
                default:
                    System.err.println("You need to choose a number");
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
                " Weapon: " + weapon.getWeapon() +
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }


}
