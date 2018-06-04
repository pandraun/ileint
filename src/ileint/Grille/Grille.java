package ileint.Grille;

import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import util.Utils.EtatTuile;
import ileint.Tuile.Coordonnee;
import java.util.HashMap;

/**
 *
 * @author fodorg
 */
public class Grille {

    private HashMap<Coordonnee, Tuile> tuiles;

    public Grille(HashMap<Coordonnee, Tuile> tuiles) {
        this.tuiles = new HashMap<>();

    }
//    

    public ArrayList<Tuile> getTuilesAssechees() { // retourne toutes les cases sèches du plateau
        ArrayList<Tuile> tuilesAssechees = new ArrayList<>();
        for (Tuile uneTuile : getTuiles().values()) {
            if (uneTuile.getEtat() == EtatTuile.ASSECHEE) {
                tuilesAssechees.add(uneTuile);
            }
        }
        return tuilesAssechees;
    }

    public ArrayList<Tuile> getTuilesCoulees() { // retourne toutes les cases coulées du plateau
        ArrayList<Tuile> tuilesCoulees = new ArrayList<>();
        for (Tuile uneTuile : getTuiles().values()) {
            if (uneTuile.getEtat() == EtatTuile.COULEE) {
                tuilesCoulees.add(uneTuile);
            }
        }
        return tuilesCoulees;
    }

    public ArrayList<Tuile> getTuilesInondees() { // retourne toutes les cases inondées du plateau
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        for (Tuile uneTuile : getTuiles().values()) {
            if (uneTuile.getEtat() == EtatTuile.INONDEE) {
                tuilesInondees.add(uneTuile);
            }
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> getTuilesAccessibles() { // retourne toutes les cases accessibles du plateau (inondées + sèches) + en principe y'a pas de null dedans
        ArrayList<Tuile> tuilesAccessibles = new ArrayList<>();
        tuilesAccessibles.addAll(getTuilesAssechees());
        tuilesAccessibles.addAll(getTuilesInondees());
        return tuilesAccessibles;
    }

    public HashMap<Coordonnee, Tuile> getCasesCarreExclude(Tuile pos) { // retourne les 8 cases qui entourent la tuile (où le joueur se situe) + null traité
        HashMap<Coordonnee, Tuile> casesCarreExclude = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; i++) {                                        // colonne
                if (i != 0 && j != 0) {                                         // ne prendra pas la case sur lequel l'aventurier se trouve
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                        casesCarreExclude.put(sauv, getTuiles().get(sauv));
                    }
                }
            }
        }
        return casesCarreExclude;
    }

    public HashMap<Coordonnee, Tuile> getCasesCroixExclude(Tuile pos) { // retourne les 4 cases qui entourent la tuile (où le joueur se situe) + null traité
        HashMap<Coordonnee, Tuile> casesCroixExclude = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; i++) {                                        // colonne
                if ((i != -1 && j != -1)
                        || (i != 1 && j != 1)
                        || (i != -1 && j != 1)
                        || (i != 1 && j != -1)
                        || (i != 0 && j != 0)) {                                       // ne prendra pas la case sur lequel l'aventurier se trouve
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                        casesCroixExclude.put(sauv, getTuiles().get(sauv));
                    }
                }

            }
        }
        return casesCroixExclude;
    }

    public HashMap<Coordonnee, Tuile> getCasesCarre(Tuile pos) { // retourne les 9 cases qui entourent la tuile (où le joueur se situe) incluse + null traité
        HashMap<Coordonnee, Tuile> casesCarre = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; i++) {                                        // colonne
                sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                    casesCarre.put(sauv, getTuiles().get(sauv));
                }
            }
        }
        return casesCarre;
    }

    public HashMap<Coordonnee, Tuile> getCasesCroix(Tuile pos) { // retourne les 4 cases qui entourent la tuile (où le joueur se situe) incluse + null traité
        HashMap<Coordonnee, Tuile> casesCroix = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; i++) {                                        // colonne
                if ((i != -1 && j != -1)
                        || (i != 1 && j != 1)
                        || (i != -1 && j != 1)
                        || (i != 1 && j != -1)) {
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                        casesCroix.put(sauv, getTuiles().get(sauv));
                    }
                }
            }
        }
        return casesCroix;
    }

    //-------------------------------- GETTERS SETTERS --------------------------------------------
    /**
     * @return the tuiles
     */
    public HashMap<Coordonnee, Tuile> getTuiles() {
        return tuiles;
    }

    /**
     * @param tuiles the tuiles to set
     */
    public void setTuiles(HashMap<Coordonnee, Tuile> tuiles) {
        this.tuiles = tuiles;
    }

}
