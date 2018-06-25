package ileint.Aventurier;

import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.HashMap;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Plongeur extends Aventurier {
    
    public Plongeur(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.VIOLET);
        
        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Fer) {
                setTuileDepart(tuile);
                tuile.getJoueursTuile().add(joueur);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Plongeur";
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementPossible(Grille g) { 
        HashMap<Coordonnee, Tuile> tuilesPassage = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesAccessible = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesArret = new HashMap<>();
        int nbTuileVerif = 100;
        
        tuilesAccessible = g.getCasesLateralesDeplacement(joueur.getEmplacementJoueur());
        
        do {
        
        for (Tuile uneTuile : tuilesAccessible.values()) {
            switch (uneTuile.getEtat()) {
                    case INONDEE:
                        // si tuile inondée trouvée -> on l'ajoute
                        tuilesPassage.put(uneTuile.getCoordonnee(), uneTuile);
                        tuilesArret.put(uneTuile.getCoordonnee(), uneTuile);
                        break;
                    case COULEE:
                        tuilesPassage.put(uneTuile.getCoordonnee(), uneTuile);
                        break;
                    default:
                        tuilesArret.put(uneTuile.getCoordonnee(), uneTuile);
                        nbTuileVerif--;
                        break;
                }
            }
        
        for (Tuile uneTuile : tuilesPassage.values()) {
            tuilesAccessible.putAll(g.getCasesLateralesDeplacement(uneTuile));
        }
            
        }while (nbTuileVerif > 0);
        
        //tuilesArret.remove(joueur.getEmplacementJoueur());
        HashMap<Coordonnee, Tuile> tuileSauv = new HashMap<>();
        for (Tuile tuile : tuilesArret.values()) {
            if (!tuile.equals(joueur.getEmplacementJoueur())) {
                tuileSauv.put(tuile.getCoordonnee(), tuile);
            }
        }
        return tuileSauv;
        
        
        

    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g) {
        System.out.println("Rien n'est renvoyé");
        return null;
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementCompagnon(Grille g, Tuile caseRef) {
        System.out.println("T pa 1 navigo dsl");
        return null;
    }
}
