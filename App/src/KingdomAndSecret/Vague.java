package KingdomAndSecret;

import java.util.ArrayList;
import java.util.List;

public class Vague {
    private int numero;
    private List<String> ennemis;
    private boolean dragonPresent;

    public Vague(int numero, boolean dragonPresent) {
        this.numero = numero;
        this.dragonPresent = dragonPresent;
        this.ennemis = new ArrayList<>();
        genererEnnemis();
    }

    private void genererEnnemis() {
        int nbEnnemis = numero * 2;
        for (int i = 1; i <= nbEnnemis; i++) {
            ennemis.add("Gobelin_" + i);
        }
        if (dragonPresent) {
            ennemis.add("DRAGON");
        }
    }

    public void attaquerRoyaume(Royaume royaume) {
        System.out.println("\nVague " + numero + " attaque le royaume !");
        for (String ennemi : ennemis) {
            int degats = ennemi.equals("DRAGON") ? 20 : 5;
            System.out.println("   -> " + ennemi + " attaque pour " + degats + " degats !");
            royaume.subirDegats(degats);
            if (royaume.estDetruit()) {
                System.out.println("Le royaume est tombe pendant la vague " + numero + " !");
                return;
            }
        }
    }

    public int getNombre(){
        return ennemis.size();
    }

    public int getNumero(){
        return numero;
    }

    public boolean hasDragon(){
        return dragonPresent;
    }

    @Override
    public String toString() {
        return "Vague[N=" + numero + " | Ennemis=" + ennemis.size() + " | Dragon=" + dragonPresent + "]";
    }
}
