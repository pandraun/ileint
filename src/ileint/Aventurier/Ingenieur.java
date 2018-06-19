package ileint.Aventurier;

import ileint.Joueur.Joueur;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.Scanner;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Ingenieur extends Aventurier {
    
    public Ingenieur(String nom, Joueur joueur) {
        super(nom, joueur);
        setCouleur(Utils.Pion.ROUGE);

        for (Tuile tuile : joueur.getControleur().getGrille().getTuiles().values()) {
            if (tuile.getNom() == NomTuile.La_Porte_de_Bronze) {
                setTuileDepart(tuile);
            }
        }
    }

    @Override
    public String getRoleAventurier() {
        return "Ingénieur";
    }
    
    @Override
    public void assecherTuile() {
        super.assecherTuile();
        
        Scanner sc = new Scanner(System.in);
        boolean choix;
        System.out.println("Voulez-vous vous assecher une deuxième fois ?");
        System.out.println("/Oui");
        System.out.println("/Non");
        String entree = sc.nextLine();
        if (entree.equals("Oui")) {
            super.assecherTuile();
        }
    }
    
    @Override
    public void seDeplacerSpe() {
        System.out.println("Et là, c'est le bug");
    }
}

    
