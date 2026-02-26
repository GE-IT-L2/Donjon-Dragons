
public class Thief {

    // Fields
    private String name;
    private int health;
    private int mana;
    private int agility;
    private int defense;

    
    public Thief(String name, int health, int mana, int agility, int defense) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.agility = agility;
        this.defense = defense;
    }

    
    public String getName() {
        return name;
    }

    public int getHP() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getSpeed() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setSpeed(int agility) {
        this.agility = agility;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    
    public void attack() {
        System.out.println(name + " attacks with agility!");
    }

    public void steal() {
        System.out.println(name + " steals from the enemy!");
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health -= actualDamage;
        System.out.println(name + " takes " + actualDamage + " damage! Remaining HP: " + health);
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " heals for " + amount + " HP! Current HP: " + health);
    }
}