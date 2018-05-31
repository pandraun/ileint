package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Plongeur extends Aventurier {
    
    public Plongeur(String nom, Joueur joueur) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.VIOLET);
    }
    
}
