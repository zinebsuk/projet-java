package modele;

public class JeuNim {
    private int nombreTas;
    private int[] tas;

    public JeuNim(int nombreTas) {
        this.nombreTas = nombreTas;
        this.tas = new int[nombreTas];
        initialiserTas();
    }

    private void initialiserTas() {
        // Initialisation des tas avec un nombre impair d'allumettes
        for (int i = 0; i < nombreTas; i++) {
            tas[i] = 2 * i + 1;
        }
    }

    public int getNombreTas() {
        return nombreTas;
    }

    public int[] getTas() {
        return tas;
    }

    // Méthodes pour effectuer un coup, vérifier la validité du coup, vérifier si la partie est terminée, etc.


    // ... (autres membres)

    public boolean estPartieTerminee() {
        for (int tas : tas) {
            if (tas > 0) {
                return false; // Il reste au moins une allumette dans un tas
            }
        }
        return true; // Tous les tas sont vides
    }

    public boolean estCoupValide(int tasChoisi, int nombreAllumettes) {
        if (tasChoisi < 1 || tasChoisi > nombreTas || tas[tasChoisi - 1] == 0) {
            return false; // Le tas choisi n'est pas valide
        }

        if (nombreAllumettes < 1 || nombreAllumettes > tas[tasChoisi - 1]) {
            return false; // Nombre d'allumettes invalide
        }

        return true;
    }

    public void jouerCoup(int tasChoisi, int nombreAllumettes) {
        if (estCoupValide(tasChoisi, nombreAllumettes)) {
            tas[tasChoisi - 1] -= nombreAllumettes; // Retirer les allumettes du tas choisi
        }
    }

    // Autres méthodes nécessaires
}
