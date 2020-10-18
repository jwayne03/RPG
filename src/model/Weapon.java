package model;

import java.util.Random;

public class Weapon {

    private String weapon;

    private Random random = new Random();

    public Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    public int weaponAbility() {
        int weaponDamage = 0;
        for (int i = 0; i < 3; i++) weaponDamage = weaponDamage + generateRandomNumberAttack();
        return weaponDamage;
    }

    public int generateRandomNumberAttack() {
        return random.nextInt(3) + 1;
    }
}
