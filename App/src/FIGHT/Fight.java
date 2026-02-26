package FIGHT;
import MODE_1.Character;

public class Fight {
    private Character character1;
    private Character character2;

    public Fight(Character character1, Character character2){
        this.character1 = character1;
        this.character2 = character2;
    }
    
    public void startFight(){
        while(character1.isAlive() && character2.isAlive()){
            if(character1.getSpeed() >= character2.getSpeed()){
                character1.attack(character2);
                if(character2.isAlive()){
                    character2.attack(character1);
                }
            } else {
                character2.attack(character1);
                if(character1.isAlive()){
                    character1.attack(character2);
                }
            }
        }
    }

    public void displayWinner(){
        if(character1.isAlive()){
            System.out.println("Character 1 wins!");
        } else if(character2.isAlive()){
            System.out.println("Character 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
