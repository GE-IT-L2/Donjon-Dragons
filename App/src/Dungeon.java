import MODE_1.Character.Character;
import MODE_1.Character.*;

import java.util.*;

public class Dungeon {
    private List<Character> players;
    private List<Room> rooms;

    public Dungeon(List<Character> players) {
        this.players = players;
        this.rooms = createRooms();
    }

    private List<Room> createRooms() {
        List<Room> dungeonRooms = new ArrayList<>();

        // Room 1
        dungeonRooms.add(new Room("COMBAT", List.of(new Goblin(), new Goblin())));

        // Room 2
        dungeonRooms.add(new Room("COMBAT", List.of(new Goblin(), new Skeleton())));

        // Room 3
        dungeonRooms.add(new Room("COMBAT", List.of(new Skeleton(), new Skeleton(), new DarkKnight())));

        // Room 4
        dungeonRooms.add(new Room("COMBAT", List.of(new DarkKnight(), new Goblin())));

        // Room 5 : Boss final
        dungeonRooms.add(new Room(new BossShadowLord()));

        return dungeonRooms;
    }

    public void startDungeon() {
        System.out.println("========================================");
        System.out.println("THE CURSED DUNGEON - MODE 1 STARTS !");
        System.out.println("You must survive 5 rooms and defeat the Shadow Lord.");
        System.out.println("========================================\n");

        for (int i = 0; i < rooms.size(); i++) {
            Room currentRoom = rooms.get(i);
            int roomNumber = i + 1;

            // Recovery 20% HP between rooms (except first room)
            if (roomNumber > 1) {
                System.out.println("Recovery between rooms (+20% max HP)");
                for (Character player : players) {
                    if (player.isAlive()) {
                        player.recoverBetweenRooms();
                    }
                }
                System.out.println("----------------------------------------");
            }

            currentRoom.enterRoom();

            // If combat room -> launch battle
            if (currentRoom.isCombatRoom()) {
                BattleSystem battle = new BattleSystem(players, currentRoom.getEnemies());
                battle.startBattle();

                // If all players are dead -> game over
                if (!arePlayersAlive()) {
                    System.out.println("\nGAME OVER - The party has fallen in room " + roomNumber);
                    return;
                }
            }
        }

        System.out.println("\nCONGRATULATIONS ! You have cleared THE CURSED DUNGEON !");
        System.out.println("The Shadow Lord is defeated. Victory in MODE 1 !");
    }

    private boolean arePlayersAlive() {
        for (Character p : players) {
            if (p.isAlive()) return true;
        }
        return false;
    }
}