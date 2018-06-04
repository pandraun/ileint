package ileint.Carte;

import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public class Speciale extends CarteOrange {

    public Speciale(int emplacement) {
        super(emplacement);
    }
    
    public abstract String getTypeClasse();
    
    @Override
    public TypeTresor getTypeTresor(){
        return null;
    }
    
    
}
