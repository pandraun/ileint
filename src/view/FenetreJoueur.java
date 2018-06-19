/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.Message;
import util.TypesMessages;

/**
 *
 * @author pandraun
 */
public class FenetreJoueur extends Observe{
    private JFrame fenetre;
    private final JButton demarrer;
    
    public FenetreJoueur(int nbJoueurs){
        if (nbJoueurs == 2){
           fenetre = new JFrame("Fenetre Debut");
            fenetre.setSize(400, 400);
            fenetre.setLocationRelativeTo(fenetre);

            JPanel mainPanel = new JPanel(new GridLayout(9,1));
            for(int i=2; i<5; i++){
                switch(i){
                    case 2:
                    case 4:
                        JLabel joueur = new JLabel("Joueur"+i/2);
                        fenetre.add(joueur);
                        break;
                    case 3:
                        JTextField nomJoueur1 = new JTextField();
                        fenetre.add(nomJoueur1);
                        break;
                    case 5:
                        JTextField nomJoueur2 = new JTextField();
                        fenetre.add(nomJoueur2);
                        break;
                }
            } 
        } else if(nbJoueurs==3){
            fenetre = new JFrame("Fenetre Debut");
        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(fenetre);
       
        JPanel mainPanel = new JPanel(new GridLayout(9,1));
        for(int i=2; i<10; i++){
            switch(i){
                case 2:
                case 4:
                case 6:
                    JLabel joueur = new JLabel("Joueur"+i/2);
                    fenetre.add(joueur);
                    break;
                case 3:
                    JTextField nomJoueur1 = new JTextField();
                    fenetre.add(nomJoueur1);
                    break;
                case 5:
                    JTextField nomJoueur2 = new JTextField();
                    fenetre.add(nomJoueur2);
                    break;
                case 7:
                    JTextField nomJoueur3 = new JTextField();
                    fenetre.add(nomJoueur3);
                    break;
            }
        }
        } else{
           fenetre = new JFrame("Fenetre Debut");
        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(fenetre);
       
        JPanel mainPanel = new JPanel(new GridLayout(9,1));
        for(int i=2; i<10; i++){
            switch(i){
                case 2:
                case 4:
                case 6:
                case 8:
                    JLabel joueur = new JLabel("Joueur"+i/2);
                    fenetre.add(joueur);
                    break;
                case 3:
                    JTextField nomJoueur1 = new JTextField();
                    fenetre.add(nomJoueur1);
                    break;
                case 5:
                    JTextField nomJoueur2 = new JTextField();
                    fenetre.add(nomJoueur2);
                    break;
                case 7:
                    JTextField nomJoueur3 = new JTextField();
                    fenetre.add(nomJoueur3);
                    break;
                case 9:
                    JTextField nomJoueur4 = new JTextField();
                    fenetre.add(nomJoueur4);
                    break;
                    
            }
        } 
        }
        
        
        demarrer = new JButton("Démarrer la partie");
        demarrer.setFont(new Font("Arial", Font.BOLD, 30));
        fenetre.add(demarrer);
        
        demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                notifierObservateur(m);
                
                
                /*try {
                    FenetreJeu FJ = new FenetreJeu();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FenetreDebut.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                /*if (Integer.parseInt(nbJoueurs.getText())>=2){
                    VueAventurier V1 = new VueAventurier("Audrey", "Explorateur",Utils.Pion.VERT.getCouleur());
                    nbJ+=1;
                    VueAventurier V2 = new VueAventurier("Gergely", "Navigateur",Utils.Pion.JAUNE.getCouleur());
                    if (Integer.parseInt(nbJoueurs.getText())>=3){
                        nbJ+=1;
                        VueAventurier V3 = new VueAventurier("Camille", "Pilote",Utils.Pion.BLEU.getCouleur());
                        if (Integer.parseInt(nbJoueurs.getText())==4){
                            nbJ+=1;
                            VueAventurier V4 = new VueAventurier("Nicolas", "Ingenieur",Utils.Pion.ROUGE.getCouleur());
                }}}*/
            }    
        });
        
        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
