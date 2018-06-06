package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
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
    protected Tuile tuileDepart;
    protected Joueur joueur;

    //Contructeur
    public Aventurier(String nom, Joueur joueur) {
        this.nom = nom;
        this.joueur = joueur;
    }

    public abstract String getRoleAventurier();

    public void seDeplacer() {    // !! à faire :rendre la vision des cases accessibles avant de lancer se déplacer ou permettre annulation du déplacement si cases coviennent pas
        Scanner sc = new Scanner(System.in);
        Tuile sauv = null; // aura forcément une valeur après
        boolean saisieCorrecte;
          
        System.out.println("==== Instructions pour amorcer un déplacement ====");
        System.out.println("Cases où le déplacement est possible :");

        for (Tuile uneTuile : joueur.getControleur().getGrille().getCasesLateralesDeplacement(joueur.getEmplacementJoueur()).values()) { //affiche les cases accessibles
            System.out.println(uneTuile.getNom());
        }

        System.out.println("Saisir le nom (exact) de la case où se déplacer");
        String entree = sc.nextLine();
        
        for (Tuile uneTuile : joueur.getControleur().getGrille().getCasesLateralesDeplacement(joueur.getEmplacementJoueur()).values()){ //cherche la correspondance entre l'entrée scanner et la tuile
            if (entree == uneTuile.getNom().toString()) {
                sauv = uneTuile; // le code pense qu'il n'a pas tjrs une valeur mais il en aura tjrs une;
            }
        }

        saisieCorrecte = false;
        while (saisieCorrecte == false) {
            if (joueur.getControleur().getGrille().getCasesLateralesDeplacement(joueur.getEmplacementJoueur()).containsValue(sauv)) {
                tuileDepart.getJoueursTuile().remove(joueur);       // retire le joueur dans la liste des joueurs de la tuile d'arrivée
                sauv.getJoueursTuile().add(joueur);     // ajoute le joueur dans la liste des joueurs de la tuile d'arrivée
                joueur.setEmplacementJoueur(sauv);   //affecte l'emplacement du joueur à la nouvelle tuile où il se trouve
                saisieCorrecte = true;
                System.out.println("Déplacement effectué de "+tuileDepart.getNom()+" vers "+sauv.getNom()+".");
            } else {
                System.out.println("Saisie incorrecte, veuillez recommencer la saisie");
            }
        }
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

    public void setTuileDepart(Tuile tuileDepart) {
        this.tuileDepart = tuileDepart;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

}
