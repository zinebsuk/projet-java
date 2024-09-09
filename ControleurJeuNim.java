package controleur;

import modele.Pile;
import vue.Ihm;

public class ControleurJeuNim {
        /*private Ihm ihm;
        private JeuNim jeu;
        private Joueur joueur1;
        private Joueur joueur2;
        public void initialiserJoueurs() {
            String nomJoueur1 = ihm.demanderNomJoueur(1);
            String nomJoueur2 = ihm.demanderNomJoueur(2);

            joueur1 = new Joueur(nomJoueur1);
            joueur2 = new Joueur(nomJoueur2);
        }

    public ControleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
    }

    public void jouer() {
        // Logique de jeu, gestion des tours, vérification de fin de partie, etc.
    }*/


    private final Ihm ihm;
    private int nombrePartiesJoueur1;
    private int nombrePartiesJoueur2;
    public ControlleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
        nombrePartiesJoueur1 = 0;
        nombrePartiesJoueur2 = 0;
    }
    public void jouer() {
        do {
            int nombreDeTas = ihm.lireNombreDeTas();
            String nomJoueur1 = ihm.lireNomJoueur1();
            String nomJoueur2 = ihm.lireNomJoueur2();
            Pile[] tas = creerTas(nombreDeTas);
            boolean tourJoueur1 = true;
            while (!estPartieTerminee(tas)) {
                afficherEtatDuJeu(tas, tourJoueur1 ? nomJoueur1 : nomJoueur2);
                int tasChoisi = ihm.lireTourJoueur(tourJoueur1 ? nomJoueur1 : nomJoueur2);
                retirerAllumettes(tas, tasChoisi - 1);
                tourJoueur1 = !tourJoueur1;
            }
            afficherEtatDuJeu(tas, tourJoueur1 ? nomJoueur1 : nomJoueur2);
            String nomVainqueur = tourJoueur1 ? nomJoueur2 : nomJoueur1;
            ihm.afficherVainqueur(nomVainqueur);
            if (tourJoueur1) {
                nombrePartiesJoueur1++;
            } else {
                nombrePartiesJoueur2++;
            }
            ihm.afficherResultats(nombrePartiesJoueur1, nombrePartiesJoueur2);
            ihm.afficherRejouer();
        } while (ihm.lireRejouer());
    }
    private Pile[] creerTas(int nombreDeTas) {
        Pile[] tas = new Pile[nombreDeTas];
        for (int i = 0; i < nombreDeTas; i++) {
            tas[i] = new Pile(2 * i + 1);
        }
        return tas;
    }
    private void afficherEtatDuJeu(Pile[] tas, String nomJoueur) {
        ihm.afficherEtatDuJeu(tas);
        System.out.println(nomJoueur + " : à vous de jouer.");
    }
    private boolean estPartieTerminee(Pile[] tas) {
        for (Pile pile : tas) {
             if (!pile.estVide()) {
                return false;
             }
        }
        return true;
    }
    private void retirerAllumettes(Pile[] tas, int tasChoisi) {
        System.out.print("Combien d'allumettes voulez-vous retirer du tas " + (tasChoisi + 1) + " ? ");
        int nombreAllumettesARetirer = ihm.lireNombreAllumettes();
        tas[tasChoisi].retirerAllumettes(nombreAllumettesARetirer);
    }
}
