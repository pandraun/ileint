package ileint.Carte;

import util.EmplacementCarte;

/**
 *
 * @author fodorg
 */
public class Helicoptere extends Speciale {

    public Helicoptere(EmplacementCarte emplacement) {
        super(emplacement);
    }
    
    
    @Override
    public String getTypeClasse(){
        return "Helicoptere";
    }
}
