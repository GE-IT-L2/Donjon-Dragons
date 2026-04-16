package KingdomAndSecret;

import java.util.Scanner;

public class ModeRoyaume {
    private static final int NB_VAGUES = 5;

    public static void demarrer() {
        Scanner scanner = new Scanner(System.in);
        Royaume royaume = new Royaume("Eldoria", 100);

        System.out.println("=== MODE ROYAUME ===");
        System.out.println("Defendez le royaume contre " + NB_VAGUES + " vagues ennemies !");
        System.out.println(royaume);

        for (int i = 1; i <= NB_VAGUES; i++) {
            if (royaume.estDetruit()) break;

            System.out.println("\n--- VAGUE " + i + "/" + NB_VAGUES + " ---");

            boolean dragonCeTour = (i == NB_VAGUES); // Dragon uniquement a la derniere vague
            Vague vague = new Vague(i, dragonCeTour);
            System.out.println(vague);

            System.out.print("Appuyez sur Entree pour lancer la vague...");
            scanner.nextLine();

            vague.attaquerRoyaume(royaume);

            if (!royaume.estDetruit()) {
                System.out.println("\n--- Fin de la vague " + i + " ---");
                System.out.println(royaume);
            }
        }

        System.out.println("\n=== RESULTAT MODE ROYAUME ===");
        if (royaume.estDetruit()) {
            System.out.println("DEFAITE : Le royaume " + royaume.getNom() + " est tombe !");
        } else {
            System.out.println("VICTOIRE : Le royaume " + royaume.getNom() + " a resiste !");
            System.out.println("PV finaux : " + royaume.getPointsVie());
        }
    }
}
