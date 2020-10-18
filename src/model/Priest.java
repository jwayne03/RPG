package model;

import java.util.Random;

public class Priest extends Player {

    private Random random = new Random();

    public Priest(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

    @Override
    public void attack(Player player, Player enemy) {
        int damage = generateRandomNumberAttack() + player.getLevel();
        player.setMagic(player.getMagic() - 1);
        System.out.println("----------DAMAGE----------");
        System.out.println(player.getName() + " recieves 0 "
                + "! Life remaining: " + player.getStamina());
        System.out.println(enemy.getName() + " recieves " + damage
                + "! Life remaining: " + enemy.getStamina());
        super.attack(player, enemy);
    }

    @Override
    public int generateRandomNumberAttack() {
        return random.nextInt(10) + 1;
    }
}
