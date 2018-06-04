package ileint.Carte;

import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public abstract class Speciale extends CarteOrange {

    public Speciale(int emplacement) {
        super(emplacement);
    }
    
    @Override
    public abstract String getTypeClasse();
    
    @Override
    public TypeTresor getTypeTresor(){
        return null;
    }
    
    
}
