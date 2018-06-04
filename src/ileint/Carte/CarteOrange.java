package ileint.Carte;

/**
 *
 * @author fodorg
 */
public abstract class CarteOrange {
    private boolean piocheOrange;
    
    public CarteOrange(){
        this.setPioche(true);
    }
    
    public CarteOrange(boolean piocheOrange){
        this.setPioche(piocheOrange);
    }

    /**
     * @return the pile
     */
    public boolean isPioche() {
        return piocheOrange;
    }

    /**
     * @param piocheOrange the pile to set
     */
    public void setPioche(boolean piocheOrange) {
        this.piocheOrange = piocheOrange;
    }
}
