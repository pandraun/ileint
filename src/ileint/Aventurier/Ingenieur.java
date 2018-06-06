package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Ingenieur extends Aventurier {
    
    public Ingenieur(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.ROUGE);
        
        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Bronze) {
                setTuileDepart(tuile);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Ingénieur";
    }
    
}
