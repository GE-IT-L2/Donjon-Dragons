package MODE_1.Character;

public class MageCharacter extends Character{

    public MageCharacter(){
        super(150, 10, 5, 15, 100);
    }

    public void specialAttack(Character target){
        
        int manaCost = 30;

        if (mana >= manaCost) {
            mana -= manaCost;

            int damage = attack * 3;
            target.takeDamage(damage);

            System.err.println("Supreme fireball !! yaaa");
        }else{
            System.err.println("Not enough mana");
        }
    }
}
