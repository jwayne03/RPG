package model;

public class Weapon {

    private String weaponName;

    public Weapon(String weaponName, int damage) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
