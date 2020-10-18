package model;

import java.util.Random;

public class Priest extends Player {

    private Random random = new Random();
    private Player player;

    public Priest(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

    //TODO: hacer que la magia se reste -1
    @Override
    public void attack(Player player, Player enemy) {
        int damage = generateRandomNumberAttack() + player.getLevel();

        player.setMagic(player.getMagic());
        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + damage
                + "! Life remaining: " + enemy.getStamina());
        System.out.println(player.getMagic());
    }

    @Override
    public void setMagic(int magic) {
        super.setMagic(magic - 1);
    }

    @Override
    public int generateRandomNumberAttack() {
        return random.nextInt(10) + 1;
    }
}
