package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Messager extends Aventurier {
    
    public Messager(String nom, Joueur joueur) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.ORANGE);
    }
    
}
