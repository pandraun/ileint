package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Pilote extends Aventurier {
    
    public Pilote(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.BLEU);
    }
    
}
