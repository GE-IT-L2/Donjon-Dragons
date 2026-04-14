package KingdomAndSecret;

public class CristalNoir {
    private int pointsVie;
    private boolean actif;

    public CristalNoir(int pointsVie) {
        this.pointsVie = pointsVie;
        this.actif = true;
    }

    public void corrompre(Royaume royaume) {
        if (actif) {
            royaume.activerCorruption();
        } else {
            System.out.println("Le Cristal Noir est detruit, aucune corruption possible.");
        }
    }

    public void subirDegats(int degats) {
        if (!actif) {
            System.out.println("Le Cristal Noir est deja detruit.");
            return;
        }
        pointsVie -= degats;
        if (pointsVie < 0) pointsVie = 0;
        System.out.println("Cristal Noir subit " + degats + " degats -> PV restants : " + pointsVie);
        if (pointsVie <= 0) {
            actif = false;
            System.out.println("Le Cristal Noir est detruit ! La corruption est levee !");
        }
    }

    public boolean isActif(){
        return actif;
    }

    public int getPointsVie(){
        return pointsVie;
    }

    @Override
    public String toString() {
        return "CristalNoir[PV=" + pointsVie + " | Actif=" + actif + "]";
    }
}