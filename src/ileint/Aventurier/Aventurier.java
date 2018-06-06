package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.Tuile;
import java.util.Scanner;
import util.Utils.Pion;

/**
 *
 * @author fodorg
 */
public abstract class Aventurier {

    private String nom;
    private Pion couleur;
    private Tuile tuileDepart;
    private Joueur joueur;
    
    //Contructeur
    public Aventurier(String nom, Joueur joueur) {
        this.nom = nom;
        this.joueur = joueur;
    }

    
    public abstract String getRoleAventurier();
    
    public void seDeplacer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Instructions pour amorcer un déplacement ====");
        System.out.println("Cases où le déplacement est possible :");
        
        for (Tuile uneTuile : joueur.getControleur().getGrille().getCasesLateralesDeplacement(joueur.getEmplacementJoueur()).values()) {
            System.out.println(uneTuile.getNom());
        }
        
        System.out.println("Saisir le nom (exact) de la case où se déplacer");

    }
    
    
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

   public void setTuileDepart (Tuile tuileDepart) {
        this.tuileDepart = tuileDepart;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

}
