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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EmplacementCarte;
import util.Message;
import util.TypeTresor;
import util.TypesMessages;
import util.Utils;
import util.Utils.EtatTuile;
import view.FenetreConfirmationQuitter;
import view.FenetreDebut;
import view.FenetreFin;
import view.FenetreInfo;
import view.FenetreInterface;
import view.FenetreJeu;
import view.FenetreJoueur;
import view.FenetrePopupDebutTour;
import view.Observateur;

/**
 *
 * @author fodorg
 */
public class Controleur implements Observateur {

    private final boolean hasard = false;
    private final boolean avecFinJeu =true;
    private final boolean avecInondation = true;
    private final boolean testRecup = false;
    private final boolean piocheInitiale = false;

    private int niveauEau;
    private Stack<CarteInondation> piocheInondation; // 0..24
    private Stack<CarteInondation> defausseInondation; // 0..24
    private Stack<CarteOrange> piocheOrange; //0..28
    private Stack<CarteOrange> defausseOrange; //0..28
    private ArrayList<Joueur> joueurs; //2..4
    private ArrayList<String> toutNomAventurier;
    private ArrayList<Aventurier> aventuriers; // Il y en a 6 de base et on peut en retirer max 4
    private ArrayList<TypeTresor> tresorsRecuperables;
    private HashMap<Coordonnee, Tuile> tuiles;
    private Grille grille;
    private Joueur joueurCourant;
    private int nombreAction;
    private boolean piloteSpe = false;
    private int nbCartePiocher;
    private Message messageSauv = new Message(); // sauvegarde du message précédent dans le traiterMessage
    private Message messageRien = new Message();

    private FenetreDebut fenetreDebut;
    private FenetreJeu fenetreJeu;
    private FenetreInfo fenetreInfo;
    private FenetreJoueur fenetreJoueur;
    private FenetreConfirmationQuitter fenetreConfirmationQuitter;
    private FenetreFin fenetreFin;
    private FenetreInterface fenetreInterface;
    private boolean IngeAssecherPossible;

    public Controleur() {
        messageRien.type = TypesMessages.RIEN;
        messageSauv = messageRien;
        try {
            fenetreDebut = new FenetreDebut();
            fenetreDebut.addObservateur(this);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initGrille(int nbJoueur) {
        piocheInondation = new Stack<>();
        defausseInondation = new Stack<>();
        piocheOrange = new Stack<>();
        defausseOrange = new Stack<>();
        joueurs = new ArrayList<>();
        toutNomAventurier = new ArrayList<>();
        aventuriers = new ArrayList<>();
        tuiles = new HashMap<>();
        tresorsRecuperables = new ArrayList<>();

        /* Initialisation de la collection de trésors à récupérer */
        tresorsRecuperables.add(TypeTresor.CALICE);
        tresorsRecuperables.add(TypeTresor.STATUE);
        tresorsRecuperables.add(TypeTresor.CRISTAL);
        tresorsRecuperables.add(TypeTresor.PIERRE);

        toutNomAventurier.add("Messager");
        toutNomAventurier.add("Ingenieur");
        toutNomAventurier.add("Explorateur");
        toutNomAventurier.add("Pilote");
        toutNomAventurier.add("Navigateur");
        toutNomAventurier.add("Plongeur");

        for (int i = 0; i < nbJoueur; i++) {
            Joueur joueur = new Joueur(i);
            joueurs.add(joueur);
        }

        //Initialisation des tuiles à la main
        Tuile t00 = new Tuile(null, new Coordonnee(0, 0), null);
        tuiles.put(new Coordonnee(0, 0), t00);
        Tuile t01 = new Tuile(null, new Coordonnee(0, 1), null, null);
        tuiles.put(new Coordonnee(0, 1), t01);
        Tuile t02 = new Tuile(NomTuile.Le_Pont_des_Abimes, new Coordonnee(0, 2), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(0, 2), t02);
        Tuile t03 = new Tuile(NomTuile.La_Porte_de_Bronze, new Coordonnee(0, 3), Utils.EtatTuile.INONDEE);
        tuiles.put(new Coordonnee(0, 3), t03);
        Tuile t04 = new Tuile(null, new Coordonnee(0, 4), null);
        tuiles.put(new Coordonnee(0, 4), t04);
        Tuile t05 = new Tuile(null, new Coordonnee(0, 5), null);
        tuiles.put(new Coordonnee(0, 5), t05);
        Tuile t10 = new Tuile(null, new Coordonnee(1, 0), null);
        tuiles.put(new Coordonnee(1, 0), t10);
        Tuile t11 = new Tuile(NomTuile.La_Caverne_des_Ombres, new Coordonnee(1, 1), Utils.EtatTuile.ASSECHEE, TypeTresor.CRISTAL);
        tuiles.put(new Coordonnee(1, 1), t11);
        Tuile t12 = new Tuile(NomTuile.La_Porte_de_Fer, new Coordonnee(1, 2), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(1, 2), t12);
        Tuile t13 = new Tuile(NomTuile.La_Porte_d_Or, new Coordonnee(1, 3), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(1, 3), t13);
        Tuile t14 = new Tuile(NomTuile.Les_Falaises_de_l_Oubli, new Coordonnee(1, 4), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(1, 4), t14);
        Tuile t15 = new Tuile(null, new Coordonnee(1, 5), null);
        tuiles.put(new Coordonnee(1, 5), t15);
        Tuile t20 = new Tuile(NomTuile.Le_Palais_de_Corail, new Coordonnee(2, 0), Utils.EtatTuile.ASSECHEE, TypeTresor.CALICE);
        tuiles.put(new Coordonnee(2, 0), t20);
        Tuile t21 = new Tuile(NomTuile.La_Porte_d_Argent, new Coordonnee(2, 1), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(2, 1), t21);
        Tuile t22 = new Tuile(NomTuile.Les_Dunes_de_l_Illusion, new Coordonnee(2, 2), Utils.EtatTuile.COULEE);
        tuiles.put(new Coordonnee(2, 2), t22);
        Tuile t23 = new Tuile(NomTuile.Heliport, new Coordonnee(2, 3), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(2, 3), t23);
        Tuile t24 = new Tuile(NomTuile.La_Porte_de_Cuivre, new Coordonnee(2, 4), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(2, 4), t24);
        Tuile t25 = new Tuile(NomTuile.Le_Jardin_des_Hurlements, new Coordonnee(2, 5), Utils.EtatTuile.ASSECHEE, TypeTresor.STATUE);
        tuiles.put(new Coordonnee(2, 5), t25);
        Tuile t30 = new Tuile(NomTuile.La_Foret_Pourpre, new Coordonnee(3, 0), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(3, 0), t30);
        Tuile t31 = new Tuile(NomTuile.Le_Lagon_Perdu, new Coordonnee(3, 1), Utils.EtatTuile.INONDEE);
        tuiles.put(new Coordonnee(3, 1), t31);
        Tuile t32 = new Tuile(NomTuile.Le_Marais_Brumeux, new Coordonnee(3, 2), Utils.EtatTuile.COULEE);
        tuiles.put(new Coordonnee(3, 2), t32);
        Tuile t33 = new Tuile(NomTuile.Observatoire, new Coordonnee(3, 3), Utils.EtatTuile.INONDEE);
        tuiles.put(new Coordonnee(3, 3), t33);
        Tuile t34 = new Tuile(NomTuile.Le_Rocher_Fantome, new Coordonnee(3, 4), Utils.EtatTuile.COULEE);
        tuiles.put(new Coordonnee(3, 4), t34);
        Tuile t35 = new Tuile(NomTuile.La_Caverne_du_Brasier, new Coordonnee(3, 5), Utils.EtatTuile.INONDEE, TypeTresor.CRISTAL);
        tuiles.put(new Coordonnee(3, 5), t35);
        Tuile t40 = new Tuile(null, new Coordonnee(4, 0), null);
        tuiles.put(new Coordonnee(4, 0), t40);
        Tuile t41 = new Tuile(NomTuile.Le_Temple_du_Soleil, new Coordonnee(4, 1), Utils.EtatTuile.ASSECHEE, TypeTresor.PIERRE);
        tuiles.put(new Coordonnee(4, 1), t41);
        Tuile t42 = new Tuile(NomTuile.Le_Temple_de_La_Lune, new Coordonnee(4, 2), Utils.EtatTuile.COULEE, TypeTresor.PIERRE);
        tuiles.put(new Coordonnee(4, 2), t42);
        Tuile t43 = new Tuile(NomTuile.Le_Palais_des_Marees, new Coordonnee(4, 3), Utils.EtatTuile.ASSECHEE, TypeTresor.CALICE);
        tuiles.put(new Coordonnee(4, 3), t43);
        Tuile t44 = new Tuile(NomTuile.Le_Val_du_Crepuscule, new Coordonnee(4, 4), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(4, 4), t44);
        Tuile t45 = new Tuile(null, new Coordonnee(4, 5), null);
        tuiles.put(new Coordonnee(4, 5), t45);
        Tuile t50 = new Tuile(null, new Coordonnee(5, 0), null);
        tuiles.put(new Coordonnee(5, 0), t50);
        Tuile t51 = new Tuile(null, new Coordonnee(5, 1), null);
        tuiles.put(new Coordonnee(5, 1), t51);
        Tuile t52 = new Tuile(NomTuile.La_Tour_du_Guet, new Coordonnee(5, 2), Utils.EtatTuile.ASSECHEE);
        tuiles.put(new Coordonnee(5, 2), t52);
        Tuile t53 = new Tuile(NomTuile.Le_Jardin_des_Murmures, new Coordonnee(5, 3), Utils.EtatTuile.INONDEE, TypeTresor.STATUE);
        tuiles.put(new Coordonnee(5, 3), t53);
        Tuile t54 = new Tuile(null, new Coordonnee(5, 4), null);
        tuiles.put(new Coordonnee(5, 4), t54);
        Tuile t55 = new Tuile(null, new Coordonnee(5, 5), null);
        tuiles.put(new Coordonnee(5, 5), t55);

        grille = new Grille(tuiles);

        for (Joueur unJoueur : joueurs) {

            if (hasard) {
                Collections.shuffle(toutNomAventurier);
            }

            switch (toutNomAventurier.get(0)) {
                case "Explorateur":
                    Explorateur explorateur = new Explorateur(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(explorateur);
                    unJoueur.setRole(explorateur);
                    unJoueur.setEmplacementJoueur(explorateur.getTuileDepart());
                    break;

                case "Ingenieur":
                    Ingenieur ingenieur = new Ingenieur(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(ingenieur);
                    unJoueur.setRole(ingenieur);
                    unJoueur.setEmplacementJoueur(ingenieur.getTuileDepart());
                    break;

                case "Messager":
                    Messager messager = new Messager(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(messager);
                    unJoueur.setRole(messager);
                    unJoueur.setEmplacementJoueur(messager.getTuileDepart());
                    break;

                case "Navigateur":
                    Navigateur navigateur = new Navigateur(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(navigateur);
                    unJoueur.setRole(navigateur);
                    unJoueur.setEmplacementJoueur(navigateur.getTuileDepart());
                    break;

                case "Pilote":
                    Pilote pilote = new Pilote(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(pilote);
                    unJoueur.setRole(pilote);
                    unJoueur.setEmplacementJoueur(pilote.getTuileDepart());
                    break;

                case "Plongeur":
                    Plongeur plongeur = new Plongeur(toutNomAventurier.get(0), unJoueur, grille);
                    aventuriers.add(plongeur);
                    unJoueur.setRole(plongeur);
                    unJoueur.setEmplacementJoueur(plongeur.getTuileDepart());
                    break;
            }

            toutNomAventurier.remove(toutNomAventurier.get(0)); // retire des choix l'aventurier attribué

        }

        for (Tuile uneTuile : grille.getTuiles().values()) {
            if (uneTuile.getNom() != null) {
                if (hasard) {
                    piocheInondation.add(new CarteInondation(uneTuile, true));
                } else {
                    if (uneTuile.getEtat().equals(Utils.EtatTuile.ASSECHEE)) {
                        piocheInondation.add(new CarteInondation(uneTuile, true));
                    } else if (uneTuile.getEtat().equals(Utils.EtatTuile.INONDEE)) {
                        defausseInondation.add(new CarteInondation(uneTuile, true));
                    }
                }
            }
        }

        Collections.shuffle(piocheInondation);

        for (int i = 0; i < 5; i++) {
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CRISTAL));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.PIERRE));
            piocheOrange.add(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.STATUE));

        }

        for (int i = 0; i < 2; i++) {
            piocheOrange.add(new MontéeEau(EmplacementCarte.PIOCHE));
        }

        for (int i = 0; i < 3; i++) {
            piocheOrange.add(new Helicoptere(EmplacementCarte.PIOCHE));
        }

        for (int i = 0; i < 2; i++) {
            piocheOrange.add(new SacDeSable(EmplacementCarte.PIOCHE));
        }

        Collections.shuffle(piocheOrange);

        if (piocheInitiale) {
            for (int i = 0; i < 6; i++) {
                piocherInondation();
            }
        }

        for (Joueur unJoueur : joueurs) {
            for (int i = 0; i < 2; i++) {  //DEBUG
                if (piocheOrange.peek().getTypeClasse().equals("MontéeEau")) {
                    defausseOrange.push(piocheOrange.pop());
                    i--;
                } else {
                    unJoueur.addCarteMainJoueur(piocheOrange.peek());
                    piocheOrange.peek().setEmplacementCarte(EmplacementCarte.MAINJOUEUR);
                    piocheOrange.pop();
                }
            }
        }
        
        if (testRecup) {
            joueurs.get(0).addCarteMainJoueur(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
            joueurs.get(0).addCarteMainJoueur(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
            joueurs.get(0).addCarteMainJoueur(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
            joueurs.get(0).addCarteMainJoueur(new Tresor(EmplacementCarte.PIOCHE, TypeTresor.CALICE));
        }
        
        
        joueurCourant = joueurs.get(0);
        if (joueurCourant.getRole().getNom().equals("Pilote")) {
            piloteSpe = true;
        } else {
            piloteSpe = false;
        }

        if (joueurCourant.getRole().getNom().equals("Ingenieur")) {
            IngeAssecherPossible = true;
        } else {
            IngeAssecherPossible = false;
        }
    }

    public boolean isDeplacementPossible() {
        for (int i = 0; i < 4; i++) {
            if (getGrille().filtreCasesSeches(getGrille().getCasesContourAssechement(joueurCourant.getEmplacementJoueur()))
                    != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isAssechementPossible() {
        if ("Explorateur".equals(joueurCourant.getRole().getRoleAventurier())) {
            return !getGrille().filtreCasesInondees(getGrille().getCasesContourAssechement(joueurCourant.getEmplacementJoueur())).isEmpty();
        } else {
            return !getGrille().filtreCasesInondees(getGrille().getCasesLateralesAssechement(joueurCourant.getEmplacementJoueur())).isEmpty();
        }
    }

    public boolean isDonnerCartePossible(Joueur joueurCible) {
        return joueurCible.getEmplacementJoueur() == joueurCourant.getEmplacementJoueur();
    }

    public boolean isRecupererTresorPossible() {
        int nb = 0;
        if (joueurCourant.getEmplacementJoueur().getCaseTresor() != null) {
            for (int i = 0; i < joueurCourant.getMainJoueur().size(); i++) {
                if (joueurCourant.getEmplacementJoueur().getCaseTresor() == joueurCourant.getMainJoueur().get(i).getTypeTresor()) {
                    nb = nb + 1;
                }
            }
        }
        return nb > 3;
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

    ///////////////getters
    public Stack<CarteInondation> getPiocheInondation() {
        return piocheInondation;
    }

    public Stack<CarteInondation> getDefausseInondation() {
        return defausseInondation;
    }

    public Stack<CarteOrange> getPiocheOrange() {
        return piocheOrange;
    }

    public Stack<CarteOrange> getDefausseOrange() {
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
    /////////////

    ///////////////////////setters
    public void setNiveauEau(int niveauEau) {
        this.niveauEau = niveauEau;
    }

    public void setPiocheInondation(Stack<CarteInondation> piocheInondation) {
        this.piocheInondation = piocheInondation;
    }

    public void setDefausseInondation(Stack<CarteInondation> defausseInondation) {
        this.defausseInondation = defausseInondation;
    }

    public void setPiocheOrange(Stack<CarteOrange> piocheOrange) {
        this.piocheOrange = piocheOrange;
    }

    public void setDefausseOrange(Stack<CarteOrange> defausseOrange) {
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
    //////////////////

    public boolean isTropDeCartes() {
        return joueurCourant.getMainJoueur().size() > 5;
    }

    public boolean isPiocherPossible() {
        return joueurCourant.getMainJoueur().size() < 8;
    }

    public void piocherCarteOrange() {
        if (piocheOrange.peek().getTypeClasse().equals("MontéeEau")) {
            niveauEau++;
            fenetreJeu.DefausserCarte("MontéeEau");
            fenetreInfo.changerImageJauge(niveauEau);
            for (int i = 0; i < niveauEau; i++) {
                empilerDefausseInondation();
            }
        } else {
            joueurCourant.addCarteMainJoueur(piocheOrange.peek());
            fenetreJeu.piocherCarteOrange(joueurCourant, piocheOrange.peek(), piocheOrange.size() - 1);
        }
        piocheOrange.pop();
        melangerPiocheOrange(defausseOrange); //effectue le test seul
    }

    public void defausserCarte(Joueur joueur, CarteOrange carte) {
        defausseOrange.push(carte);
        joueur.getMainJoueur().remove(carte);
        fenetreJeu.retirerCarteMainJoueur(joueur, carte);
        if (carte.getTypeTresor() != null) {
            fenetreJeu.DefausserCarte(carte.getTypeTresor().name());
        } else {
            fenetreJeu.DefausserCarte(carte.getTypeClasse());
        }

    }

    public void empilerDefausseInondation() { //qd y'a une carte montée des eaux
        Collections.shuffle(defausseInondation);
        
        while (defausseInondation.size() > 0) {
            piocheInondation.push(defausseInondation.pop());
        }
        /*for (CarteInondation uneCarte : defausseInondation) {
            piocheInondation.push(uneCarte);
        }*/
        //defausseInondation.clear();
        fenetreJeu.viderDefausseInondation(piocheInondation.size());
        System.out.println("taile apres empiler : " + piocheInondation.size());
    }

    public void melangerPiocheOrange(Stack<CarteOrange> defausseOrange) { //transforme et mélange la défausse orange en une nouvelle pioche
        if (piocheOrange.isEmpty()) {
            Collections.shuffle(defausseOrange);
            piocheOrange.addAll(defausseOrange);
            defausseOrange.clear();
            fenetreJeu.viderDefausseOrange(piocheOrange.size());
        }
    }

    public ArrayList<CarteOrange> getCarteSpeJoueurCourant() {
        ArrayList<CarteOrange> carteSpeJoueurCourant = new ArrayList<>();
        for (CarteOrange carteMain : joueurCourant.getMainJoueur()) {
            if ("Helicoptere".equals(carteMain.getTypeClasse()) || "SacDeSable".equals(carteMain.getTypeClasse())) {
                carteSpeJoueurCourant.add(carteMain);
            }
        }
        return carteSpeJoueurCourant;
    }

    public boolean isACarteSpe() {
        for (CarteOrange carteMain : joueurCourant.getMainJoueur()) {
            if ("Helicoptere".equals(carteMain.getTypeClasse()) || "SacDeSable".equals(carteMain.getTypeClasse())) {
                return true;
            }
        }
        return false;
    }

    public void piocherInondation() {
        CarteInondation carteSauv = new CarteInondation();
        Tuile tuileSauv = new Tuile();
        //CarteSauv.setTuile(tuileSauv);
        //tuileSauv = piocheInondation.pop().getTuile();
        carteSauv = piocheInondation.pop();
        tuileSauv = carteSauv.getTuile();
        System.out.println("nom tuile courante : " + tuileSauv.getNom().toString());

        for (Tuile tuile : grille.getTuilesPure().values()) {
            if (tuile.equals(tuileSauv)) {
                tuile.arroserTuile();
                fenetreJeu.setTuile(tuile);
                fenetreJeu.piocherInondation(tuile, piocheInondation.size());
                if (tuile.getEtat() != EtatTuile.COULEE) {
                    defausseInondation.push(carteSauv);
                }

            }
        }
        
        if (avecFinJeu) {
            verifFinInondation(tuileSauv);
            verifDéfaiteNiveauEau();
        }
        if (piocheInondation.isEmpty()) {
            empilerDefausseInondation();
        }
    }

    public void joueurSuivant() {
        int i = joueurs.indexOf(joueurCourant);
        if (i == joueurs.size() - 1) {
            joueurCourant = joueurs.get(0);
        } else {
            joueurCourant = joueurs.get(i + 1);
        }
    }

    public void effectuerDeplacement(Joueur joueur, Tuile tuile) { // déplace effectivement le joueur (ne vérifie rien)
        joueur.getEmplacementJoueur().getJoueursTuile().remove(joueur);
        fenetreJeu.setTuile(joueur.getEmplacementJoueur()); //IHM
        joueur.setEmplacementJoueur(tuile);
        joueur.getEmplacementJoueur().getJoueursTuile().add(joueur);
        fenetreJeu.setTuile(tuile); // IHM
    }

    public void effectuerAssechement(Tuile tuile) { // assèche effectivemment une tuile (ne vérifie rien)
        tuile.setEtat(Utils.EtatTuile.ASSECHEE);
        fenetreJeu.setTuile(tuile);
    }

    public void effectuerDonCarte(Joueur donneur, Joueur receveur, CarteOrange carte) { // transfère effectivemment une carte (ne vérifie rien)
        donneur.getMainJoueur().remove(carte);
        receveur.getMainJoueur().add(carte);
    }

    public void effectuerRecuperationTresor(Tuile tuile, Joueur joueur) { // récupère effectivemment le trésor et retire les cartes correspondantes dans la main du joueur (ne vérifie pas si le joueur a bien les 4 cartes)
        TypeTresor tresorRecuperableCase = joueur.getEmplacementJoueur().getCaseTresor();
        int compteur = 0;

        ArrayList<CarteOrange> mainSauv = new ArrayList<>();
        for (CarteOrange uneCarteOrange : joueur.getMainJoueur()) { // récupère les 4 premières cartes trésor conrrespondantes      
            if (uneCarteOrange.getTypeTresor() != null) {
                if (uneCarteOrange.getTypeTresor().equals(tresorRecuperableCase) && compteur < 4) {
                    //joueur.getMainJoueur().remove(uneCarteOrange);
                    mainSauv.add(uneCarteOrange);
                    compteur++;
                }
            }
        }
        joueur.getMainJoueur().removeAll(mainSauv);
        
        tresorsRecuperables.remove(tresorRecuperableCase);
    }

    public void traiterMessage(Message m) {

        switch (m.type) {
            case CONTINUER: //choix du niveau de dificulté et du nombre de perso
                int nbJ;
                if (m.nbJoueur.equals("2")) {
                    nbJ = 2;
                } else if (m.nbJoueur.equals("3")) {
                    nbJ = 3;
                } else {
                    nbJ = 4;
                }
                niveauEau = m.difficulté;
                initGrille(nbJ);
                fenetreDebut.visible(false);
                fenetreJoueur = new FenetreJoueur(nbJ);
                fenetreJoueur.addObservateur(this);
                break;

            case DEMARRER: //le joueur demarre la partie

                joueurs.get(0).setNomJoueur(m.joueur1);
                joueurs.get(1).setNomJoueur(m.joueur2);
                if (m.joueur3 != null) {
                    joueurs.get(2).setNomJoueur(m.joueur3);
                }
                if (m.joueur4 != null) {
                    joueurs.get(3).setNomJoueur(m.joueur4);
                }
                fenetreJoueur.visible(false);
                joueurCourant = joueurs.get(0);

                try {
                    fenetreJeu = new FenetreJeu(joueurs, piocheOrange, piocheInondation);
                    fenetreJeu.addObservateur(this);
                    fenetreJeu.placerTuiles(tuiles);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    fenetreInfo = new FenetreInfo();
                    fenetreInfo.addObservateur(this);
                    fenetreInfo.modifierLabelJoueur(joueurCourant);
                    fenetreInfo.boutonSpeciale(joueurCourant.getRole().getNom());
                    nombreAction = 3;
                    fenetreInfo.affichageAction(nombreAction);
                    fenetreInfo.changerImageJauge(niveauEau);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Cliquez sur l'une des actions\n  ci-dessous :");
                break;

            case ANNULER:
                if (nombreAction > 0) {
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Cliquez sur l'une des actions\n  ci-dessous :");
                    fenetreInfo.cliquableDefaut();
                    fenetreJeu.cliquableRoleToutTrue();
                    fenetreJeu.setSurbrillanceDefault();

                    messageSauv = messageRien;
                } else {
                    commencerPiocheOrange();
                }

                break;

            case SE_DEPLACER: //le joueur clique sur se deplacer
                //ihm.setSurbrillance(joueurCourant.getRole().getTuilesDeplacementPossible(grille));
                messageSauv = m;

                fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " cliquez maintenant sur \n\n  la case où vous voulez vous déplacer !");
                fenetreInfo.cliquableAttenteDaction();

                fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuilesDeplacementPossible(grille));

                verifVictoire();
                break;

            case ASSECHER: //le joueur clique sur assecher
                //ihm.setSurbrillance(joueurCourant.getRole().getTuilesAssechables(grille));
                messageSauv = m;

                fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " cliquez maintenant sur \n\n  la case que vous voulez assécher !");
                fenetreInfo.cliquableAttenteDaction();

                fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuilesAssechables(grille));
                break;

            case CHOIX_JOUEUR:
                if (messageSauv.type.equals(TypesMessages.DONNER_CARTE)) {
                    fenetreInfo.setTextInfoJeu("\n " + joueurCourant.getNomJoueur() + " choisissez la carte \n \n à donner à " + m.joueurVise.getNomJoueur());

                    fenetreJeu.cliquableRoleToutFalse();
                    messageSauv.joueurVise = m.joueurVise;

                } else if (messageSauv.type.equals(TypesMessages.DEPLACER_AUTRES_JOUEURS)) {
                    messageSauv = m;
                    fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " choisissez où vous \n \n voulez déplacer le joueur " + m.joueurVise.getNomJoueur());
                    fenetreInfo.cliquableAttenteDaction();

                    fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuilesDeplacementCompagnon(grille, m.joueurVise.getEmplacementJoueur()));
                    fenetreJeu.cliquableRoleToutFalse();

                    messageSauv = m;
                    m.type = TypesMessages.DEPLACER_AUTRES_JOUEURS;
                } else {
                    try {
                        FenetrePopupDebutTour fen = new FenetrePopupDebutTour(m.joueurVise.getRole().getNom());
                    } catch (IOException ex) {
                        Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case CHOIX_TUILE:
                if (messageSauv.type.equals(TypesMessages.SE_DEPLACER) && joueurCourant.getRole().getTuilesDeplacementPossible(grille).containsValue(m.tuileSelectionne)) {
                    effectuerDeplacement(joueurCourant, m.tuileSelectionne);
                    nombreAction--;
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");
                    fenetreInfo.affichageAction(nombreAction);

                    messageSauv = messageRien;

                    fenetreInfo.cliquableDefaut();
                    fenetreJeu.setSurbrillanceDefault();
                } else if (messageSauv.type.equals(TypesMessages.ASSECHER) && joueurCourant.getRole().getTuilesAssechables(grille).containsValue(m.tuileSelectionne)) {
                    effectuerAssechement(m.tuileSelectionne);
                    nombreAction--;
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");
                    fenetreInfo.affichageAction(nombreAction);

                    if (joueurCourant.getRole().getNom().equals("Ingenieur") && !joueurCourant.getRole().getTuilesAssechables(grille).isEmpty() && IngeAssecherPossible) {
                        fenetreJeu.setSurbrillanceDefault();
                        fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuilesAssechables(grille));
                    } else {
                        messageSauv = messageRien;

                        fenetreInfo.cliquableDefaut();
                        fenetreJeu.setSurbrillanceDefault();
                    }

                } else if (messageSauv.type.equals(TypesMessages.UTILISER_CARTE)) {
                    if (messageSauv.carteSelectionne != null) {
                        if (messageSauv.carteSelectionne.getTypeClasse().equals("Helicoptere")) {
                            effectuerDeplacement(joueurCourant, m.tuileSelectionne);
                            defausserCarte(joueurCourant, messageSauv.carteSelectionne);

                        } else if (messageSauv.carteSelectionne.getTypeClasse().equals("SacDeSable")) {
                            effectuerAssechement(m.tuileSelectionne);
                            
                            defausserCarte(joueurCourant, messageSauv.carteSelectionne);
                        }

                        defausserCarte(joueurCourant, messageSauv.carteSelectionne);
                        fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");

                        messageSauv = messageRien;

                        fenetreInfo.cliquableDefaut();
                        fenetreJeu.setSurbrillanceDefault();
                    }

                } else if (messageSauv.type.equals(TypesMessages.DEPLACEMENT_HELICO) && joueurCourant.getRole().getTuileHelicoPossible(grille).containsValue(m.tuileSelectionne)) {
                    effectuerDeplacement(joueurCourant, m.tuileSelectionne);
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");
                    fenetreInfo.boutonSpeciale("rien");

                    fenetreInfo.cliquableDefaut();
                    fenetreJeu.setSurbrillanceDefault();

                    messageSauv = messageRien;

                } else if (messageSauv.type.equals(TypesMessages.DEPLACER_AUTRES_JOUEURS) && joueurCourant.getRole().getTuilesDeplacementCompagnon(grille, messageSauv.joueurVise.getEmplacementJoueur()).containsValue(m.tuileSelectionne)) {
                    effectuerDeplacement(messageSauv.joueurVise, m.tuileSelectionne);

                    nombreAction--;
                    fenetreInfo.affichageAction(nombreAction);

                    fenetreInfo.cliquableDefaut();
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");

                    fenetreJeu.setSurbrillanceDefault();
                    fenetreJeu.cliquableRoleToutTrue();

                    messageSauv = messageRien;
                }

                if (nombreAction == 0) {
                    fenetreInfo.affichageAction(nombreAction);
                    commencerPiocheOrange();
                    fenetreInfo.setTextInfoJeu("\n  Début du tour de pioche \n  " + joueurCourant.getNomJoueur());
                }
                break;

            case DONNER_CARTE:
                messageSauv = m;
                fenetreInfo.cliquableAttenteDaction();
                fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " à qui voulez vous \n \n donner une carte ?");

                fenetreJeu.cliquableRoleToutFalse();
                if (joueurCourant.getRole().getRoleAventurier() == "Messager") {
                    for (Joueur joueur : joueurs) {
                        if (joueur.getRole().getNom() != "Messager" && joueur.nbCartesJoueur() < 9) {
                            fenetreJeu.cliquableRole(joueur.getNumeroJoueur(), true);
                        }
                    }
                } else {
                    for (Joueur joueur : joueurCourant.getEmplacementJoueur().getJoueursTuile()) {
                        if (!joueur.equals(joueurCourant) && joueur.nbCartesJoueur() < 8) {
                            fenetreJeu.cliquableRole(joueur.getNumeroJoueur(), true);
                        }
                    }
                }
                break;

            case PASSER_TOUR:
                fenetreInfo.cliquableDefaut();
                messageSauv = messageRien;
                nombreAction = 0;
                fenetreInfo.affichageAction(nombreAction);
                commencerPiocheOrange();
                fenetreInfo.setTextInfoJeu("\n  Début du tour de pioche \n  " + joueurCourant.getNomJoueur());

                break;

            case RECUPERER_TRESOR:
                if (isRecupererTresorPossible()) {
                    effectuerRecuperationTresor(joueurCourant.getEmplacementJoueur(), joueurCourant);
                    fenetreInfo.cliquableDefaut();
                    fenetreInfo.changerImageTresor(joueurCourant.getEmplacementJoueur().getCaseTresor());

                    fenetreJeu.recupererTresor(joueurCourant);
                    messageSauv = messageRien;

                    nombreAction--;
                    fenetreInfo.affichageAction(nombreAction);
                    if (nombreAction == 0) {
                        commencerPiocheOrange();
                        fenetreInfo.setTextInfoJeu("\n  Début du tour de pioche \n  " + joueurCourant.getNomJoueur());
                    }
                }

                break;
            case UTILISER_CARTE:
                messageSauv = m;
                fenetreInfo.cliquableAttenteDaction();
                fenetreInfo.setTextInfoJeu("\n " + joueurCourant.getNomJoueur() + " choisissez la carte \n \n que vous voulez utiliser");
                break;

            case CHOIX_CARTE:
                if (messageSauv.type.equals(TypesMessages.UTILISER_CARTE)) {
                    if (m.carteSelectionne.getTypeClasse() == "Helicoptere") {
                        fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " cliquez maintenant sur \n\n  la case où vous voulez vous déplacer !");
                        fenetreJeu.setSurbrillanceDefault();
                        fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuileHelicoPossible(grille));

                        messageSauv = m;
                        messageSauv.type = TypesMessages.UTILISER_CARTE;

                    } else if (m.carteSelectionne.getTypeClasse() == "SacDeSable") {
                        fenetreInfo.setTextInfoJeu("\n  " + joueurCourant.getNomJoueur() + " cliquez maintenant sur \n\n  la case que vous voulez assécher !");
                        fenetreJeu.setSurbrillanceDefault();
                        fenetreJeu.setSurbrillance(grille.getTuilesInondees());

                        messageSauv = m;
                        messageSauv.type = TypesMessages.UTILISER_CARTE;

                    }
                    fenetreInfo.cliquableAttenteDaction();

                } else if (messageSauv.type.equals(TypesMessages.TROP_CARTE)) {
                    defausserCarte(joueurCourant, m.carteSelectionne);

                    

                    if (!isTropDeCartes()) {
                        fenetreInfo.cliquableDefaut();
                        messageSauv = messageRien;
                        fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");

                    } else {
                        fenetreInfo.cliquableBloque();
                        fenetreInfo.cliquableUtiliser(true);
                    }
                } else if (messageSauv.type.equals(TypesMessages.DONNER_CARTE) && messageSauv.joueurVise != null && m.joueurActuel.equals(joueurCourant)) {
                    fenetreInfo.cliquableDefaut();

                    effectuerDonCarte(joueurCourant, messageSauv.joueurVise, m.carteSelectionne);

                    fenetreJeu.DonnerCarteJoueur(joueurCourant, messageSauv.joueurVise, m.carteSelectionne);
                    fenetreJeu.cliquableRoleToutTrue();

                    nombreAction--;
                    fenetreInfo.affichageAction(nombreAction);
                    fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");

                    messageSauv = messageRien;
                }

                if (nombreAction == 0) {
                    fenetreInfo.affichageAction(nombreAction);
                    commencerPiocheOrange();
                    fenetreInfo.setTextInfoJeu("\n  Début du tour de pioche \n  " + joueurCourant.getNomJoueur());
                }
                break;

            //Piochage de cartes oranges à la fin du tour
            case PIOCHER_CARTE_ORANGE:
                if (nombreAction == 0) {
                    piocherCarteOrange();
                    nbCartePiocher++;
                    if (nbCartePiocher >= 2) {
                        inondation();
                    }
                }
                break;

            case DEPLACEMENT_HELICO: //Action Spéciale du pilote
                fenetreJeu.setSurbrillance(joueurCourant.getRole().getTuileHelicoPossible(grille));

                fenetreInfo.cliquableAttenteDaction();
                fenetreInfo.setTextInfoJeu("\n " + joueurCourant.getNomJoueur() + ", où voulez  \n \nvous atterrir ?");

                messageSauv = m;
                break;

            case DEPLACER_AUTRES_JOUEURS: //Action spéciale du navigo
                fenetreJeu.cliquableRoleToutFalse();
                fenetreInfo.setTextInfoJeu("\n " + joueurCourant.getNomJoueur() + ", sélectionnez le\n \n joueur à déplacer");
                for (Joueur joueur : joueurs) {
                    if (!joueur.equals(joueurCourant)) {
                        fenetreJeu.cliquableRole(joueur.getNumeroJoueur(), true);
                    }
                }
                fenetreInfo.cliquableAttenteDaction();
                messageSauv = m;
                break;

            case CLIQUE_QUITTER: //quand l'utilisateur essaye de quitter
                fenetreConfirmationQuitter = new FenetreConfirmationQuitter();
                fenetreConfirmationQuitter.addObservateur(this);
                fenetreInfo.setVisible(false);
                fenetreJeu.setVisible(false);
                break;

            case OUI_QUITTER: //Action de FenetreFin
                System.exit(0);
                break;

            case NON_RESTER:
                fenetreConfirmationQuitter.quitterFenetre();
                fenetreInfo.setVisible(true);
                fenetreJeu.setVisible(true);
                break;

            case TROP_CARTE:
                messageSauv = m;
                fenetreInfo.cliquableAssechement(false);
                fenetreInfo.cliquableDeplacer(false);
                fenetreInfo.cliquableDonner(false);
                fenetreInfo.cliquablePasser(false);
                fenetreInfo.cliquableTresor(false);
                fenetreInfo.cliquableUtiliser(true);
                fenetreInfo.cliquableDeplacementAutre(false);
                fenetreInfo.cliquableHelico(false);
                break;

            case LIRE_REGLES: {
                try {

                    java.awt.Desktop.getDesktop().open(new File("DossierImage/FenetreRegles/regles.pdf"));
                } catch (IOException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            break;

            case LIRE_INTERFACE: {
                try {
                    fenetreInterface = new FenetreInterface();
                } catch (IOException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fenetreInterface.addObservateur(this);
            break;

            case FERMER_INTERFACE:
                fenetreInterface.visible(false);
                break;

            case NOUVELLE_PARTIE:
                fenetreFin.visible(false);
                Controleur controleur = new Controleur();
                break;
        }
    }

    public void verifFinInondation(Tuile tuileCourante) {
        if (tuileCourante.getEtat().equals(Utils.EtatTuile.COULEE)) {
            if (tuileCourante.getNom().equals(NomTuile.Heliport)) { //si l'héliport sombre
                fenetreFin = new FenetreFin(false);
                fenetreFin.addObservateur(this);
                fenetreFin.setTextInfoJeu("\n Perdu ! L'héliport a sombré");
                fenetreJeu.setVisible(false);
                fenetreInfo.setVisible(false);
            } else if (tuileCourante.isTuileTresor()) { //si c'est une tuile trésor
                if (tresorsRecuperables.contains(tuileCourante.getCaseTresor())) { //si le trésor n'est pas encore recup
                    for (Tuile tuile : grille.getTuiles().values()) {
                        if (tuile.getNom() != null && tuile.isTuileTresor()) {
                           if (tuile.getCaseTresor().equals(tuileCourante.getCaseTresor()) && tuile.getEtat().equals(Utils.EtatTuile.COULEE) && !tuile.equals(tuileCourante)) { //si c'est le meme type trésor et c'est coulée mais pas la meme tuile
                                fenetreFin = new FenetreFin(false);
                                fenetreFin.addObservateur(this);
                                fenetreFin.setTextInfoJeu("\n Perdu ! Un des trésors est \n \n irrécupérable");

                                fenetreJeu.setVisible(false);
                                fenetreInfo.setVisible(false);
                            } 
                        }
                        
                    }
                }
            } else if (tuileCourante.isCaseOccupee()) { //si il y a quelqu'un sur le tuile
                for (Joueur joueur : tuileCourante.getJoueursTuile()) { //chaque joueur doit etre traité separrément
                    Aventurier role = joueur.getRole();
                    if (role.getRoleAventurier().equals("Pilote")) {// si c'est le pilote alors il peut utilisé l'hélico
                        ArrayList<Tuile> sauve = null;
                        sauve.addAll(grille.getTuilesAssechees().values());
                        sauve.addAll(grille.getTuilesInondees().values());
                        Collections.shuffle(sauve);
                        effectuerDeplacement(joueur, sauve.get(0));
                    } else {                        // si c'est pas un pilote alors on tente un déplacement normale
                        ArrayList<Tuile> sauve = new ArrayList<>();
                        sauve.addAll(joueur.getRole().getTuilesDeplacementPossible(grille).values());
                        if (sauve.isEmpty()) {      //si il n'a nulle part où aller
                            boolean aCarteHelico = false;
                            for (CarteOrange carte : joueur.getMainJoueur()) { //on regarde toutes les cartes
                                if (carte.getTypeClasse().equals("Helicopter")) { //verif si il a une carte helico
                                    aCarteHelico = true;
                                    defausserCarte(joueur, carte);
                                }
                            }
                            if (aCarteHelico) { //si il a une carte hélico
                                sauve.addAll(grille.getTuilesAssechees().values());
                                sauve.addAll(grille.getTuilesInondees().values());
                                Collections.shuffle(sauve);
                                effectuerDeplacement(joueur, sauve.get(0));
                            } else { //si il n'y a pas de carte hélico
                                fenetreFin = new FenetreFin(false);
                                fenetreFin.addObservateur(this);
                                fenetreFin.setTextInfoJeu("\n Perdu ! Un des joueurs coule");

                                fenetreJeu.setVisible(false);
                                fenetreInfo.setVisible(false);
                            }
                        } else {                    //si il peut fuir
                            Collections.shuffle(sauve);
                            effectuerDeplacement(joueur, sauve.get(0));
                        }
                    }
                }
            }
        }
    }

    public void verifDéfaiteNiveauEau() {
        if (getNiveauEau() == 9) {
            fenetreFin = new FenetreFin(false);
            fenetreFin.addObservateur(this);
            fenetreFin.setTextInfoJeu("\n Perdu ! Le niveau d'eau \n \n est trop élevé");

            fenetreJeu.setVisible(false);
            fenetreInfo.setVisible(false);
        }
    }

    public void verifVictoire() {
        if (tresorsRecuperables.isEmpty()) {
            for (Tuile uneTuile : tuiles.values()) {
                if (uneTuile.getNom().toString().equals("Héliport")) {
                    if (uneTuile.getJoueursTuile().size() == joueurs.size()) {
                        if (!toutNomAventurier.contains("Pilote")) {
                            // Victoire
                        } else {
                            for (Joueur unJoueur : joueurs) {
                                for (CarteOrange uneCarte : unJoueur.getMainJoueur()) {
                                    if (uneCarte.getTypeClasse().equals("Helicoptere")) {
                                        fenetreFin = new FenetreFin(true);
                                        fenetreFin.addObservateur(this);
                                        fenetreFin.setTextInfoJeu("\n Felicitaion, vous vous échappez de l'île");

                                        fenetreJeu.setVisible(false);
                                        fenetreInfo.setVisible(false);
                                    }
                                }

                            }
                        }
                    }
                }

            }
        }
    }

    public void commencerPiocheOrange() {
        if (isPiocherPossible() && nbCartePiocher <= 2) {
            fenetreInfo.cliquableBloque();
            if (isACarteSpe()) {
                fenetreInfo.cliquableUtiliser(true);
            }
        } else {
            inondation();
        }
    }

    public void inondation() {
        for (int i = 0; i < eauAPiocher(); i++) {
            if (avecInondation) {
                piocherInondation();
            }
        }
        transitionTour();
    }

    public void transitionTour() {
        joueurSuivant();
        nombreAction = 3;
        fenetreInfo.affichageAction(nombreAction);
        fenetreInfo.cliquableDefaut();
        fenetreInfo.setTextInfoJeu("\n  A vous de jouer " + joueurCourant.getNomJoueur() + " !\n\n  Choisissez une action parmi celles-ci \n  dessous:");
        fenetreInfo.modifierLabelJoueur(joueurCourant);
        fenetreJeu.setSurbrillanceDefault();
        nbCartePiocher = 0;

        if (joueurCourant.getRole().getNom().equals("Pilote")) {
            piloteSpe = true;
            fenetreInfo.boutonSpeciale(joueurCourant.getRole().getNom());
        }

        if (joueurCourant.getRole().getNom().equals("Ingenieur")) {
            IngeAssecherPossible = true;
        }

        try {
            FenetrePopupDebutTour fen = new FenetrePopupDebutTour(joueurCourant.getRole().getNom());
        } catch (IOException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (isTropDeCartes()) {
            Message m = new Message();
            m.type = TypesMessages.TROP_CARTE;
            messageSauv = m;
            fenetreInfo.setTextInfoJeu("\n" + joueurCourant.getNomJoueur() + " !\n  Vous avez trop de cartes \n défaussez-vous en");
            fenetreInfo.cliquableBloque();
            if (isACarteSpe()) {
                fenetreInfo.cliquableUtiliser(true);
            }
        }
    }
}
