package KingdomAndSecret;

public class Kingdom {
    private String nom;
    private int pointsVie;
    private boolean corrompu;

    public Kingdom(String nom, int pointsVie) {
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.corrompu = false;
    }

    public void subirDegats(int degats) {
        pointsVie -= degats;
        if (pointsVie < 0) pointsVie = 0;
        System.out.println(nom + " subit " + degats + " degats -> PV restants : " + pointsVie);
    }

    public void appliquerCorruption() {
        if (corrompu) {
            System.out.println("Corruption active : " + nom + " perd 5 PV !");
            subirDegats(5);
        }
    }

    public void activerCorruption() {
        this.corrompu = true;
        System.out.println("Le Cristal Noir corrompt le royaume " + nom + " !");
    }

    public boolean estDetruit() {
        return pointsVie <= 0;
    }

    public int getPointsVie() { return pointsVie; }
    public String getNom() { return nom; }

    @Override
    public String toString() {
        return "Royaume[" + nom + " | PV=" + pointsVie + " | Corrompu=" + corrompu + "]";
    }

}
