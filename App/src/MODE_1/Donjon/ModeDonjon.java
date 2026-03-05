package MODE_1.Donjon;

import MODE_1.Character.Character;

public class ModeDonjon {

    public static void main(String[] args) {

        // Local Hero class as an anonymous subclass of Character
        Character hero = new Character(100, 15, 10, 5, 30) {
            @Override
            public void specialAttack(Character target) {
                int damage = this.getAttack() * 2;
                target.takeDamage(damage);
                System.out.println("Hero uses Mighty Strike for " + damage + " damage!");
            }
        };

        // Local Enemy class as an anonymous subclass of Character
        Character enemy = new Character(80, 12, 8, 3, 20) {
            @Override
            public void specialAttack(Character target) {
                int damage = this.getAttack() + 5;
                target.takeDamage(damage);
                System.out.println("Enemy uses Ferocious Bite for " + damage + " damage!");
            }
        };

        System.out.println("=== Dungeon Mode Started ===");
        System.out.println("A wild enemy appears!\n");

        int round = 1;

        // Battle loop
        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("=== Round " + round + " ===");

            // Whoever has higher speed attacks first
            if (hero.getSpeed() >= enemy.getSpeed()) {
                takeTurn(hero, enemy);
                if (enemy.isAlive()) takeTurn(enemy, hero);
            } else {
                takeTurn(enemy, hero);
                if (hero.isAlive()) takeTurn(hero, enemy);
            }

            round++;
            System.out.println();
        }

        // Outcome
        if (hero.isAlive()) {
            System.out.println("Hero wins the battle!");
        } else {
            System.out.println("Enemy wins the battle!");
        }

        System.out.println("=== Dungeon Mode Ended ===");
    }

    // Handle a single turn
    private static void takeTurn(Character attacker, Character defender) {
        int choice = (int) (Math.random() * 3); // 0 = attack, 1 = defend, 2 = special
        switch (choice) {
            case 0:
                System.out.println(attacker.getClass().getSimpleName() + " chooses to attack!");
                attacker.attack(defender);
                break;
            case 1:
                System.out.println(attacker.getClass().getSimpleName() + " chooses to defend!");
                attacker.defend();
                break;
            case 2:
                System.out.println(attacker.getClass().getSimpleName() + " uses special attack!");
                attacker.specialAttack(defender);
                break;
        }
    }
}
