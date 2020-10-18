package model;

import java.util.Random;

public class Warrior extends Player {

    private Random random = new Random();

    public Warrior(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

    @Override
    public void attack(Player player, Player enemy) {
        int firstRandomNumber = generateRandomNumber();
        int secondRandomNumber = generateRandomNumber();

        if (firstRandomNumber > secondRandomNumber) {
            enemy.setStamina(enemy.getStamina() - firstRandomNumber);
            showDamage(player, enemy, firstRandomNumber);
        } else {
            enemy.setStamina(enemy.getStamina() - secondRandomNumber);
            showDamage(player, enemy, secondRandomNumber);
        }
    }

    @Override
    public int generateRandomNumberAttack() {
        return random.nextInt(10) + 1;
    }

    private void showDamage(Player player, Player enemy, int damage) {
        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + damage
                + "! Life remaining: " + enemy.getStamina());
    }
}
