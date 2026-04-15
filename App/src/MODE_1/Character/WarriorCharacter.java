package MODE_1.Character;

public class WarriorCharacter extends Character{

    public WarriorCharacter(){
        super(150, 15, 5, 10, 30);
    }

    
    public void specialAttack(Enemy target){

        int manaCost = 15;

        if (mana >= manaCost) {
            mana -= manaCost;

            int damage = attack * 2;
            target.takeDamage(damage);

            System.err.println("The warrior's powerful attack !!");
        }else{
            System.err.println("Not enough mana");
        }
    }
    
}
