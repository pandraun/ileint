package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Navigateur extends Aventurier {
    
    public Navigateur(String nom, Joueur joueur) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.JAUNE);
    }
    
}
