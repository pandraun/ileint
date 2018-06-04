package ileint.Carte;

import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public class Tresor extends CarteOrange {
    protected TypeTresor type;

    
    @Override
    public TypeTresor getTypeTresor(){ //Recupere le type du tresor
        return type;
    }
        

    /**
     * @return the type
     */
    public TypeTresor getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeTresor type) {
        this.type = type;
    }
    
    
}
