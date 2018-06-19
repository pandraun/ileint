package ileint.Grille;

import ileint.Tuile.Tuile;
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
        this.tuiles = tuiles;
    }
//    

    public HashMap<Coordonnee, Tuile> getTuilesAssechees() { // retourne toutes les cases sèches du plateau
        return filtreCasesSeches(tuiles);
    }

    public HashMap<Coordonnee, Tuile> getTuilesCoulees() { // retourne toutes les cases coulées du plateau
        return filtreCasesCoulees(tuiles);
    }

    public HashMap<Coordonnee, Tuile> getTuilesInondees() { // retourne toutes les cases inondées du plateau
        return filtreCasesInondees(tuiles);
    }

    public HashMap<Coordonnee, Tuile> getTuilesAccessiblesPilote() { // retourne toutes les cases accessibles du plateau (inondées + sèches) + en principe y'a pas de null dedans
        HashMap<Coordonnee, Tuile> tuilesAccessibles = new HashMap<>();
        tuilesAccessibles.putAll(getTuilesAssechees());
        tuilesAccessibles.putAll(getTuilesInondees());
        return tuilesAccessibles;    // utile pilote et peut etre plongeur
    }

    public HashMap<Coordonnee, Tuile> getTuilesAccessiblesPlongeur(Tuile pos) { //si ça marche appelez moi Jesus
        HashMap<Coordonnee, Tuile> tuilesAVisiter = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesAccessibles = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesEau = new HashMap<>();

        tuilesAVisiter = getTuilesDeplacementPossible(getCasesLateralesDeplacement(pos));
        while (tuilesAVisiter.size() > 0) {
            for (Tuile uneTuile : tuilesAVisiter.values()) {
                if (tuilesAVisiter.containsValue(uneTuile.getEtat() == EtatTuile.INONDEE)) {   // si tuile inondée trouvée -> on l'ajoute
                    tuilesEau.put(uneTuile.getCoordonnee(), uneTuile);
                    tuilesAccessibles.put(uneTuile.getCoordonnee(), uneTuile);
                } else if (tuilesAVisiter.containsValue(uneTuile.getEtat() == EtatTuile.ASSECHEE)) {
                    tuilesAccessibles.put(uneTuile.getCoordonnee(), uneTuile);
                } else if (tuilesAVisiter.containsValue(uneTuile.getEtat() == EtatTuile.COULEE)){
                    tuilesEau.put(uneTuile.getCoordonnee(), uneTuile);
                }
                
                tuilesAVisiter = tuilesEau;
            }
            for (Tuile uneTuile : tuilesAVisiter.values()) {
                tuilesAVisiter.putAll(getTuilesDeplacementPossible(getCasesLateralesDeplacement(uneTuile)));
            }
        }
        return tuilesAccessibles;
    }

    public HashMap<Coordonnee, Tuile> getTuilesDeplacementPossible(HashMap<Coordonnee, Tuile> listeCasesAlentours) { // retourne une liste en ne gardant que celles où on peut se déplacer (pas coulées ni null)
        HashMap<Coordonnee, Tuile> tuilesAccessibles = new HashMap<>();
        tuilesAccessibles.putAll(filtreCasesInondees(listeCasesAlentours));
        tuilesAccessibles.putAll(filtreCasesSeches(listeCasesAlentours));
        return tuilesAccessibles;
    }

    //__________________________________________
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //            | X +   + X |
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //     getCasesContourDeplacement(Tuile pos) => cases cochées récupérées
    public HashMap<Coordonnee, Tuile> getCasesContourDeplacement(Tuile pos) { // retourne les 8 cases qui entourent la tuile (où le joueur se situe) sans l'inclure + null traité
        HashMap<Coordonnee, Tuile> casesCarreExclude = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; j++) {                                        // colonne
                if (i == 0 && j == 0) {                                         // ne prendra pas la case sur lequel l'aventurier se trouve
                    //rien
                } else {
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    /*if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                        casesCarreExclude.put(sauv, getTuiles().get(sauv));
                    }*/
                    for (Tuile tuile : getTuiles().values()) {
                        if (tuile.getCoordonnee().isPareil(sauv) && tuile.getNom() != null) { //tuile.getCoordonnee().equals(sauv)
                            casesCarreExclude.put(sauv, tuile);
                        }
                    }
                }
            }
        }
        return casesCarreExclude;
    }

    //__________________________________________
    //            +---+---+---+
    //            |   + X +   |
    //            +---+---+---+
    //            | X +   + X |
    //            +---+---+---+
    //            |   + X +   |
    //            +---+---+---+
    //     getCasesLateralesDeplacement(Tuile pos) => cases cochées récupérées
    public HashMap<Coordonnee, Tuile> getCasesLateralesDeplacement(Tuile pos) { // retourne les 4 cases qui entourent la tuile (où le joueur se situe) sans l'inclure + null traité
        HashMap<Coordonnee, Tuile> casesCroixExclude = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; j++) {                                        // colonne
                if ((i == -1 && j == -1)
                        || (i == 1 && j == 1)
                        || (i == -1 && j == 1)
                        || (i == 1 && j == -1)
                        || (i == 0 && j == 0)) {
                    //prend les cas où c'est pas accessible
                } else {// ne prendra pas la case sur lequel l'aventurier se trouve
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    /*if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp  
                        System.out.println("debug");
                        casesCroixExclude.put(sauv, getTuiles().get(sauv));
                    }*/
                    for (Tuile tuile : getTuiles().values()) {
                        if (tuile.getCoordonnee().isPareil(sauv) && tuile.getNom() != null) { //tuile.getCoordonnee().equals(sauv)
                            casesCroixExclude.put(sauv, tuile);
                        }
                    }
                }

            }
        }
        return casesCroixExclude;
    }

    //__________________________________________
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //     getCasesContourAssechement(Tuile pos) => cases cochées récupérées
    public HashMap<Coordonnee, Tuile> getCasesContourAssechement(Tuile pos) { // retourne les 9 cases qui entourent la tuile (où le joueur se situe) incluse + null traité
        HashMap<Coordonnee, Tuile> casesCarre = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; j++) {                                        // colonne
                sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                /*if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                    casesCarre.put(sauv, getTuiles().get(sauv));
                }*/
                
                for (Tuile tuile : getTuiles().values()) {
                        if (tuile.getCoordonnee().isPareil(sauv) && tuile.getNom() != null) { //tuile.getCoordonnee().equals(sauv)
                            casesCarre.put(sauv, tuile);
                        }
                    }
            }
        }
        return casesCarre;
    }

    //__________________________________________
    //            +---+---+---+
    //            |   + X +   |
    //            +---+---+---+
    //            | X + X + X |
    //            +---+---+---+
    //            |   + X +   |
    //            +---+---+---+
    //     getCasesLateralesAssechement(Tuile pos) => cases cochées récupérées
    public HashMap<Coordonnee, Tuile> getCasesLateralesAssechement(Tuile pos) { // retourne les 4 cases qui entourent la tuile (où le joueur se situe) incluse + null traité
        HashMap<Coordonnee, Tuile> casesCroix = new HashMap<>();
        Coordonnee sauv;

        for (int i = -1; i < 2; i++) {                                            // ligne
            for (int j = -1; j < 2; j++) {                                        // colonne
                if ((i == -1 && j == -1)
                        || (i == 1 && j == 1)
                        || (i == -1 && j == 1)
                        || (i == 1 && j == -1)) {
                    // rien ne se passe
                } else {
                    sauv = new Coordonnee(pos.getCoordonnee().getX() + i, pos.getCoordonnee().getY() + j);
                    /*if (getTuiles().get(sauv) != null) {                       //si c'est pas un bord ou jsp
                        casesCroix.put(sauv, getTuiles().get(sauv));
                    }*/
                    for (Tuile tuile : getTuiles().values()) {
                        if (tuile.getCoordonnee().isPareil(sauv) && tuile.getNom() != null) { //tuile.getCoordonnee().equals(sauv)
                            casesCroix.put(sauv, tuile);
                        }
                    }
                }
            }
        }
        return casesCroix;
    }

    public HashMap<Coordonnee, Tuile> filtreCasesSeches(HashMap<Coordonnee, Tuile> casesBruts) { // récupère une liste et la retourne en gardant seulement les cases sèches (byebye null et autres)
        HashMap<Coordonnee, Tuile> casesTraitee = new HashMap<>();
        for (Tuile uneTuile : casesBruts.values()) {
            if (uneTuile.getEtat() == EtatTuile.ASSECHEE) {
                casesTraitee.put(uneTuile.getCoordonnee(),uneTuile);
            }
        }
        return casesTraitee;
    }

    public HashMap<Coordonnee, Tuile> filtreCasesInondees(HashMap<Coordonnee, Tuile> casesBruts) { // retourne liste en gardant seulement les cases inondées (byebye null et autres)
        HashMap<Coordonnee, Tuile> casesTraitee = new HashMap<>();
        for (Tuile uneTuile : casesBruts.values()) {
            if (uneTuile.getEtat() == EtatTuile.INONDEE) {
                casesTraitee.put(uneTuile.getCoordonnee(),uneTuile);
            }
        }
        return casesTraitee;
    }

    public HashMap<Coordonnee, Tuile> filtreCasesCoulees(HashMap<Coordonnee, Tuile> casesBruts) { // retourne liste en gardant seulement les cases inondées (byebye null et autres)
        HashMap<Coordonnee, Tuile> casesTraitee = new HashMap<>();
        for (Tuile uneTuile : casesBruts.values()) {
            if (uneTuile.getEtat() == EtatTuile.COULEE) {
                casesTraitee.put(uneTuile.getCoordonnee(),uneTuile);
            }
        }
        return casesTraitee;
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
