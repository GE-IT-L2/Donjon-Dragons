package KingdomAndSecret;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Mode Royaume");
        System.out.println("2. Mode Secret");
        System.out.print("Votre choix : ");

        int choix = -1;
        while (choix < 1 || choix > 2) {
            try {
                choix = Integer.parseInt(scanner.nextLine().trim());
                if (choix < 1 || choix > 2) {
                    System.out.print("Entrez 1 ou 2 : ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrez un nombre valide : ");
            }
        }

        if (choix == 1) {
            ModeRoyaume.demarrer();
        } else {
            ModeSecret.demarrer();
        }

        scanner.close();
    }
}
