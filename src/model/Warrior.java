package model;

public class Warrior extends Player {

    public Warrior(String name, int level, int stamina, int magic, Weapon weapon, boolean dead) {
        super(name, level, stamina, magic, weapon, dead);
    }

    @Override
    public void attack(Player player, Player enemy) {
        super.attack(player, enemy);
    }

    @Override
    public int generateRandomNumberAttack() {
        return super.generateRandomNumberAttack();
    }
}
