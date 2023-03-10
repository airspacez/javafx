package ObjectiveProgramming.ChildClasses;

import ObjectiveProgramming.ParentClasses.GameObject;

public class Artifact extends GameObject {

    private String name;
    private String rarity;
    private int damage;
    private int health;

    public Artifact() {
        name = "stone";
        rarity = "normal";
        damage = 0;
        health = 0;
        x = 5;
        y = 5;
    }

    public Artifact(String name) {
        this.name = name;
        rarity = "normal";
        damage = 0;
        health = 0;
        x = 5;
        y = 5;
    }

    public Artifact(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
        damage = 0;
        health = 0;
        x = 5;
        y = 5;
    }

    public Artifact(int x, int y) {
        name = "stone";
        rarity = "normal";
        damage = 0;
        health = 0;
        this.x = x;
        this.y = y;
    }

    public Artifact(String name, String rarity, int damage, int health, int x, int y) {
        this.name = name;
        this.rarity = rarity;
        this.damage = damage;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
