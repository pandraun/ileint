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
import ileint.Carte.Helicoptere;
import ileint.Carte.MontéeEau;
import ileint.Carte.SacDeSable;
import ileint.Carte.Tresor;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import util.EmplacementCarte;
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
    private boolean partieTermine;
    private Joueur joueurCourant;

    public Controleur() {

        toutNomAventurier.add("Explorateur");
        toutNomAventurier.add("Ingenieur");
        toutNomAventurier.add("Messager");
        toutNomAventurier.add("Navigateur");
        toutNomAventurier.add("Pilote");
        toutNomAventurier.add("Plongeur");

        for (Joueur unJoueur : joueurs) {

            Collections.shuffle(toutNomAventurier);

            switch (toutNomAventurier.get(1)) {
                case "Explorateur":
                    Explorateur explorateur = new Explorateur(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(explorateur);
                    unJoueur.setRole(explorateur);
                    unJoueur.setEmplacementJoueur(explorateur.getTuileDepart());

                case "Ingenieur":
                    Ingenieur ingenieur = new Ingenieur(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(ingenieur);
                    unJoueur.setRole(ingenieur);
                    unJoueur.setEmplacementJoueur(ingenieur.getTuileDepart());

                case "Messager":
                    Messager messager = new Messager(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(messager);
                    unJoueur.setRole(messager);
                    unJoueur.setEmplacementJoueur(messager.getTuileDepart());

                case "Navigateur":
                    Navigateur navigateur = new Navigateur(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(navigateur);
                    unJoueur.setRole(navigateur);
                    unJoueur.setEmplacementJoueur(navigateur.getTuileDepart());

                case "Pilote":
                    Pilote pilote = new Pilote(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(pilote);
                    unJoueur.setRole(pilote);
                    unJoueur.setEmplacementJoueur(pilote.getTuileDepart());

                case "Plongeur":
                    Plongeur plongeur = new Plongeur(toutNomAventurier.get(1), unJoueur);
                    aventuriers.add(plongeur);
                    unJoueur.setRole(plongeur);
                    unJoueur.setEmplacementJoueur(plongeur.getTuileDepart());
            }

            toutNomAventurier.remove(toutNomAventurier.get(1));

        }

        //Initialisation des tuiles à la main
        Tuile t00 = new Tuile(null, new Coordonnee(0, 0), null);
        grille.getTuiles().put(new Coordonnee(0, 0), t00);
        Tuile t01 = new Tuile(null, new Coordonnee(0, 1), null, null);
        grille.getTuiles().put(new Coordonnee(0, 1), t01);
        Tuile t02 = new Tuile(NomTuile.Le_Pont_des_Abimes, new Coordonnee(0, 2), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(0, 2), t02);
        Tuile t03 = new Tuile(NomTuile.La_Porte_de_Bronze, new Coordonnee(0, 3), Utils.EtatTuile.INONDEE);
        grille.getTuiles().put(new Coordonnee(0, 3), t03);
        Tuile t04 = new Tuile(null, new Coordonnee(0, 4), null);
        grille.getTuiles().put(new Coordonnee(0, 4), t04);
        Tuile t05 = new Tuile(null, new Coordonnee(0, 5), null);
        grille.getTuiles().put(new Coordonnee(0, 5), t05);
        Tuile t10 = new Tuile(null, new Coordonnee(1, 0), null);
        grille.getTuiles().put(new Coordonnee(1, 0), t10);
        Tuile t11 = new Tuile(NomTuile.La_Caverne_des_Ombres, new Coordonnee(1, 1), Utils.EtatTuile.ASSECHEE, TypeTresor.CRISTAL);
        grille.getTuiles().put(new Coordonnee(1, 1), t11);
        Tuile t12 = new Tuile(NomTuile.La_Porte_de_Fer, new Coordonnee(1, 2), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(1, 2), t12);
        Tuile t13 = new Tuile(NomTuile.La_Porte_d_Or, new Coordonnee(1, 3), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(1, 3), t13);
        Tuile t14 = new Tuile(NomTuile.Les_Falaises_de_l_Oubli, new Coordonnee(1, 4), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(1, 4), t14);
        Tuile t15 = new Tuile(null, new Coordonnee(1, 5), null);
        grille.getTuiles().put(new Coordonnee(1, 5), t15);
        Tuile t20 = new Tuile(NomTuile.Le_Palais_de_Corail, new Coordonnee(2, 0), Utils.EtatTuile.ASSECHEE, TypeTresor.CALICE);
        grille.getTuiles().put(new Coordonnee(2, 0), t20);
        Tuile t21 = new Tuile(NomTuile.La_Porte_d_Argent, new Coordonnee(2, 1), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(2, 1), t21);
        Tuile t22 = new Tuile(NomTuile.Les_Dunes_de_l_Illusion, new Coordonnee(2, 2), Utils.EtatTuile.COULEE);
        grille.getTuiles().put(new Coordonnee(2, 2), t22);
        Tuile t23 = new Tuile(NomTuile.Heliport, new Coordonnee(2, 3), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(2, 3), t23);
        Tuile t24 = new Tuile(NomTuile.La_Porte_de_Cuivre, new Coordonnee(2, 4), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(2, 4), t24);
        Tuile t25 = new Tuile(NomTuile.Le_Jardin_des_Hurlements, new Coordonnee(2, 5), Utils.EtatTuile.ASSECHEE, TypeTresor.STATUE);
        grille.getTuiles().put(new Coordonnee(2, 5), t25);
        Tuile t30 = new Tuile(NomTuile.La_Foret_Pourpre, new Coordonnee(3, 0), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(3, 0), t30);
        Tuile t31 = new Tuile(NomTuile.Le_Lagon_Perdu, new Coordonnee(3, 1), Utils.EtatTuile.INONDEE);
        grille.getTuiles().put(new Coordonnee(3, 1), t31);
        Tuile t32 = new Tuile(NomTuile.Le_Marais_Brumeux, new Coordonnee(3, 2), Utils.EtatTuile.COULEE);
        grille.getTuiles().put(new Coordonnee(3, 2), t32);
        Tuile t33 = new Tuile(NomTuile.Observatoire, new Coordonnee(3, 3), Utils.EtatTuile.INONDEE);
        grille.getTuiles().put(new Coordonnee(3, 3), t33);
        Tuile t34 = new Tuile(NomTuile.Le_Rocher_Fantome, new Coordonnee(3, 4), Utils.EtatTuile.COULEE);
        grille.getTuiles().put(new Coordonnee(3, 4), t34);
        Tuile t35 = new Tuile(NomTuile.La_Caverne_du_Brasier, new Coordonnee(3, 5), Utils.EtatTuile.INONDEE, TypeTresor.CRISTAL);
        grille.getTuiles().put(new Coordonnee(3, 5), t35);
        Tuile t40 = new Tuile(null, new Coordonnee(4, 0), null);
        grille.getTuiles().put(new Coordonnee(4, 0), t40);
        Tuile t41 = new Tuile(NomTuile.Le_Temple_du_Soleil, new Coordonnee(4, 1), Utils.EtatTuile.ASSECHEE, TypeTresor.PIERRE);
        grille.getTuiles().put(new Coordonnee(4, 1), t41);
        Tuile t42 = new Tuile(NomTuile.Le_Temple_de_La_Lune, new Coordonnee(4, 2), Utils.EtatTuile.COULEE, TypeTresor.PIERRE);
        grille.getTuiles().put(new Coordonnee(4, 2), t42);
        Tuile t43 = new Tuile(NomTuile.Le_Palais_des_Marees, new Coordonnee(4, 3), Utils.EtatTuile.ASSECHEE, TypeTresor.CALICE);
        grille.getTuiles().put(new Coordonnee(4, 3), t43);
        Tuile t44 = new Tuile(NomTuile.Le_Val_du_Crepuscule, new Coordonnee(4, 4), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(4, 4), t44);
        Tuile t45 = new Tuile(null, new Coordonnee(4, 5), null);
        grille.getTuiles().put(new Coordonnee(4, 5), t45);
        Tuile t50 = new Tuile(null, new Coordonnee(5, 0), null);
        grille.getTuiles().put(new Coordonnee(5, 0), t50);
        Tuile t51 = new Tuile(null, new Coordonnee(5, 1), null);
        grille.getTuiles().put(new Coordonnee(5, 1), t51);
        Tuile t52 = new Tuile(NomTuile.La_Tour_du_Guet, new Coordonnee(5, 2), Utils.EtatTuile.ASSECHEE);
        grille.getTuiles().put(new Coordonnee(5, 2), t52);
        Tuile t53 = new Tuile(NomTuile.Le_Jardin_des_Murmures, new Coordonnee(5, 3), Utils.EtatTuile.INONDEE, TypeTresor.STATUE);
        grille.getTuiles().put(new Coordonnee(5, 3), t53);
        Tuile t54 = new Tuile(null, new Coordonnee(5, 4), null);
        grille.getTuiles().put(new Coordonnee(5, 4), t54);
        Tuile t55 = new Tuile(null, new Coordonnee(5, 5), null);
        grille.getTuiles().put(new Coordonnee(5, 5), t55);

        for (Tuile uneTuile : grille.getTuiles().values()) {
            piocheInondation.add(new CarteInondation(uneTuile, true));
        }

        for (int i = 0; i < 5; i++) {
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CRISTAL));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.PIERRE));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.STATUE));

        }

        for (int i = 0; i < 3; i++) {
            piocheOrange.add(new MontéeEau(EmplacementCarte.PIOCHE));
        }

        for (int i = 0; i < 3; i++) {
            piocheOrange.add(new Helicoptere(EmplacementCarte.PIOCHE));
        }

        for (int i = 0; i < 2; i++) {
            piocheOrange.add(new SacDeSable(EmplacementCarte.PIOCHE));
        }

        Collections.shuffle(piocheOrange);

        for (int i = 0; i < 6; i++) {

            for (Tuile uneTuile : grille.getTuiles().values()) {
                if (piocheInondation.get(1).getTuile() == uneTuile) {
                    uneTuile.arroserTuile();
                    piocheInondation.get(1).setPioche(false);
                    piocheInondation.remove(piocheInondation.get(1));
                }
            }

        }

        for (Joueur unJoueur : joueurs) {
            for (int i = 0; i < 2; i++) {
                unJoueur.addCarteMainJoueur(piocheOrange.get(1));
                piocheOrange.get(1).setEmplacementCarte(EmplacementCarte.MAINJOUEUR);
                piocheOrange.remove(piocheOrange.get(1));
            }
        }

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

    public boolean isPartieTermine() {
        return partieTermine;
    }

    //setters
    public void setNiveauEau(int niveauEau) {
        this.niveauEau = niveauEau;
    }

    public void setPiocheInondation(ArrayList<CarteInondation> piocheInondation) {
        this.piocheInondation = piocheInondation;
    }

    public void setDefausseInondation(ArrayList<CarteInondation> defausseInondation) {
        this.defausseInondation = defausseInondation;
    }

    public void setPiocheOrange(ArrayList<CarteOrange> piocheOrange) {
        this.piocheOrange = piocheOrange;
    }

    public void setDefausseOrange(ArrayList<CarteOrange> defausseOrange) {
        this.defausseOrange = defausseOrange;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setToutNomAventurier(ArrayList<String> toutNomAventurier) {
        this.toutNomAventurier = toutNomAventurier;
    }

    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setPartieTermine(boolean partieTermine) {
        this.partieTermine = partieTermine;
    }

    public boolean isTropDeCartes() {
        if (joueurCourant.getMainJoueur().size() > 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isACarteSpe() {
        for (CarteOrange carteMain : joueurCourant.getMainJoueur()) {
            if (carteMain.getTypeClasse() == "Helicoptere" || carteMain.getTypeClasse() == "SacDeSable") {
                return true;
            }
        }
        return false;
    }

    //TOUR DE JEU (ahah.)
    public void tourDeJeu() {
        while (partieTermine = false) {
            if (isTropDeCartes()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Vous avez trop de cartes: ");
                System.out.println("1/ Défausser une carte");

                if (isACarteSpe()) {
                    System.out.println("2/ Utiliser une carte spéciale");
                }
                String entree = sc.nextLine();

                if (entree == "1") {
                    System.out.println("Sélectionner la carte à défausser");
                    int i = 1;

                    for (CarteOrange carteMain : joueurCourant.getMainJoueur()) {
                        System.out.print(i + "/ ");
                        System.out.println(carteMain.getTypeClasse());
                        i = i + 1;
                    }

                    System.out.println((joueurCourant.getMainJoueur().size() + 1) + "/ Retour aux choix");
                    entree = sc.nextLine();

                    if (entree != (joueurCourant.getMainJoueur().size() + 1) + "") {
                        i = 1;

                        for (CarteOrange carteMain : joueurCourant.getMainJoueur()) {
                            if (i + "" == entree) {
                                carteMain.setEmplacementCarte(EmplacementCarte.DEFAUSSE);
                                joueurCourant.removeCarteMainJoueur(carteMain);
                            }
                            i = i + 1;
                        }
                    } else if (isACarteSpe() && entree == 2 + "") {

                    }

                }
            }

        }
    }
}
