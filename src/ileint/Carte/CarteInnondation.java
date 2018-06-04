package ileint.Carte;

import ileint.Tuile.Tuile;

/**
 *
 * @author fodorg
 */
public class CarteInnondation {
    private Tuile tuile;
    private boolean piocheInnodation; //permet de déterminer si la carte est dans la pile ou dans la defausse
    
    public CarteInnondation(){
        this.setPioche(true);
    }
    
    public CarteInnondation(Tuile tuile, boolean piocheInnodation){
        this.setTuile(tuile);
        this.setPioche(piocheInnodation);
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
     * @return the pileInnodation
     */
    public boolean isPioche() {
        return piocheInnodation;
    }

    /**
     * @param piocheInnodation the pile to set
     */
    public void setPioche(boolean piocheInnodation) {
        this.piocheInnodation = piocheInnodation;
    }
    

  
}
