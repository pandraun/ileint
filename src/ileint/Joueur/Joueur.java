package ileint.Joueur;

import ileint.Aventurier.Aventurier;
import ileint.Carte.CarteOrange;
import ileint.Controleur.Controleur;
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
    private Controleur controleur;
    private ArrayList<CarteOrange> mainJoueur;
    
    
    //Constructeur   
    public Joueur(int numeroJoueur, Controleur controleur, Aventurier role){
        this.numeroJoueur = numeroJoueur;
        this.controleur = controleur;
        this.role = role;
        
        emplacementJoueur = role.getTuileDepart();
        
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

    public Controleur getControleur() {
        return controleur;
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

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public void setMainJoueur(ArrayList<CarteOrange> mainJoueur) {
        this.mainJoueur = mainJoueur;
    }
    
    // nombre de cartes dans la main du joueur
    public int nbCartesJoueur(){
        return mainJoueur.size();
    }
   
    
    public void addCarteMainJoueur(CarteOrange carte){
        
    }

}
