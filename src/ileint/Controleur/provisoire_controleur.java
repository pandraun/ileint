/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileint.Controleur;

import util.Message;
import util.TypesMessages;

/**
 *
 * @author piolleta
 */
public class provisoire_controleur {

    Message messageSauvegarde;
    
    public void traiterMessage(Message m) {

        messageSauvegarde = m;
        
        switch (m.type) {
            case SE_DEPLACER:
                
                break;
            case ASSECHER:
                break;
            case DEMARRER:
                break;
            case ANNULER:
                break;
            case CHOIX_CARTE:
                break;
            case CHOIX_TUILE:
                break;
            case DONNER_CARTE:
                break;
            case PARAMETRE_DONNER_CARTE:
                break;
            case PASSER_TOUR:
                break;
            case RECUPERER_TRESOR:
                break;
            case UTILISER_CARTE:
                break;
        }

    }

}
