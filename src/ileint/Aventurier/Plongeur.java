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
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Plongeur";
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementPossible(Grille g) { 
        HashMap<Coordonnee, Tuile> tuilesAVisiter = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesAccessibles = new HashMap<>();
        HashMap<Coordonnee, Tuile> tuilesEau = new HashMap<>();

        tuilesAVisiter = g.filtreTuilesAccessibles(g.getCasesLateralesDeplacement(joueur.getEmplacementJoueur()));
        
        while (tuilesAVisiter.size() > 0) {
            
            for (Tuile uneTuile : tuilesAVisiter.values()) {
                
                if (tuilesAVisiter.containsValue(uneTuile.getEtat() == Utils.EtatTuile.INONDEE)) {   // si tuile inondée trouvée -> on l'ajoute
                    tuilesEau.put(uneTuile.getCoordonnee(), uneTuile);
                    tuilesAccessibles.put(uneTuile.getCoordonnee(), uneTuile);
                    
                } else if (tuilesAVisiter.containsValue(uneTuile.getEtat() == Utils.EtatTuile.ASSECHEE)) {
                    tuilesAccessibles.put(uneTuile.getCoordonnee(), uneTuile);
                    
                } else if (tuilesAVisiter.containsValue(uneTuile.getEtat() == Utils.EtatTuile.COULEE)){
                    tuilesEau.put(uneTuile.getCoordonnee(), uneTuile);
                }
                
                tuilesAVisiter = tuilesEau;
            }
            for (Tuile uneTuile : tuilesAVisiter.values()) {
                tuilesAVisiter.putAll(g.filtreTuilesAccessibles(g.getCasesLateralesDeplacement(uneTuile)));
            }
        }
        return tuilesAccessibles;
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g) {
        System.out.println("Rien n'est renvoyé");
        return null;
    }
}
