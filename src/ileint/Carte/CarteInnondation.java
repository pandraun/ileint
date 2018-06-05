package ileint.Carte;

import ileint.Tuile.Tuile;

/**
 *
 * @author fodorg
 */
public class CarteInnondation {
    private Tuile tuile;
    private boolean Innodationpioche; //permet de déterminer si la carte est dans la pile ou dans la defausse
    
    public CarteInnondation(){
        this.setPioche(true);
    }
    
    public CarteInnondation(Tuile tuile, boolean Innodationpioche){
        this.setTuile(tuile);
        this.setPioche(Innodationpioche);
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
        return Innodationpioche;
    }

    /**
     * @param piocheInnodation the pile to set
     */
    public void setPioche(boolean piocheInnodation) {
        this.Innodationpioche = piocheInnodation;
    }
    

  
}
