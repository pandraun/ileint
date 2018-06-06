package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Messager extends Aventurier {
    
    public Messager(String nom, Joueur joueur) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.ORANGE);
        
        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_d_Argent) {
                setTuileDepart(tuile);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Messager";
    }
    
}
