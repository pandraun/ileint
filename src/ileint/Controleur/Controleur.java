package ileint.Controleur;

import ileint.Aventurier.Aventurier;
import ileint.Carte.CarteInnondation;
import ileint.Carte.CarteOrange;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.NomTuile;
import ileint.Tuile.Tuile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import util.Utils;

/**
 *
 * @author fodorg
 */
public class Controleur {

    private int niveauEau;
    private ArrayList<CarteInnondation> piocheInnondation; // 0..24
    private ArrayList<CarteInnondation> defausseInnondation; // 0..24
    private ArrayList<CarteOrange> piocheOrange; //0..28
    private ArrayList<CarteOrange> defausseOrange; //0..28
    private ArrayList<Joueur> joueurs; //2..4
    private ArrayList<Aventurier> aventuriers; // Il y en a 6 de base et on peut en retirer max 4
    private Grille grille;

    public Controleur() {

        for (Joueur unjoueur : joueurs) {

            Collections.shuffle(aventuriers);
            unjoueur.setRole(aventuriers.get(1));
            aventuriers.remove(aventuriers.get(1));
        }

        Collections.shuffle(piocheInnondation);
        Collections.shuffle(piocheOrange);

        //Initialisation des tuiles à la main
        Tuile t00 = new Tuile(null, new Coordonnee(0, 0), null, null);
        Tuile t01 = new Tuile(null, new Coordonnee(0, 1), null, null);
        Tuile t02 = new Tuile(NomTuile.Le_Pont_des_Abimes, new Coordonnee(0, 2), Utils.EtatTuile.ASSECHEE, null);
        Tuile t03 = new Tuile(NomTuile.La_Porte_de_Bronze, new Coordonnee(0, 3), Utils.EtatTuile.INONDEE, null);
        Tuile t04 = new Tuile(null, new Coordonnee(0, 4), null, null);
        Tuile t05 = new Tuile(null, new Coordonnee(0, 5), null, null);
        Tuile t10 = new Tuile(null, new Coordonnee(1, 0), null, null);
        Tuile t11 = new Tuile(NomTuile.La_Caverne_des_Ombres, new Coordonnee(1, 1), Utils.EtatTuile.ASSECHEE, null);
        Tuile t12 = new Tuile(NomTuile.La_Porte_de_Fer, new Coordonnee(1, 2), Utils.EtatTuile.ASSECHEE, null);
        Tuile t13 = new Tuile(NomTuile.La_Porte_d_Or, new Coordonnee(1, 3), Utils.EtatTuile.ASSECHEE, null);
        Tuile t14 = new Tuile(NomTuile.Les_Falaises_de_l_Oubli, new Coordonnee(1, 4),  Utils.EtatTuile.ASSECHEE, null);
        Tuile t15 = new Tuile(null, new Coordonnee(1, 5), null, null);
        Tuile t20 = new Tuile(NomTuile.Le_Palais_de_Corail, new Coordonnee(2, 0), Utils.EtatTuile.ASSECHEE, null);
        Tuile t21 = new Tuile(NomTuile.La_Porte_d_Argent, new Coordonnee(2, 1), Utils.EtatTuile.ASSECHEE, null);
        Tuile t22 = new Tuile(NomTuile.Les_Dunes_de_l_Illusion, new Coordonnee(2, 2), Utils.EtatTuile.COULEE, null);
        Tuile t23 = new Tuile(NomTuile.Heliport, new Coordonnee(2, 3), Utils.EtatTuile.ASSECHEE, null);
        Tuile t24 = new Tuile(NomTuile.La_Porte_de_Cuivre, new Coordonnee(2, 4), Utils.EtatTuile.ASSECHEE, null);
        Tuile t25 = new Tuile(NomTuile.Le_Jardin_des_Hurlements, new Coordonnee(2, 5), Utils.EtatTuile.ASSECHEE, null);
        Tuile t30 = new Tuile(NomTuile.La_Foret_Pourpre, new Coordonnee(3, 0), Utils.EtatTuile.ASSECHEE, null);
        Tuile t31 = new Tuile(NomTuile.Le_Lagon_Perdu, new Coordonnee(3, 1), Utils.EtatTuile.INONDEE, null);
        Tuile t32 = new Tuile(NomTuile.Le_Marais_Brumeux, new Coordonnee(3, 2), Utils.EtatTuile.COULEE, null);
        Tuile t33 = new Tuile(NomTuile.Observatoire, new Coordonnee(3, 3), Utils.EtatTuile.INONDEE, null);
        Tuile t34 = new Tuile(NomTuile.Le_Rocher_Fantome, new Coordonnee(3, 4),Utils.EtatTuile.COULEE, null);
        Tuile t35 = new Tuile(NomTuile.La_Caverne_du_Brasier, new Coordonnee(3, 5), Utils.EtatTuile.INONDEE, null);
        Tuile t40 = new Tuile(null, new Coordonnee(4, 0), null, null);
        Tuile t41 = new Tuile(NomTuile.Le_Temple_du_Soleil, new Coordonnee(4, 1), Utils.EtatTuile.ASSECHEE, null);
        Tuile t42 = new Tuile(NomTuile.Le_Temple_de_La_Lune, new Coordonnee(4, 2), Utils.EtatTuile.COULEE, null);
        Tuile t43 = new Tuile(NomTuile.Le_Palais_des_Marees, new Coordonnee(4, 3), Utils.EtatTuile.ASSECHEE, null);
        Tuile t44 = new Tuile(NomTuile.Le_Val_du_Crepuscule, new Coordonnee(4, 4), Utils.EtatTuile.ASSECHEE, null);
        Tuile t45 = new Tuile(null, new Coordonnee(4, 5), null, null);
        Tuile t50 = new Tuile(null, new Coordonnee(5, 0), null, null);
        Tuile t51 = new Tuile(null, new Coordonnee(5, 1), null, null);
        Tuile t52 = new Tuile(NomTuile.La_Tour_du_Guet, new Coordonnee(5, 2), Utils.EtatTuile.ASSECHEE, null);
        Tuile t53 = new Tuile(NomTuile.Le_Jardin_des_Murmures, new Coordonnee(5, 3), Utils.EtatTuile.INONDEE, null);
        Tuile t54 = new Tuile(null, new Coordonnee(5, 4), null, null);
        Tuile t55 = new Tuile(null, new Coordonnee(5, 5), null, null);

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

}
