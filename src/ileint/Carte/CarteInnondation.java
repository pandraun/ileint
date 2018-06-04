package ileint.Carte;

import ileint.Tuile.Tuile;

/**
 *
 * @author fodorg
 */
public class CarteInnondation {
    private Tuile tuile;
    private boolean pile; //permet de déterminer si la carte est dans la pile ou dans la defausse
    
    public CarteInnondation(Tuile tuile, boolean pile){
        this.setTuile(tuile);
        this.setPile(pile);
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

    /**
     * @return the pile
     */
    public boolean isPile() {
        return pile;
    }

    /**
     * @param pile the pile to set
     */
    public void setPile(boolean pile) {
        this.pile = pile;
    }
    

  
}
