/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ileint.Carte.CarteOrange;
import ileint.Joueur.Joueur;
import ileint.Tuile.Tuile;

/**
 *
 * @author piolleta
 */
public class Message {
    
    public TypesMessages type;
        
    public String nbJoueur;  //utiliser en début de partie pour avoir le nombre de joueur
    public int difficulté;   //valeur du slider
    
    public Joueur joueurVise;             //utiliser pour donner des cartes    
    public CarteOrange carteSelectionne;  //utiliser pour donner des cartes
    
    public Tuile tuileSelectionne;   //utiliser à tout moments lorsqu'une tuile est selectionée
    
    //nom des joueur
    public String joueur1;
    public String joueur2;
    public String joueur3;
    public String joueur4;
    
}
