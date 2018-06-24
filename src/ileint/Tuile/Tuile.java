package ileint.Tuile;

import ileint.Joueur.Joueur;
import java.util.HashSet;
import util.TypeTresor;
import util.Utils.EtatTuile;

/**
 *
 * @author fodorg
 */
public class Tuile {

    private NomTuile nom;
    private Coordonnee coordonnee;
    private EtatTuile etat;
    private TypeTresor caseTresor;
    private HashSet<Joueur> joueursTuile;
    
    public Tuile(){
        joueursTuile = new HashSet<>();
    }

    public Tuile(NomTuile nom, Coordonnee coordonnee, EtatTuile etat) {
        setNom(nom);
        setCoordonnee(coordonnee);
        setEtat(etat);
        this.joueursTuile = new HashSet<>();
        setCaseTresor(null);
    }

    public Tuile(NomTuile nom, Coordonnee coordonnee, EtatTuile etat, TypeTresor caseTresor) {
        setNom(nom);
        setCoordonnee(coordonnee);
        setEtat(etat);
        this.joueursTuile = new HashSet<>();
        setCaseTresor(caseTresor);
    }

    //      Faire un constructeur avec la pos de départ de l'aventurier ???
    //      Non comme ça on crée les tuiles avant les aventuriers
    public boolean isTuileTresor() {       // retourne vrai si la carte possède un trésor
        if (this.caseTresor != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCaseOccupee() {
        if (joueursTuile.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

//    public Tuile getTuileAtPosition(Coordonnee coord) {
//        return  
//    } 
    //-------------------------------- GETTERS SETTERS --------------------------------------------
    /**
     * @return the nom
     */
    public NomTuile getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(NomTuile nom) {
        this.nom = nom;
    }

    /**
     * @return the coordonnee
     */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    /**
     * @param coordonnee the coordonnee to set
     */
    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    /**
     * @return the etat
     */
    public EtatTuile getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    /**
     * @return the caseTresor
     */
    public TypeTresor getCaseTresor() {
        return caseTresor;
    }

    /**
     * @param caseTresor the caseTresor to set
     */
    public void setCaseTresor(TypeTresor caseTresor) {
        this.caseTresor = caseTresor;
    }

    /**
     * @return the joueursTuile
     */
    public HashSet<Joueur> getJoueursTuile() {
        return joueursTuile;
    }

    /**
     * @param joueursTuile the joueursTuile to set
     */
    public void setJoueursTuile(HashSet<Joueur> joueursTuile) {
        this.joueursTuile = joueursTuile;
    }

    public void arroserTuile() {
        if (getEtat() == EtatTuile.ASSECHEE) {
            setEtat(EtatTuile.INONDEE);
        } else {
            setEtat(EtatTuile.COULEE);

        }
    }

}
