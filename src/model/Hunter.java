package model;

public class Hunter extends Player {

    public Hunter(String name, int level, int stamina, int magic, String weapon, boolean dead) {
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
