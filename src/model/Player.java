package model;

import java.util.Random;

public class Player {

    protected String name;
    protected int level;
    protected int stamina;
    protected int magic;
    protected String weapon;
    protected boolean isDead;
    private final Random random = new Random();

    public Player(String name, int level, int stamina, int magic, String weapon, boolean dead) {
        this.name = name;
        this.level = level;
        this.stamina = stamina;
        this.magic = magic;
        this.weapon = weapon;
        this.isDead = dead;
    }

    public Player(String name, String weapon) {
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
        this.weapon = weapon;
        this.isDead = false;
    }

    @Override
    public String toString() {
        return "Player---> " +
                "Name: " + name +
                " Level: " + level +
                " Stamina: " + stamina +
                " Magic: " + magic +
                " Weapon: " + weapon +
                " Dead: " + isDead;
    }

    public void attack(Player player) {
        // TODO: Borrar el sout del numero generado aleatoriamente
        System.out.println(generateRandomNumberAttack());
        player.setLevel(player.getLevel() + 1);
    }

    public void protect() { // TODO

    }

    public void weaponSkill() { // TODO

    }

    public void classSkill() { // TODO

    }

    public void escape() { // TODO

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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    private int generateRandomNumber() {
        return random.nextInt(10) + 1;
    }

    private int generateRandomNumberAttack() {
        return random.nextInt(6) + 1;
    }
}
