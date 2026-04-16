package MODE_1.Character;

import java.util.Random;

public abstract class Character {

    protected int maxLifePoint;
    protected int lifePoint;
    protected int attack;
    protected int speed;
    protected int defense;
    protected int mana;

    protected boolean defending = false;

    protected Random random = new Random();

    public Character(int lifePoint, int attack, int speed, int defense, int mana){
        this.maxLifePoint = lifePoint;
        this.lifePoint = lifePoint;
        this.attack = attack;
        this.speed = speed;
        this.defense = defense;
        this.mana = mana;
    }

    // ======================
    // GETTERS
    // ======================

    public int getLifePoint(){
        return lifePoint;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public int getMana(){
        return mana;
    }

    public boolean isAlive(){
        return lifePoint > 0;
    }


    // ======================
    // COMMON SHARES
    // ======================


    public void attack(Character target){

        int dice = random.nextInt(6) + 1;

        int damage = (this.attack + dice) - target.defense;

        if(damage < 0){
            damage = 0;
        }

        // Critical hit if dice = 6
        if(dice == 6){
            damage = (int)(damage * 1.5);
            System.out.println("Critical hit !");
        }

        target.takeDamage(damage);
        System.out.println("Damage dealt : " + damage);
    }

    // Defense (50% reduction until next turn)
    public void defend(){
        defending = true;
        System.out.println("Defense mode activated!");
    }

    // Take damage
    public void takeDamage(int damage){

        if(defending){
            damage = damage / 2;
            defending = false;
            System.out.println("Damage reduced thanks to defense!");
        }

        lifePoint -= damage;

        if(lifePoint < 0){
            lifePoint = 0;
        }

        System.out.println("Remaining HP:" + lifePoint);
    }

    // Mana recharge
    public void manaRecharge(){
        mana += 10;
        System.out.println("Mana recharged!");
    }

    // Recovery between rooms (max 20% HP)
    public void recoverBetweenRooms(){
        int heal = (int)(maxLifePoint * 0.2);
        lifePoint += heal;

        if(lifePoint > maxLifePoint){
            lifePoint = maxLifePoint;
        }

        System.out.println("Recovery of " + heal + " HP.");
    }

    // ======================
    // TO BE DEFINED BY EACH CLASS
    // ======================

    public abstract void specialAttack(Enemy target);
}