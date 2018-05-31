package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Ingenieur extends Aventurier {
    
    public Ingenieur(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.ROUGE);
    }
    
}
