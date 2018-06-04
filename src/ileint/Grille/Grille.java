package ileint.Grille;

import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import util.Utils.EtatTuile;

/**
 *
 * @author fodorg
 */
public class Grille {
    private ArrayList<Tuile> tuiles;
    private NomTuile libelle;
    
    public Grille (ArrayList<Tuile> tuiles, NomTuile libelle) {
        this.tuiles = new ArrayList<>();
        setLibelle(libelle);
    }
//    
    
        
    
    
    
    //-------------------------------- GETTERS SETTERS --------------------------------------------
    
    /**
     * @return the tuiles
     */
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }

    /**
     * @param tuiles the tuiles to set
     */
    public void setTuiles(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }

    /**
     * @return the libelle
     */
    public NomTuile getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(NomTuile libelle) {
        this.libelle = libelle;
    }
}
