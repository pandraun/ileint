package ileint.Grille;

import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import util.Utils.EtatTuile;
import ileint.Tuile.Coordonnee;

/**
 *
 * @author fodorg
 */
public class Grille {

    private ArrayList<Tuile> tuiles;
    private NomTuile libelle;

    public Grille(ArrayList<Tuile> tuiles, NomTuile libelle) {
        this.tuiles = new ArrayList<>();
        setLibelle(libelle);
    }
//    

    public ArrayList<Tuile> getTuilesAssechees() { // retourne toutes les cases sèches du plateau
        ArrayList<Tuile> tuilesAssechees = new ArrayList<>();
        for (Tuile uneTuile : tuiles) {
            if (uneTuile.getEtat() == EtatTuile.ASSECHEE) {
                tuilesAssechees.add(uneTuile);
            }
        }
        return tuilesAssechees;
    }

    public ArrayList<Tuile> getTuilesCoulees() { // retourne toutes les cases coulées du plateau
        ArrayList<Tuile> tuilesCoulees = new ArrayList<>();
        for (Tuile uneTuile : tuiles) {
            if (uneTuile.getEtat() == EtatTuile.COULEE) {
                tuilesCoulees.add(uneTuile);
            }
        }
        return tuilesCoulees;
    }

    public ArrayList<Tuile> getTuilesInondees() { // retourne toutes les cases inondées du plateau
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        for (Tuile uneTuile : tuiles) {
            if (uneTuile.getEtat() == EtatTuile.INONDEE) {
                tuilesInondees.add(uneTuile);
            }
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> getCasesCarreExclude(Tuile pos) { // retourne les 8 cases qui entourent la tuile (où le joueur se situe)
        ArrayList<Tuile> casesCarreExclude = new ArrayList<>();
        int x,y;
        
        for (Tuile uneTuile : tuiles) {
            Coordonnee sauv = new Coordonnee(pos.getCoordonnee().getX()+(-1),pos.getCoordonnee().getY()-1);
            if (uneTuile.getCoordonnee() == sauv) {
                casesCarreExclude.add(uneTuile);
            }

        }
        return casesCarreExclude;
    }

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
