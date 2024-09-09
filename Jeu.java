package modele;

public class Jeu {
    private final Pile[] tas;
    public Jeu(int nombreDeTas) {
        this.tas = new Pile[nombreDeTas];
        for (int i = 0; i < nombreDeTas; i++) {
             tas[i] = new Pile(2 * i + 1);
        }
    }
    public boolean estPartieTerminee() {
        for (Pile pile : tas) {
            if (!pile.estVide()) {
                 return false;
            }
        }
        return true;
    }
    public void retirerAllumettes(int tasChoisi, int nombreAllumettesARetirer) {
        tas[tasChoisi].retirerAllumettes(nombreAllumettesARetirer);
    }
    public int getNombreAllumettes(int tasChoisi) {
         return tas[tasChoisi].getNombreAllumettes();
    }
}
