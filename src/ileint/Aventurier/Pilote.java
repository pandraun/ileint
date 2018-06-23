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
public class Pilote extends Aventurier {

    public Pilote(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        setCouleur(Utils.Pion.BLEU);

        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.Heliport) {
                setTuileDepart(tuile);
                tuile.getJoueursTuile().add(joueur);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Pilote";
    }

    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g) {
        HashMap<Coordonnee, Tuile> tuilesAccessibles = new HashMap<>();
        
        tuilesAccessibles.putAll(g.getTuilesAssechees());
        tuilesAccessibles.putAll(g.getTuilesInondees());
        tuilesAccessibles.remove(joueur.getEmplacementJoueur());
        
        return tuilesAccessibles;
    }
    
    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementCompagnon(Grille g, Tuile caseRef) {
        System.out.println("T pa 1 navigo dsl");
        return null;
    }
}
