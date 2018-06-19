package ileint.Aventurier;

import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.HashMap;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Navigateur extends Aventurier {
    
    public Navigateur(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.JAUNE);

        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_d_Or) {
                setTuileDepart(tuile);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Navigateur";
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g) {
        System.out.println("Rien n'est renvoyé");
        return null;
        
    }
}
