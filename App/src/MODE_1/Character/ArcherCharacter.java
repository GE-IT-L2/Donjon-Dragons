package MODE_1.Character;

public class ArcherCharacter extends Character{
    public ArcherCharacter(){
        super(150, 25, 20, 10, 20);
    }

    public void specialAttack(Character target){
        
        int manaCost = 10;

        if (mana >= manaCost) {
            mana -= manaCost;

            int damage = attack + 20;
            target.takeDamage(damage);

            System.err.println("Arrow volley");
        }else{
            System.err.println("Not enough mana");
        }
    }
}
