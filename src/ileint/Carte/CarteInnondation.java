package ileint.Carte;

import ileint.Tuile.Tuile;

/**
 *
 * @author fodorg
 */
public class CarteInnondation {

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the tuile
     */
    public Tuile getTuile() {
        return tuile;
    }

    /**
     * @param tuile the tuile to set
     */
    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
    }
    private String nom;
    private Tuile tuile;
    
}
