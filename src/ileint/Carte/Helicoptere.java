package ileint.Carte;

/**
 *
 * @author fodorg
 */
public class Helicoptere extends Speciale {

    public Helicoptere(int emplacement) {
        super(emplacement);
    }
    
    
    @Override
    public String getTypeClasse(){
        return "Helicoptere";
    }
}
