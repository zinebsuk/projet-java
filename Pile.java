package modele;

public class Pile {

    private int nombreAllumettes;
    public Pile(int nombreAllumettes) {
            this.nombreAllumettes = nombreAllumettes;
    }
   public int getNombreAllumettes() {
         return nombreAllumettes;
    }
  public void retirerAllumettes(int nombre) {
        if (nombre <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes à retirer doit être supérieur à 0.");
            }
        if (nombre > nombreAllumettes) {
            throw new IllegalArgumentException("Le nombre d'allumettes à retirer est supérieur au nombre d'allumettes dans la pile.");
        }
        nombreAllumettes -= nombre;
        }
}