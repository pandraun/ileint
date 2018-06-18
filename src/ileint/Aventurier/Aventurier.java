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

    public Tuile getTuilesDeplacementPossible(Grille g) {    // !! à faire :rendre la vision des cases accessibles avant de lancer se déplacer ou permettre annulation du déplacement si cases coviennent pas
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();
        
        casesBruts = g.getCasesLateralesDeplacement(joueur.getEmplacementJoueur());
        casesTraitées = g.getTuilesDeplacementPossible(casesBruts);
        
        return
    }

    public void assecherTuile() {
        Scanner sc = new Scanner(System.in);
        Tuile sauv = null; // aura forcément une valeur après
        boolean saisieCorrecte;
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();

        System.out.println("==== Instructions pour assécher une tuile ====");
        System.out.println("Cases où l'assèchement est possible :");
        
        casesBruts = joueur.getControleur().getGrille().getCasesLateralesAssechement(joueur.getEmplacementJoueur());
        casesTraitées = joueur.getControleur().getGrille().filtreCasesInondees(casesBruts);
        
        for (Tuile uneTuile : casesTraitées.values()) { //affiche les cases assèchables
            System.out.println("/"+uneTuile.getNom().toString());
        }

        System.out.println("Saisir le nom (exact) de la case à assécher");
        String entree = sc.nextLine();

        for (Tuile uneTuile : casesTraitées.values()) { //cherche la correspondance entre l'entrée scanner et la tuile
            if (entree.equals(uneTuile.getNom().toString())) {
                sauv = uneTuile; // le code pense qu'il n'a pas tjrs une valeur mais il en aura tjrs une;
            }

            saisieCorrecte = false;
            while (saisieCorrecte == false) {
                if (casesTraitées.containsValue(sauv)) {
                    sauv.setEtat(Utils.EtatTuile.ASSECHEE);
                    saisieCorrecte = true;
                    System.out.println("Assèchement du " + joueur.getRole().getNom() + " effectué sur la tuile " + sauv.getNom().toString() + ".");
                } else {
                    System.out.println("Saisie incorrecte, veuillez recommencer la saisie");
                    entree = sc.nextLine();
                }
            }
        }
    }
    
    public abstract void seDeplacerSpe();
    
    

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
