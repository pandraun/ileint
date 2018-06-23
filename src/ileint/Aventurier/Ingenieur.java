package ileint.Aventurier;

import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.HashMap;
import java.util.Scanner;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Ingenieur extends Aventurier {

    public Ingenieur(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        setCouleur(Utils.Pion.ROUGE);

        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Bronze) {
                setTuileDepart(tuile);
                tuile.getJoueursTuile().add(joueur);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Ingénieur";
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
