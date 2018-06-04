package ileint.Carte;

/**
 *
 * @author fodorg
 */
public abstract class CarteOrange {
    private boolean pileOrange;
    
    public CarteOrange(boolean pileOrange){
        this.setPile(pileOrange);
    }

    /**
     * @return the pile
     */
    public boolean isPile() {
        return pileOrange;
    }

    /**
     * @param pile the pile to set
     */
    public void setPile(boolean pileOrange) {
        this.pileOrange = pileOrange;
    }
}
