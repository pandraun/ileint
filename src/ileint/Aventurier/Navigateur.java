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
public class Navigateur extends Aventurier {

    public Navigateur(String nom, Joueur joueur, Grille grille) {
        super(nom, joueur);
        super.setCouleur(Utils.Pion.JAUNE);

        for (Tuile tuile : grille.getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_d_Or) {
                setTuileDepart(tuile);
                tuile.getJoueursTuile().add(joueur);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Navigateur";
    }

    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g) {
        System.out.println("Rien n'est renvoyé");
        return null;

    }

    @Override
    public HashMap<Coordonnee, Tuile> getTuilesDeplacementCompagnon(Grille g, Tuile caseRef) {
        HashMap<Coordonnee, Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee, Tuile> casesTraitées = new HashMap<>();
        Coordonnee pos = caseRef.getCoordonnee();
        Coordonnee c1 = new Coordonnee(pos.getX(), pos.getY() - 2);
        Coordonnee c2 = new Coordonnee(pos.getX(), pos.getY() + 2);
        Coordonnee c3 = new Coordonnee(pos.getX() - 2, pos.getY());
        Coordonnee c4 = new Coordonnee(pos.getX() + 2, pos.getY());

        casesBruts = g.getCasesContourDeplacement(caseRef);

        for (Tuile tuile : g.getTuiles().values()) {
            if ((tuile.getCoordonnee().isPareil(c1) && tuile.getNom() != null)
               || (tuile.getCoordonnee().isPareil(c2) && tuile.getNom() != null)
               || (tuile.getCoordonnee().isPareil(c3) && tuile.getNom() != null)
               || (tuile.getCoordonnee().isPareil(c4) && tuile.getNom() != null)) {
                casesBruts.put(tuile.getCoordonnee(), tuile);
            }
        }
        
        casesTraitées = g.filtreTuilesAccessibles(casesBruts);

        return casesTraitées;
    }
}
