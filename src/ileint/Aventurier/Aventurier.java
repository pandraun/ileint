package ileint.Aventurier;

import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.HashMap;
import java.util.Scanner;
import util.Utils;
import util.Utils.Pion;

/**
 *
 * @author fodorg
 */
public abstract class Aventurier {

    private String nom;
    private Pion couleur;
    protected Tuile tuileDepart;
    protected Joueur joueur;

    //Contructeur
    public Aventurier(String nom, Joueur joueur) {
        this.nom = nom;
        this.joueur = joueur;
    }

    public abstract String getRoleAventurier();

    public HashMap<Coordonnee,Tuile> getTuilesDeplacementPossible(Grille g) {    // !! à faire :rendre la vision des cases accessibles avant de lancer se déplacer ou permettre annulation du déplacement si cases coviennent pas
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();
        
        casesBruts = g.getCasesLateralesDeplacement(joueur.getEmplacementJoueur());
        casesTraitées = g.filtreTuilesAccessibles(casesBruts);
        
        return casesTraitées;
    }

    public HashMap<Coordonnee,Tuile> getTuilesAssechables(Grille g) {
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();

        casesBruts = g.getCasesLateralesAssechement(joueur.getEmplacementJoueur());
        casesTraitées = g.filtreCasesInondees(casesBruts);
        
        return casesTraitées;
    }
    
    public abstract HashMap<Coordonnee, Tuile> getTuilesDeplacementSpe(Grille g);

    //Getters
    public String getNom() {
        return nom;
    }

    public Pion getCouleur() {
        return couleur;
    }

    public Tuile getTuileDepart() {
        return tuileDepart;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCouleur(Pion couleur) {
        this.couleur = couleur;
    }

    public void setTuileDepart(Tuile tuileDepart) {
        this.tuileDepart = tuileDepart;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

}
