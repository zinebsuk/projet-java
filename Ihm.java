package vue;

import modele.JeuNim;
import modele.Joueur;

import java.util.Scanner;

public class Ihm {
    /*private Scanner scanner;

    public Ihm() {

        this.scanner = new Scanner(System.in);
    }

    public int demanderNombreTas() {
        System.out.print("Veuillez entrer le nombre de tas : ");
        return scanner.nextInt();
    }

    public String demanderNomJoueur(int numeroJoueur) {
        System.out.print("Entrez le nom du joueur " + numeroJoueur + " : ");
        return scanner.next();
    }

    public void afficherEtatJeu(JeuNim jeu) {
        // Afficher l'état du jeu (tas, nombre d'allumettes, etc.)
    }

    public String demanderCoup(Joueur joueur) {
        // Demander au joueur de jouer son coup et retourner la saisie
        System.out.println( joueur + " vous devais jouer votre coup");
        return scanner.next();
    }

    public void informerCoupInvalide() {
        System.out.println("Coup invalide. Veuillez réessayer.");
    }

    public void afficherGagnant(String nomGagnant) {
        System.out.println("Le gagnant est : " + nomGagnant);
    }

    // Autres méthodes d'interaction avec l'utilisateur*/

    private Scanner scanner;

    public Ihm() {
        scanner = new Scanner(System.in);
    }
    public int lireNombreDeTas() {
        System.out.print("Entrez le nombre de tas avec lequel vous souhaitez jouer : ");
        int nombreDeTas = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour chariot
        return nombreDeTas;
    }

    public String lireNomJoueur1() {
        System.out.print("Entrez le nom du joueur 1 : ");
        String nomJoueur1 = scanner.nextLine();
        return nomJoueur1;
    }
    public String lireNomJoueur2() {
        System.out.print("Entrez le nom du joueur 2 : ");
        String nomJoueur2 = scanner.nextLine();
        return nomJoueur2;
    }
    public int lireTourJoueur(String nomJoueur) {
        System.out.print(nomJoueur + " : à vous de jouer un coup sous la forme 'm n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas : ");
        int tasChoisi = scanner.nextInt();
        int nombreAllumettesARetirer = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour chariot
        return tasChoisi;
    }
    public void afficherEtatDuJeu(Pile[] tas) {
        System.out.println("État du jeu :");
        for (int i = 0; i < tas.length; i++) {
            System.out.println("Tas " + (i + 1) + " -> " + tas[i].getNombreAllumettes() + " allumettes");
            }
    }
    public void afficherVainqueur(String nomJoueur) {
        System.out.println("Le joueur " + nomJoueur + " a pris la dernière allumette et gagne la partie.");
    }
    public void afficherResultats(int nombrePartiesJoueur1, int nombrePartiesJoueur2) {
        System.out.println("Résultats :");
        System.out.println("Joueur 1 : " + nombrePartiesJoueur1 + " parties gagnées");
        System.out.println("Joueur 2 : " + nombrePartiesJoueur2 + " parties gagnées");
        if (nombrePartiesJoueur1 > nombrePartiesJoueur2) {
             System.out.println("Le joueur 1 est le vainqueur.");
        } else if (nombrePartiesJoueur1 < nombrePartiesJoueur2) {
            System.out.println("Le joueur 2 est le vainqueur.");
        } else {
            System.out.println("Ex aequo.");
        }
    }
}
