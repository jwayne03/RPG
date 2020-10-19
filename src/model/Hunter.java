package model;

import java.util.Random;

public class Hunter extends Player {

    private Random random = new Random();

    public Hunter(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

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
//        reset(player, enemy);
    }

    @Override
    public int generateRandomNumberAttack() {
        return random.nextInt(6) + 1;
    }

//    @Override
//    public void reset(Player player, Player enemy) {
//        checkIsPlayerDead(player, enemy);
//        player.setStamina((player.getLevel() * 10) + 10);
//        player.setMagic(player.getLevel() * 4);
//        player.setDead(true);
//    }
}
