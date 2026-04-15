import MODE_1.Character.Character;
import MODE_1.Character.*;

import java.util.*;

public class BattleSystem {
    private List<Character> players;
    private List<Enemy> enemies;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public BattleSystem(List<Character> players, List<Enemy> enemies) {
        this.players = players;
        this.enemies = enemies;
    }

    public void startBattle() {
        System.out.println("BATTLE STARTS !");
        int turnNumber = 0;

        while (arePlayersAlive() && areEnemiesAlive()) {
            turnNumber++;
            System.out.println("\n=== TURN " + turnNumber + " ===");

            // 1. Players turn
            List<Character> sortedPlayers = new ArrayList<>(players);
            sortedPlayers.sort((a, b) -> Integer.compare(b.getSpeed(), a.getSpeed()));

            for (Character player : sortedPlayers) {
                if (!player.isAlive()) continue;
                playerTurn(player);
                if (!areEnemiesAlive()) break;
            }
            if (!areEnemiesAlive()) break;

            // 2. Enemies turn
            List<Enemy> sortedEnemies = new ArrayList<>(enemies);
            sortedEnemies.sort((a, b) -> Integer.compare(b.getSpeed(), a.getSpeed()));

            for (Enemy enemy : sortedEnemies) {
                if (!enemy.isAlive()) continue;

                // Special boss logic
                if (enemy instanceof BossShadowLord) {
                    BossShadowLord boss = (BossShadowLord) enemy;
                    boss.nextTurn();
                    if (boss.isSpecialTurn()) {
                        boss.specialZoneAttack(players);
                    } else {
                        enemyTurn(enemy);
                    }
                } else {
                    enemyTurn(enemy);
                }

                if (!arePlayersAlive()) break;
            }
        }

        if (arePlayersAlive()) {
            System.out.println("\nVICTORY ! All enemies defeated.");
        } else {
            System.out.println("\nDEFEAT ! All players have fallen.");
        }
    }

    private void playerTurn(Character player) {
        System.out.println("\n--- " + player.getClass().getSimpleName() + "'s turn (HP: " + player.getLifePoint() + ") ---");
        System.out.println("1. Normal Attack");
        System.out.println("2. Special Attack");
        System.out.println("3. Defend");
        System.out.print("Choose action (1-3): ");
        int choice = scanner.nextInt();

        Enemy target = getRandomAliveEnemy();
        if (target == null) return;

        switch (choice) {
            case 1: // Normal Attack
                performNormalAttack(player, target);
                break;
            case 2: // Special Attack
                player.specialAttack(target);
                break;
            case 3: // Defend
                player.defend();
                break;
            default:
                System.out.println("Invalid choice - turn skipped.");
        }
    }

    private void performNormalAttack(Character player, Enemy target) {
        int dice = random.nextInt(6) + 1;
        int damage = (player.getAttack() + dice) - target.getDefense();
        if (damage < 0) damage = 0;

        if (dice == 6) {
            damage = (int) (damage * 1.5);
            System.out.println("Critical hit !");
        }

        target.takeDamage(damage);
        System.out.println("Damage dealt : " + damage);
    }

    private void enemyTurn(Enemy enemy) {
        Character target = getRandomAlivePlayer();
        if (target != null) {
            enemy.attack(target);
        }
    }

    private Enemy getRandomAliveEnemy() {
        List<Enemy> alive = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.isAlive()) alive.add(e);
        }
        return alive.isEmpty() ? null : alive.get(random.nextInt(alive.size()));
    }

    private Character getRandomAlivePlayer() {
        List<Character> alive = new ArrayList<>();
        for (Character p : players) {
            if (p.isAlive()) alive.add(p);
        }
        return alive.isEmpty() ? null : alive.get(random.nextInt(alive.size()));
    }

    private boolean arePlayersAlive() {
        for (Character p : players) {
            if (p.isAlive()) return true;
        }
        return false;
    }

    private boolean areEnemiesAlive() {
        for (Enemy e : enemies) {
            if (e.isAlive()) return true;
        }
        return false;
    }
}