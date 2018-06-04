package ileint.Carte;

import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public class MontéeEau extends CarteOrange {
    
    public MontéeEau(int emplacement) {
        super(emplacement);
    }
    
    @Override
    public TypeTresor getTypeTresor(){
        return null;
    }
    
    @Override
    public String getTypeClasse(){
        return "MontéeEau";
    }
}
