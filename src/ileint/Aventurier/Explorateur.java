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
public class Explorateur extends Aventurier {

    //Constructeur
    public Explorateur(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        setCouleur(Utils.Pion.VERT);

        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Cuivre) {
                setTuileDepart(tuile);
                tuile.getJoueursTuile().add(joueur);
            }
        }

    }

    @Override
    public String getRoleAventurier() {
        return "Explorateur";
    }

    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementPossible(Grille g) {
        HashMap<Coordonnee, Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee, Tuile> casesTraitées = new HashMap<>();

        casesBruts = g.getCasesContourDeplacement(joueur.getEmplacementJoueur());
        casesTraitées = g.filtreTuilesAccessibles(casesBruts);

        return casesTraitées;
    }

    @Override
    public HashMap<Coordonnee, Tuile> getTuilesAssechables(Grille g) {
        HashMap<Coordonnee, Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee, Tuile> casesTraitées = new HashMap<>();

        casesBruts = g.getCasesContourDeplacement(joueur.getEmplacementJoueur());
        casesTraitées = g.filtreCasesInondees(casesBruts);

        return casesTraitées;
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
