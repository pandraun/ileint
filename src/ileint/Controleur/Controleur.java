package ileint.Controleur;

import ileint.Carte.CarteInnondation;
import ileint.Carte.CarteOrange;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import java.util.ArrayList;

/**
 *
 * @author fodorg
 */
public class Controleur {
    private int niveauEau;
    private ArrayList<CarteInnondation> piocheInnondation; // 0..24
    private ArrayList<CarteInnondation> defausseInnondation; // 0..24
    private ArrayList<CarteOrange> piocheOrange; //0..28
    private ArrayList<CarteOrange> defausseOrange; //0..28
    private ArrayList<Joueur> joueurs; //2..4
    private Grille grille;
    
    public void Controleur() {
        
    }

    public int getNiveauEau() {
        return niveauEau;
    }
    
    public int eauAPiocher() {
        if (getNiveauEau() <= 2) {
            return 2;
        } else if (getNiveauEau() <= 5) {
            return 3;
        } else if (getNiveauEau() <= 7) {
            return 4;
        } else {
            return 5;
        }
    }
    
}
