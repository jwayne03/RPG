package model;

import java.util.Random;

public class Hunter extends Player {

    private Random random = new Random();

    public Hunter(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

    //TODO: Sobreescribir el reset final de batalla para que empece con 10 mas de salud
    @Override
    public void attack(Player player, Player enemy) {
        int playerDamage = 0;

        for (int i = 0; i < 3; i++) playerDamage += generateRandomNumberAttack();

        enemy.setStamina(enemy.getStamina() - playerDamage);

        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + playerDamage
                + "! Life remaining: " + enemy.getStamina());
    }

    @Override
    public int generateRandomNumberAttack() {
        return random.nextInt(6) + 1;
    }
}
