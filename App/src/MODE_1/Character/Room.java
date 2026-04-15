package MODE_1.Character;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Enemy> enemies;
    private String type;          
    private boolean isBossRoom;


    public Room(String type, List<Enemy> enemies) {
        this.type = type;
        this.enemies = (enemies != null) ? enemies : new ArrayList<>();
        this.isBossRoom = false;
    }


    public Room(BossShadowLord boss) {
        this.type = "BOSS";
        this.enemies = new ArrayList<>();
        this.enemies.add(boss);
        this.isBossRoom = true;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public String getType() {
        return type;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public boolean isCombatRoom() {
        return "COMBAT".equals(type) || isBossRoom;
    }

    public void enterRoom() {
        System.out.println("\n========================================");
        System.out.println("You enter ROOM TYPE : " + type);
        if (isBossRoom) {
            System.out.println("THE SHADOW LORD appears before you!");
        } else if (!enemies.isEmpty()) {
            System.out.println("Enemies present : " + enemies.size());
            for (Enemy e : enemies) {
                System.out.println("   - " + e.getClass().getSimpleName() + " (HP: " + e.getLifePoint() + ")");
            }
        } else if ("TRAP".equals(type)) {
            System.out.println("A dangerous trap is triggered!");
        } else if ("REWARD".equals(type)) {
            System.out.println("You found a treasure! (healing coming soon)");
        }
        System.out.println("========================================\n");
    }


    public boolean hasEnemiesLeft() {
        for (Enemy e : enemies) {
            if (e.isAlive()) {
                return true;
            }
        }
        return false;
    }
}