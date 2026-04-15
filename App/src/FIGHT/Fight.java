package FIGHT;
import MODE_1.Character;

public class Fight {
    private Character character1;
    private Character character2;

    public Fight(Character character1, Character character2){
        this.character1 = character1;
        this.character2 = character2;
    }

    public void startFight() {

        Character first;
        Character second;

        // order based on speed
        if (character1.getSpeed() >= character2.getSpeed()) {
            first = character1;
            second = character2;
        } else {
            first = character2;
            second = character1;
        }

        while (character1.isAlive() && character2.isAlive()) {

            playTurn(first, second);

            if (second.isAlive()) {
                playTurn(second, first);
            }

            displayStatus();
        }

        // victory / defeat
        if (character1.isAlive()) {
            System.out.println("Victory!");
        } else {
            System.out.println("Defeat...");
        }
    }

    private void playTurn(Character attacker, Character defender) {
    if (Math.random() < 0.7) {

        attacker.attack(defender);
    } else {
        
        attacker.defend();
    }
}

    private void displayStatus() {
        System.out.println("\n Current status:");
        System.out.println( "Character 1" + " : " + character1.getLifePoint() + " HP");
        System.out.println("Character 2" + " : " + character2.getLifePoint() + " HP");
    }
}

