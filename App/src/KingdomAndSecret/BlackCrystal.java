package KingdomAndSecret;

import java.util.Objects;

public class BlackCrystal {
    private static final int MIN_HEALTH = 0;

    private final int pointsVieMax;
    private int pointsVie;
    private boolean actif;
    private final Kingdom royaume;

    public BlackCrystal(int pointsVie, Kingdom royaume) {
        if (royaume == null) {
            throw new IllegalArgumentException("Un cristal doit être lié à un royaume.");
        }
        if (pointsVie <= 0) {
            throw new IllegalArgumentException("Les points de vie doivent être positifs.");
        }
        this.pointsVie = pointsVie;
        this.pointsVieMax = pointsVie;
        this.actif = true;
        this.royaume = royaume;
    }

    public void corrompre() {
        if (!actif) {
            System.out.println("Le Cristal Noir est inactif, il ne peut plus corrompre.");
            return;
        }
        boolean corruptionAppliquee = royaume.activerCorruption();
        if (!corruptionAppliquee) {
            System.out.printf("Le royaume %s est déjà corrompu.%n", royaume.getNom());
        }
    }

    public void subirDegats(int degats) {
        if (degats < 0) {
            throw new IllegalArgumentException("Les dégâts ne peuvent pas être négatifs.");
        }
        if (!actif) {
            System.out.println("Le cristal est déjà en miettes...");
            return;
        }

        pointsVie = Math.max(MIN_HEALTH, pointsVie - degats);
        System.out.printf("Le Cristal subit %d dégâts → PV restants : %d/%d%n",
                degats, pointsVie, pointsVieMax);

        if (pointsVie <= MIN_HEALTH) {
            detruire();
        }
    }

    private void detruire() {
        actif = false;
        System.out.printf("Le Cristal Noir lié à %s est détruit ! La corruption est levée.%n",
                royaume.getNom());
        royaume.desactiverCorruption();
    }

    public Kingdom getRoyaume() { return royaume; }
    public boolean isActif() { return actif; }
    public int getPointsVie() { return pointsVie; }
    public int getPointsVieMax() { return pointsVieMax; }

    @Override
    public String toString() {
        return String.format("CristalNoir[PV=%d/%d | Actif=%b | Royaume=%s]",
                pointsVie, pointsVieMax, actif, royaume.getNom());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlackCrystal bc)) return false;
        return Objects.equals(royaume, bc.royaume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(royaume);
    }
}