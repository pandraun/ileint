package ileint.Carte;

import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public abstract class CarteOrange {
    private int emplacement;
    
    public CarteOrange(int emplacement){
        this.setEmplacement(emplacement);
    }

    public abstract String getTypeClasse();
    public abstract TypeTresor getTypeTresor(); //permet de recuperer le type de tresor de la carte

    /**
     * @return the emplacement
     */
    public int getEmplacement() {
        return emplacement;
    }

    /**
     * @param emplacement the emplacement to set
     */
    public void setEmplacement(int emplacement) {
        
    }


}
