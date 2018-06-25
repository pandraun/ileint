package ileint.Carte;

import util.EmplacementCarte;
import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public abstract class CarteOrange {
    private EmplacementCarte emplacement;
    
    public CarteOrange() {
        
    }
    
    public CarteOrange(EmplacementCarte emplacement){
        this.setEmplacementCarte(emplacement);
    }

    public abstract String getTypeClasse();
    public abstract TypeTresor getTypeTresor(); //permet de recuperer le type de tresor de la carte

    /**
     * @return the emplacement
     */
    public EmplacementCarte getEmplacementCarte() {
        return emplacement;
    }

    /**
     * @param emplacement the emplacement to set
     */
    public void setEmplacementCarte(EmplacementCarte emplacement) {
        this.emplacement = emplacement;
    }


}
