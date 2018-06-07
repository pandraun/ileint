package ileint.Aventurier;

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
public class Explorateur extends Aventurier {

    //Constructeur
    public Explorateur(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.VERT);

        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {                            
            if (tuile.getNom() == NomTuile.La_Porte_de_Cuivre) {
                setTuileDepart(tuile);
            }
        }

    }

    @Override
    public String getRoleAventurier() {
        return "Explorateur";
    }
    
    
    
    // seDeplacer() propre à l'explorateur
    @Override
    public void seDeplacer() {    // !! à faire :rendre la vision des cases accessibles avant de lancer se déplacer ou permettre annulation du déplacement si cases coviennent pas
        Scanner sc = new Scanner(System.in);
        Tuile sauv = null; // aura forcément une valeur après
        boolean saisieCorrecte;
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();

        System.out.println("==== Instructions pour amorcer un déplacement ====");
        System.out.println("Cases où le déplacement est possible :");

        casesBruts = joueur.getControleur().getGrille().getCasesContourDeplacement(joueur.getEmplacementJoueur());
        casesTraitées = joueur.getControleur().getGrille().getTuilesDeplacementPossible(casesBruts);
        
        for (Tuile uneTuile : casesTraitées.values()) { //affiche les cases accessibles
            System.out.println(uneTuile.getNom());
        }

        System.out.println("Saisir le nom (exact) de la case où se déplacer");
        String entree = sc.nextLine();

        for (Tuile uneTuile : casesTraitées.values()) { //cherche la correspondance entre l'entrée scanner et la tuile
            if (entree.equals(uneTuile.getNom().toString())) {
                sauv = uneTuile; // le code pense qu'il n'a pas tjrs une valeur mais il en aura tjrs une;
            }
        }

        saisieCorrecte = false;
        while (saisieCorrecte == false) {
            if (casesTraitées.containsValue(sauv)) {
                tuileDepart.getJoueursTuile().remove(joueur);       // retire le joueur dans la liste des joueurs de la tuile d'arrivée
                sauv.getJoueursTuile().add(joueur);     // ajoute le joueur dans la liste des joueurs de la tuile d'arrivée
                joueur.setEmplacementJoueur(sauv);   //affecte l'emplacement du joueur à la nouvelle tuile où il se trouve
                saisieCorrecte = true;
                System.out.println("Déplacement du " + joueur + " effectué " + tuileDepart.getNom() + " vers " + sauv.getNom() + ".");
            } else {
                System.out.println("Saisie incorrecte, veuillez recommencer la saisie");
                entree = sc.nextLine();
            }
        }
    }
    
    // assecherTuile() propre à l'explorateur
    @Override
    public void assecherTuile() {
        Scanner sc = new Scanner(System.in);
        Tuile sauv = null; // aura forcément une valeur après
        boolean saisieCorrecte;
        HashMap<Coordonnee,Tuile> casesBruts = new HashMap<>();
        HashMap<Coordonnee,Tuile> casesTraitées = new HashMap<>();

        System.out.println("==== Instructions pour assécher une tuile ====");
        System.out.println("Cases où l'assèchement est possible :");
        
        casesBruts = joueur.getControleur().getGrille().getCasesContourAssechement(joueur.getEmplacementJoueur());
        casesTraitées = joueur.getControleur().getGrille().filtreCasesInondees(casesBruts);

        for (Tuile uneTuile : casesTraitées.values()) { //affiche les cases assèchables
            System.out.println(uneTuile.getNom().toString());
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

}
