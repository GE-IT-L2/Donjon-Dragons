package KingdomAndSecret;

import java.util.Scanner;

public class ModeSecret {
    private static final int LIMITE_TOURS = 10;
    private static final int DEGATS_CORRUPTION = 5;

    public static void demarrer() {
        Scanner scanner = new Scanner(System.in);
        Royaume royaume = new Royaume("Eldoria", 100);
        CristalNoir cristal = new CristalNoir(50);

        System.out.println("=== MODE SECRET ===");
        System.out.println("Le Cristal Noir est apparu ! Vous avez " + LIMITE_TOURS + " tours pour le detruire.");
        System.out.println("Attention : la corruption enleve " + DEGATS_CORRUPTION + " PV au royaume chaque tour.");
        System.out.println(royaume);
        System.out.println(cristal);

        cristal.corrompre(royaume);

        int tour = 1;

        while (tour <= LIMITE_TOURS && !royaume.estDetruit() && cristal.isActif()) {
            System.out.println("\n=== TOUR " + tour + "/" + LIMITE_TOURS + " ===");
            System.out.println(royaume);
            System.out.println(cristal);

            // rehefa mamadika dia -5 PV isakin'ny tour tour
            royaume.appliquerCorruption();

            if (royaume.estDetruit()) break;

            // Eto amatarana ny vgaue isakin'ny tour
            Vague vague = new Vague(tour, tour % 3 == 0);
            System.out.println(vague);

            System.out.print("Appuyez sur Entree pour continuer...");
            scanner.nextLine();

            vague.attaquerRoyaume(royaume);

            if (royaume.estDetruit()) break;

            // joueur iray manao attaque anle Cristal Noir
            System.out.println("\nVous attaquez le Cristal Noir !");
            System.out.print("Choisissez votre force d'attaque (1=faible:10 / 2=normale:20 / 3=forte:30) : ");
            int choix = -1;
            while (choix < 1 || choix > 3) {
                try {
                    choix = Integer.parseInt(scanner.nextLine().trim());
                    if (choix < 1 || choix > 3) {
                        System.out.print("Entrez 1, 2 ou 3 : ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Entrez un nombre valide : ");
                }
            }

            int degatsJoueur = choix * 10;
            cristal.subirDegats(degatsJoueur);

            tour++;
        }

        System.out.println("\n=== RESULTAT MODE SECRET ===");
        if (!cristal.isActif()) {
            System.out.println("VICTOIRE : Vous avez detruit le Cristal Noir !");
            System.out.println("Le royaume " + royaume.getNom() + " est sauve avec " + royaume.getPointsVie() + " PV !");
        } else if (royaume.estDetruit()) {
            System.out.println("DEFAITE : Le royaume est tombe sous la corruption !");
        } else {
            System.out.println("DEFAITE : Les " + LIMITE_TOURS + " tours sont ecoules, le Cristal Noir a gagne !");
        }
    }
}
