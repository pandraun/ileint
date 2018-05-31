package ileint.Aventurier;

import ileint.Joueur.Joueur;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Explorateur extends Aventurier {
    
    //Constructeur
    public Explorateur(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.VERT);
    }
    
}
