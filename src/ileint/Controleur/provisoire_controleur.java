/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileint.Controleur;

import ileint.Carte.CarteOrange;
import util.Message;
import util.TypesMessages;
import util.Utils;

/**
 *
 * @author piolleta
 */
public class provisoire_controleur {

    Message messageSauv;

    public void traiterMessage(Message m) {

        switch (m.type) {
            case SE_DEPLACER:
//                for (Tuile tuile : getTuilesDeplacementPossible()){
//                    tuile.setEnabled(true);
//                    //les mettre en surbrillance (à faire dans l'ihm
//                }
                messageSauv = m;
                break;

            case ASSECHER:
//                for (Tuile tuile : getTuilesAssechables()){
//                    tuile.setEnabled(true);
//                    //les mettre en surbrillance (à faire dans l'ihm
//                }
                messageSauv = m;
                break;

            case DEMARRER:
                break;

            case ANNULER:
                break;

            case CHOIX_TUILE:
                if (messageSauv.type == TypesMessages.SE_DEPLACER) {
                    messageSauv.joueurCourant.setEmplacementJoueur(m.tuileSelectionne);
                    nombreAction--;
                } else if (messageSauv.type == TypesMessages.ASSECHER) {
                    m.tuileSelectionne.setEtat(Utils.EtatTuile.ASSECHEE);
                    nombreAction--;
                }
                if (nombreAction == 0) {
                    ihm.piochageCarteOrange; //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case DONNER_CARTE:
//                for (CarteOrange carte : m.joueurCourant.getMainJoueur()){
//                    carte.setEnabled(true);
//                    //les mettre en surbrillance (à faire dans l'ihm
//                }
                // mettre en surbrillance les joueurs qui sont sur la même case
                messageSauv = m;
                break;

            case PARAMETRE_DONNER_CARTE:
//                effecturerDonCarte(joueurCourant,message.joueurVise,message.carteSelectionne);
                nombreAction--;
                if (nombreAction == 0) {
                    ihm.piochageCarteOrange; //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case PASSER_TOUR:
                ihm.piochageCarteOrange; //méthode qui fais apparaitre les widgets de piochage
                break;

            case RECUPERER_TRESOR:
//                effectuerRecuperationJoueur(message.tuileSelectionne,joueurCourant);
                nombreAction--;
                if (nombreAction == 0) {
                    ihm.piochageCarteOrange; //méthode qui fais apparaitre les widgets de piochage
                }
                break;

            case UTILISER_CARTE:
                messageSauv = m;
                //mise en surbrillance des cartes spé                
                break;
            case CHOIX_CARTE:
                if (messageSauv.carteSelectionne.getTypeClasse() == "Helicoptere"){
                    //surbrillance                    
                } else if( messageSauv.carteSelectionne.getTypeClasse() == "Sac de sable")
                break;
        }

    }

}
