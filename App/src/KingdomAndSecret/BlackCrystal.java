package KingdomAndSecret;

public class BlackCrystal {
    private int pointsVie;
    private boolean actif;
    private Kingdom royaume;

    public BlackCrystal(int pointsVie, Kingdom royaume) {
        this.pointsVie = Math.max(0, pointsVie);
        this.actif = this.pointsVie > 0;
        this.royaume = royaume;
    }

    public void corrompre() {
        if (actif) {
            royaume.activerCorruption();
        } else {
            System.out.println("Le Cristal Noir est inactif.");
        }
    }

    public void subirDegats(int degats) {
        if (!actif) {
            System.out.println("Le cristal est déjà en miettes...");
            return;
        }

        pointsVie -= degats;

        if (pointsVie <= 0) {
            pointsVie = 0;
            actif = false;
            System.out.println("Destruction ! La corruption est levée.");
            royaume.desactiverCorruption(); // lien direct
        } else {
            System.out.println("Le Cristal vacille. PV restants : " + pointsVie);
        }
    }

    public boolean isActif() { return actif; }
    public int getPointsVie() { return pointsVie; }

    @Override
    public String toString() {
        return String.format("CristalNoir[PV=%d | Actif=%b]", pointsVie, actif);
    }
}