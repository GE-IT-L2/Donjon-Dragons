import MODE_1.Character.*;
import MODE_1.Character.Character;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("         DONJON & DRAGON - THE CURSED DUNGEON (MODE 1)     ");
        System.out.println("            Strategic Turn-Based Java Edition                  ");
        System.out.println("==============================================================");

        // Create the party (you can change or add more heroes here)
        List<Character> party = new ArrayList<>();

        party.add(new WarriorCharacter());
        party.add(new KnightCharacter());
        party.add(new MageCharacter());
        party.add(new ArcherCharacter());
        // party.add(new ThiefCharacter()); // uncomment if you want 5 players

        System.out.println("\nYour party has been summoned:");
        for (Character hero : party) {
            System.out.println("   • " + hero.getClass().getSimpleName() +
                               " | HP:" + hero.getLifePoint() +
                               " | ATK:" + hero.getAttack() +
                               " | SPD:" + hero.getSpeed() +
                               " | DEF:" + hero.getDefense() +
                               " | MANA:" + hero.getMana());
        }

        System.out.println("\nThe adventure begins... Good luck, adventurers!");

        // Launch the full dungeon
        Dungeon dungeon = new Dungeon(party);
        dungeon.startDungeon();

        System.out.println("\nThank you for playing DONJON & DRAGON in Java!");
        System.out.println("Made with the rules from your PDF.");
    }
}