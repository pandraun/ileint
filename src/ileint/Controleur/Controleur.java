package ileint.Controleur;

import ileint.Aventurier.Aventurier;
import ileint.Carte.CarteInnondation;
import ileint.Carte.CarteOrange;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
    private ArrayList<Aventurier> aventuriers; // Il y en a 6 de base et on peut en retirer max 4
    private Grille grille;

    private int indiceRole;

    public Controleur() {

        for (Joueur unjoueur : joueurs) {

            Collections.shuffle(aventuriers);
            unjoueur.setRole(aventuriers.get(1));
            aventuriers.remove(aventuriers.get(1));
        }
        
        Collections.shuffle(piocheInnondation);
        Collections.shuffle(piocheOrange);
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
