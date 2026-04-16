package MODE_1.Character;

public class ThiefCharacter extends Character{
    public ThiefCharacter(){
        super(150, 15, 10, 10, 40);
    }

    public void specialAttack(Enemy target){

        int manaCost = 30;

        if (mana >= manaCost) {
            mana -= manaCost;

            int damage = attack + 30;
            target.takeDamage(damage);

            System.err.println("Hammer punch !!");
        }else{
            System.err.println("Not enough mana");
        }
    }
}
