package MODE_1.Character;

import java.util.List;

public class BossShadowLord extends Enemy {
    private int turnCounter = 0;

    public BossShadowLord() {
        super(350, 32, 12, 18);
    }

    public void specialZoneAttack(List<Character> players) {
        System.out.println("SHADOW LORD - ZONE ATTACK !");
        System.out.println("All players take 25 fixed damage!");
        for (Character player : players) {
            if (player.isAlive()) {
                player.takeDamage(25);
            }
        }
    }

    public void nextTurn() {
        turnCounter++;
    }

    public boolean isSpecialTurn() {
        return turnCounter % 3 == 0 && turnCounter > 0;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    @Override
    public void takeDamage(int damage) {
        lifePoint -= damage;
        if (lifePoint < 0) lifePoint = 0;
        System.out.println("Shadow Lord hit! Remaining HP: " + lifePoint);
    }
}