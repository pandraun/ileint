package ileint.Carte;

import util.EmplacementCarte;
import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public class MontéeEau extends CarteOrange {
    
    public MontéeEau(EmplacementCarte emplacement) {
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
