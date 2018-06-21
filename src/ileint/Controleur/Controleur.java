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
import ileint.Carte.Speciale;
import ileint.Carte.Tresor;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
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
import view.FenetreDebut;
import view.FenetreInfo;
import view.FenetreJeu;
import view.FenetreJoueur;
import view.Observateur;

/**
 *
 * @author fodorg
 */
public class Controleur implements Observateur {

    private boolean hasard = false;

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
    private boolean partieTermine = false;
    private Joueur joueurCourant;
    private int nombreAction;
    private boolean piloteSpe;
    private Message messageSauv = null; // sauvegarde du message précédent dans le traiterMessage

    private FenetreDebut fenetreDebut;
    private FenetreJeu fenetreJeu;
    private FenetreInfo fenetreInfo;
    private FenetreJoueur fenetreJoueur;

    public Controleur() {
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
            piocheInondation.add(new CarteInondation(uneTuile, true));
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

        if (hasard) {
            for (int i = 0; i < 6; i++) {
                piocherInnondation();
            }
        }

        for (Joueur unJoueur : joueurs) {
            for (int i = 0; i < 2; i++) {
                unJoueur.addCarteMainJoueur(piocheOrange.get(0));
                piocheOrange.get(0).setEmplacementCarte(EmplacementCarte.MAINJOUEUR);
                piocheOrange.remove(piocheOrange.get(0));
            }
        }
        joueurCourant = joueurs.get(0);
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

    public void setPartieTermine(boolean partieTermine) {
        this.partieTermine = partieTermine;
    }

    public boolean isPartieTermine() {
        return partieTermine;
    }

    public boolean isTropDeCartes() {
        return joueurCourant.getMainJoueur().size() > 5;
    }

    public void piocherCarteOrange() {
        joueurCourant.addCarteMainJoueur(piocheOrange.peek());
        piocheOrange.peek().setEmplacementCarte(EmplacementCarte.MAINJOUEUR);
        piocheOrange.pop();
    }

    public void defausserCarte(Joueur joueur, CarteOrange carte) {
        defausseOrange.push(carte);
        joueur.getMainJoueur().remove(carte);
    }

    public void empilerDefausseInondation() {
        Collections.shuffle(defausseInondation);
        for (CarteInondation uneCarte : defausseInondation) {
            piocheInondation.push(uneCarte);
        }
        defausseInondation.clear();
    }

    public void melangerPiocheOrange(Stack<CarteOrange> defausseOrange) { //transforme et mélange la défausse orange en une nouvelle pioche
        if (piocheOrange.isEmpty()) {
            Collections.shuffle(defausseOrange);
            piocheOrange.addAll(defausseOrange);
            defausseOrange.clear();
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

    public void piocherInnondation() {
        for (Tuile uneTuile : grille.getTuiles().values()) {
            if (piocheInondation.peek().equals(uneTuile)) {
                uneTuile.arroserTuile();
                piocheInondation.peek().setPioche(false);
                defausseInondation.push(piocheInondation.pop());
//                piocheInondation.remove(piocheInondation.get(0));
            }
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
        joueur.setEmplacementJoueur(tuile);
        joueur.getEmplacementJoueur().getJoueursTuile().add(joueur);
    }

    public void effectuerAssechement(Tuile tuile) { // assèche effectivemment une tuile (ne vérifie rien)
        tuile.setEtat(Utils.EtatTuile.ASSECHEE);
    }

    public void effectuerDonCarte(Joueur donneur, Joueur receveur, CarteOrange carte) { // transfère effectivemment une carte (ne vérifie rien)
        donneur.getMainJoueur().remove(carte);
        receveur.getMainJoueur().add(carte);
    }

    public void effectuerRecuperationTresor(Tuile tuile, Joueur joueur) { // récupère effectivemment le trésor et retire les cartes correspondantes dans la main du joueur (ne vérifie pas si le joueur a bien les 4 cartes)
        TypeTresor tresorRecuperableCase = joueur.getEmplacementJoueur().getCaseTresor();
        int compteur = 0;

        for (CarteOrange uneCarteOrange : joueur.getMainJoueur()) { // récupère les 4 premières cartes trésor conrrespondantes            
            if (uneCarteOrange.getTypeTresor().equals(tresorRecuperableCase) && compteur != 4) {
                joueur.getMainJoueur().remove(uneCarteOrange);
                compteur++;
            }
        }
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
                    fenetreJeu = new FenetreJeu(joueurs, defausseOrange, defausseInondation);
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
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case ANNULER:
                //ihm.setSurbrillanceDefaut();
                break;

            case SE_DEPLACER: //le joueur clique sur se deplacer
                //ihm.setSurbrillance(joueurCourant.getRole().getTuilesDeplacementPossible(grille));
                messageSauv = m;
                break;

            case ASSECHER: //le joueur clique sur assecher
                //ihm.setSurbrillance(joueurCourant.getRole().getTuilesAssechables(grille));
                messageSauv = m;
                break;

            case CHOIX_TUILE:
                if (messageSauv.type == TypesMessages.SE_DEPLACER) {
                    effectuerDeplacement(joueurCourant, m.tuileSelectionne);
                    nombreAction--;
                } else if (messageSauv.type == TypesMessages.ASSECHER) {
                    effectuerAssechement(m.tuileSelectionne);
                    nombreAction--;
                } else if (messageSauv.type == TypesMessages.CHOIX_CARTE) {
                    if (messageSauv.carteSelectionne.getTypeClasse().equals("Helicoptere")) {
                        effectuerDeplacement(joueurCourant, m.tuileSelectionne);

                    } else if (messageSauv.carteSelectionne.getTypeClasse().equals("SacDeSable")) {
                        effectuerAssechement(m.tuileSelectionne);
                    }
                }
                if (nombreAction == 0) {
                    commencerPiocheOrange(); //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case DONNER_CARTE:
                //mettre en su-Brie-ence la main du joueur
                if (joueurCourant.getRole().getRoleAventurier() == "Messager") {
                    //mettre en Sue-bry-ance tout les joueurs
                } else {
                    //mettre en surbrillance les joueurs qui sont sur la même case
                }
                messageSauv = m;
                break;

            case PARAMETRE_DONNER_CARTE:
                effectuerDonCarte(joueurCourant, m.joueurVise, m.carteSelectionne);
                nombreAction--;
                if (nombreAction == 0) {
                    commencerPiocheOrange(); //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case PASSER_TOUR:
                //ihm.piochageCarteOrange(); //méthode qui fais apparaitre les widgets de piochage
                break;

            case RECUPERER_TRESOR:
                effectuerRecuperationTresor(m.tuileSelectionne, joueurCourant);
                nombreAction--;
                if (nombreAction == 0) {
                    commencerPiocheOrange(); //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case UTILISER_CARTE:
                messageSauv = m;
                //mise en surbrillance des cartes spé                
                break;
            case CHOIX_CARTE:
                if (m.carteSelectionne.getTypeClasse() == "Helicoptere") {
                    //ihm.setSurbrillance(joueurCourant.getRole().getTuileHelicoPossible(grille));
                    messageSauv = m;
                    messageSauv.type = TypesMessages.UTILISER_CARTE;
                } else if (m.carteSelectionne.getTypeClasse() == "SacDeSable") {
                    //ihm.setSurbrillance(joueurCourant.getRole().getTuilesAssechables(grille));
                    messageSauv = m;
                    messageSauv.type = TypesMessages.UTILISER_CARTE;
                }                
                break;

            //Piochage de cartes oranges à la fin du tour
            case PIOCHER_CARTE_ORANGE:
                piocherCarteOrange();
                break;   
        }

    }

    public void verifFinInondation(Tuile tuileCourante) {
        if (tuileCourante.getEtat().equals(Utils.EtatTuile.COULEE)) {
            if (tuileCourante.getNom().equals(NomTuile.Heliport)) { //si l'héliport sombre
                //fin partie car l'héliport a sombré//
            } else if (tuileCourante.isTuileTresor()) { //si c'est une tuile trésor
                if (tresorsRecuperables.contains(tuileCourante.getCaseTresor())) { //si le trésor n'est pas encore recup
                    for (Tuile tuile : tuiles.values()) {
                        if (tuile.getCaseTresor().equals(tuileCourante.getCaseTresor()) && tuile.getEtat().equals(Utils.EtatTuile.COULEE) && !tuile.equals(tuileCourante)) { //si c'est le meme type trésor et c'est coulée mais pas la meme tuile
                            //fin partie car un trésor pas récupérable//
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
                        ArrayList<Tuile> sauve = null;
                        sauve.addAll(joueur.getRole().getTuilesDeplacementPossible(grille).values());
                        if (sauve.isEmpty()) {      //si il n'a nulle part où aller
                            boolean aCarteHelico = false;
                            for (CarteOrange carte : joueur.getMainJoueur()) { //on regarde toutes les cartes
                                if (carte.getTypeClasse().equals("Helicopter")) { //verif si il a une carte helico
                                    aCarteHelico = true;
                                }
                            }
                            if (aCarteHelico) { //si il a une carte hélico
                                sauve.addAll(grille.getTuilesAssechees().values());
                                sauve.addAll(grille.getTuilesInondees().values());
                                Collections.shuffle(sauve);
                                effectuerDeplacement(joueur, sauve.get(0));
                            } else { //si il n'y a pas de carte hélico
                                //fin partie car un des joueur coule
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

    public void commencerPiocheOrange() {
        fenetreJeu.piocheCliquable(true);
    }
}
