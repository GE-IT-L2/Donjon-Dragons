package KingdomAndSecret;

import java.util.Objects;

public class Kingdom {
    private static final int CORRUPTION_DAMAGE = 5;
    private static final int MIN_HEALTH = 0;

    private final String nom;
    private int pointsVie;
    private final int pointsVieMax;
    private boolean corrompu;

    public Kingdom(String nom, int pointsVie) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du royaume ne peut pas être vide.");
        }
        if (pointsVie <= 0) {
            throw new IllegalArgumentException("Les points de vie doivent être positifs.");
        }
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.pointsVieMax = pointsVie;
        this.corrompu = false;
    }

    public void subirDegats(int degats) {
        if (degats < 0) {
            throw new IllegalArgumentException("Les dégâts ne peuvent pas être négatifs.");
        }
        pointsVie = Math.max(MIN_HEALTH, pointsVie - degats);
        System.out.printf("%s subit %d dégâts → PV restants : %d/%d%n",
                nom, degats, pointsVie, pointsVieMax);
    }

    public void appliquerCorruption() {
        if (corrompu) {
            System.out.printf("Corruption active : %s perd %d PV !%n", nom, CORRUPTION_DAMAGE);
            subirDegats(CORRUPTION_DAMAGE);
        }
    }

    public boolean activerCorruption() {
        if (corrompu) return false;
        corrompu = true;
        System.out.printf("Le Cristal Noir corrompt le royaume %s !%n", nom);
        return true;
    }

    public boolean desactiverCorruption() {
        if (!corrompu) return false;
        corrompu = false;
        System.out.printf("La corruption est levée sur %s !%n", nom);
        return true;
    }

    public boolean estDetruit() { return pointsVie <= MIN_HEALTH; }
    public boolean estCorrompu() { return corrompu; }
    public int getPointsVie() { return pointsVie; }
    public int getPointsVieMax() { return pointsVieMax; }
    public String getNom() { return nom; }

    @Override
    public String toString() {
        return String.format("Royaume[%s | PV=%d/%d | Corrompu=%b]",
                nom, pointsVie, pointsVieMax, corrompu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kingdom k)) return false;
        return Objects.equals(nom, k.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}