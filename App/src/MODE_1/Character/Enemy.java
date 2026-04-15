package MODE_1.Character;

import java.util.Random;

public abstract class Enemy {
    protected int maxLifePoint;
    protected int lifePoint;
    protected int attack;
    protected int speed;
    protected int defense;

    protected Random random = new Random();

    public Enemy(int lifePoint, int attack, int speed, int defense) {
        this.maxLifePoint = lifePoint;
        this.lifePoint = lifePoint;
        this.attack = attack;
        this.speed = speed;
        this.defense = defense;
    }

    // GETTERS
    public int getLifePoint() { return lifePoint; }
    public int getAttack() { return attack; }
    public int getSpeed() { return speed; }
    public int getDefense() { return defense; }
    public boolean isAlive() { return lifePoint > 0; }

    // ATTACK (exact rules from PDF)
    public void attack(Character target) {
        int dice = random.nextInt(6) + 1;
        int damage = (this.attack + dice) - target.getDefense();
        if (damage < 0) damage = 0;

        if (dice == 6) {
            damage = (int) (damage * 1.5);
            System.out.println("Critical hit from enemy!");
        }

        target.takeDamage(damage);
        System.out.println("Enemy deals " + damage + " damage!");
    }

    // TAKE DAMAGE
    public void takeDamage(int damage) {
        lifePoint -= damage;
        if (lifePoint < 0) lifePoint = 0;
        System.out.println("Enemy hit! Remaining HP: " + lifePoint);
    }
}