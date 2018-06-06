package ileint.Controleur;

import ileint.Aventurier.Aventurier;
import ileint.Aventurier.Explorateur;
import ileint.Aventurier.Ingenieur;
import ileint.Aventurier.Messager;
import ileint.Aventurier.Navigateur;
import ileint.Aventurier.Pilote;
import ileint.Aventurier.Plongeur;
import ileint.Carte.CarteInondation;
import ileint.Carte.CarteOrange;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import java.util.Collections;
import util.TypeTresor;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Controleur {

    private int niveauEau;
    private ArrayList<CarteInondation> piocheInondation; // 0..24
    private ArrayList<CarteInondation> defausseInondation; // 0..24
    private ArrayList<CarteOrange> piocheOrange; //0..28
    private ArrayList<CarteOrange> defausseOrange; //0..28
    private ArrayList<Joueur> joueurs; //2..4
    private ArrayList<String> toutNomAventurier; 
    private ArrayList<Aventurier> aventuriers; // Il y en a 6 de base et on peut en retirer max 4
    private Grille grille;

    public Controleur() {

        toutNomAventurier.add("Explorateur");
        toutNomAventurier.add("Ingenieur");
        toutNomAventurier.add("Messager");
        toutNomAventurier.add("Navigateur");
        toutNomAventurier.add("Pilote");
        toutNomAventurier.add("Plongeur");

        
        for (Joueur unJoueur : joueurs) {
            
            Collections.shuffle(toutNomAventurier);
            
            switch(toutNomAventurier.get(1)) {
                case "Explorateur":
                    Explorateur explorateur = new Explorateur(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(explorateur);
                    
                case "Ingenieur":
                    Ingenieur ingenieur = new Ingenieur(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(ingenieur);
                    
                case "Messager":
                    Messager messager = new Messager(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(messager);
                    
                case "Navigateur":
                    Navigateur navigateur = new Navigateur(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(navigateur);
                    
                case "Pilote":
                    Pilote pilote = new Pilote(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(pilote);
                    
                case "Plongeur":
                    Plongeur plongeur = new Plongeur(toutNomAventurier.get(1),unJoueur);
                    aventuriers.add(plongeur);
            }
            
            toutNomAventurier.remove(toutNomAventurier.get(1));
            
        }

        Collections.shuffle(piocheInondation);
        Collections.shuffle(piocheOrange);

        //Initialisation des tuiles à la main
        Tuile t00 = new Tuile(null, new Coordonnee(0, 0), null);
        Tuile t01 = new Tuile(null, new Coordonnee(0, 1), null, null);
        Tuile t02 = new Tuile(NomTuile.Le_Pont_des_Abimes, new Coordonnee(0, 2), Utils.EtatTuile.ASSECHEE);
        Tuile t03 = new Tuile(NomTuile.La_Porte_de_Bronze, new Coordonnee(0, 3), Utils.EtatTuile.INONDEE);
        Tuile t04 = new Tuile(null, new Coordonnee(0, 4), null);
        Tuile t05 = new Tuile(null, new Coordonnee(0, 5), null);
        Tuile t10 = new Tuile(null, new Coordonnee(1, 0), null);
        Tuile t11 = new Tuile(NomTuile.La_Caverne_des_Ombres, new Coordonnee(1, 1), Utils.EtatTuile.ASSECHEE,TypeTresor.CRISTAL);
        Tuile t12 = new Tuile(NomTuile.La_Porte_de_Fer, new Coordonnee(1, 2), Utils.EtatTuile.ASSECHEE);
        Tuile t13 = new Tuile(NomTuile.La_Porte_d_Or, new Coordonnee(1, 3), Utils.EtatTuile.ASSECHEE);
        Tuile t14 = new Tuile(NomTuile.Les_Falaises_de_l_Oubli, new Coordonnee(1, 4),  Utils.EtatTuile.ASSECHEE);
        Tuile t15 = new Tuile(null, new Coordonnee(1, 5), null);
        Tuile t20 = new Tuile(NomTuile.Le_Palais_de_Corail, new Coordonnee(2, 0), Utils.EtatTuile.ASSECHEE,TypeTresor.CALICE);
        Tuile t21 = new Tuile(NomTuile.La_Porte_d_Argent, new Coordonnee(2, 1), Utils.EtatTuile.ASSECHEE);
        Tuile t22 = new Tuile(NomTuile.Les_Dunes_de_l_Illusion, new Coordonnee(2, 2), Utils.EtatTuile.COULEE);
        Tuile t23 = new Tuile(NomTuile.Heliport, new Coordonnee(2, 3), Utils.EtatTuile.ASSECHEE);
        Tuile t24 = new Tuile(NomTuile.La_Porte_de_Cuivre, new Coordonnee(2, 4), Utils.EtatTuile.ASSECHEE);
        Tuile t25 = new Tuile(NomTuile.Le_Jardin_des_Hurlements, new Coordonnee(2, 5), Utils.EtatTuile.ASSECHEE,TypeTresor.STATUE);
        Tuile t30 = new Tuile(NomTuile.La_Foret_Pourpre, new Coordonnee(3, 0), Utils.EtatTuile.ASSECHEE);
        Tuile t31 = new Tuile(NomTuile.Le_Lagon_Perdu, new Coordonnee(3, 1), Utils.EtatTuile.INONDEE);
        Tuile t32 = new Tuile(NomTuile.Le_Marais_Brumeux, new Coordonnee(3, 2), Utils.EtatTuile.COULEE);
        Tuile t33 = new Tuile(NomTuile.Observatoire, new Coordonnee(3, 3), Utils.EtatTuile.INONDEE);
        Tuile t34 = new Tuile(NomTuile.Le_Rocher_Fantome, new Coordonnee(3, 4),Utils.EtatTuile.COULEE);
        Tuile t35 = new Tuile(NomTuile.La_Caverne_du_Brasier, new Coordonnee(3, 5), Utils.EtatTuile.INONDEE,TypeTresor.CRISTAL);
        Tuile t40 = new Tuile(null, new Coordonnee(4, 0), null);
        Tuile t41 = new Tuile(NomTuile.Le_Temple_du_Soleil, new Coordonnee(4, 1), Utils.EtatTuile.ASSECHEE,TypeTresor.PIERRE);
        Tuile t42 = new Tuile(NomTuile.Le_Temple_de_La_Lune, new Coordonnee(4, 2), Utils.EtatTuile.COULEE,TypeTresor.PIERRE);
        Tuile t43 = new Tuile(NomTuile.Le_Palais_des_Marees, new Coordonnee(4, 3), Utils.EtatTuile.ASSECHEE,TypeTresor.CALICE);
        Tuile t44 = new Tuile(NomTuile.Le_Val_du_Crepuscule, new Coordonnee(4, 4), Utils.EtatTuile.ASSECHEE);
        Tuile t45 = new Tuile(null, new Coordonnee(4, 5), null);
        Tuile t50 = new Tuile(null, new Coordonnee(5, 0), null);
        Tuile t51 = new Tuile(null, new Coordonnee(5, 1), null);
        Tuile t52 = new Tuile(NomTuile.La_Tour_du_Guet, new Coordonnee(5, 2), Utils.EtatTuile.ASSECHEE);
        Tuile t53 = new Tuile(NomTuile.Le_Jardin_des_Murmures, new Coordonnee(5, 3), Utils.EtatTuile.INONDEE,TypeTresor.STATUE);
        Tuile t54 = new Tuile(null, new Coordonnee(5, 4), null);
        Tuile t55 = new Tuile(null, new Coordonnee(5, 5), null);
        
       

    }

    public int getNiveauEau() {
        return niveauEau;
    }

    public int eauAPiocher() {
        if (getNiveauEau() <= 2) {
            return 2;
        } else if (getNiveauEau() <= 5) {
            return 3;
        } else if (getNiveauEau() <= 7) {
            return 4;
        } else {
            return 5;
        }
    }

    
    //getters
    public ArrayList<CarteInondation> getPiocheInondation() {
        return piocheInondation;
    }

    public ArrayList<CarteInondation> getDefausseInondation() {
        return defausseInondation;
    }

    public ArrayList<CarteOrange> getPiocheOrange() {
        return piocheOrange;
    }

    public ArrayList<CarteOrange> getDefausseOrange() {
        return defausseOrange;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public Grille getGrille() {
        return grille;
    }
    
    

}
