package MODE_1.Character;

public class KnightCharacter extends Character{
    public KnightCharacter(){
        super(150, 15, 5, 10, 30);
    }

    public void specialAttack(Character target){

        int manaCost = 15;

        if (mana >= manaCost) {
            mana -= manaCost;

            this.defense += 5;
            System.err.println("Increase defense");
            
        }else{
            System.err.println("not enough mana");
        }
    }
}
