package ileint.Joueur;

import ileint.Aventurier.Aventurier;
import ileint.Carte.CarteOrange;
import ileint.Tuile.Tuile;
import java.util.ArrayList;

/**
 *
 * @author fodorg
 */
public class Joueur {

    private int numeroJoueur;
    private Aventurier role;
    private Tuile emplacementJoueur;
    private ArrayList<CarteOrange> mainJoueur;
    
   

    //Constructeur   
    public Joueur(int numeroJoueur, Aventurier role) {
        this.numeroJoueur = numeroJoueur;
        this.role = role;

        emplacementJoueur = role.getTuileDepart();
        
        mainJoueur = new ArrayList<>();

    }
    
    public Joueur(int numeroJoueur){
        this.numeroJoueur = numeroJoueur;
        
        mainJoueur = new ArrayList<>();
    }

    //Getters
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public Aventurier getRole() {
        return role;
    }

    public Tuile getEmplacementJoueur() {
        return emplacementJoueur;
    }

    public ArrayList<CarteOrange> getMainJoueur() {
        return mainJoueur;
    }

    //Setters
    public void setNumeroJoueur(int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    public void setRole(Aventurier role) {
        this.role = role;
    }

    public void setEmplacementJoueur(Tuile emplacementJoueur) {
        this.emplacementJoueur = emplacementJoueur;

    }

    public void setMainJoueur(ArrayList<CarteOrange> mainJoueur) {
        this.mainJoueur = mainJoueur;
    }

    // nombre de cartes dans la main du joueur
    public int nbCartesJoueur() {
        return mainJoueur.size();
    }

    //ajouter carte dans main joueur
    public void addCarteMainJoueur(CarteOrange carte) {

        mainJoueur.add(carte);
    }

    //supprimer carte dans main joueur
    public void removeCarteMainJoueur(CarteOrange carte) {
        mainJoueur.remove(carte);
    }

}
