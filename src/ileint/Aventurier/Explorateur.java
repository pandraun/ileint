package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
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

        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Cuivre) {
                setTuileDepart(tuile);
            }
        }

    }

}
