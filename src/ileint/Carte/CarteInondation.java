package ileint.Carte;

import ileint.Tuile.Tuile;

/**
 *
 * @author fodorg
 */
public class CarteInondation {
    private Tuile tuile;
    private boolean inondationPioche; //permet de déterminer si la carte est dans la pile ou dans la defausse
    
    public CarteInondation(){
        this.setPioche(true);
    }
    
    public CarteInondation(Tuile tuile, boolean inondationPioche){
        this.setTuile(tuile);
        this.setPioche(inondationPioche);
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
        return inondationPioche;
    }

    /**
     * @param Inondationpioche the pile to set
     */
    public void setPioche(boolean Inondationpioche) {
        this.inondationPioche = Inondationpioche;
    }
    

  
}
