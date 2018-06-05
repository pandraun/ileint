package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Plongeur extends Aventurier {
    
    public Plongeur(String nom, Joueur joueur) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.VIOLET);
        
        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Fer) {
                setTuileDepart(tuile);
            }
        }
    }
    
}
