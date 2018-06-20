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
public class FenetreJoueur extends Observe {

    private JFrame fenetre;
    private final JButton demarrer;
    private JPanel mainPanel;
    private JTextField nomJoueur1;
    private JTextField nomJoueur2;
    private JTextField nomJoueur3;
    private JTextField nomJoueur4;

    public FenetreJoueur(int nbJoueurs) {
        if (nbJoueurs == 2) {
            fenetre = new JFrame("Fenetre Joueur");
            fenetre.setSize(400, 400);
            fenetre.setLocationRelativeTo(fenetre);

            mainPanel = new JPanel(new GridLayout(5, 1));
            for (int i = 2; i < 6; i++) {
                switch (i) {
                    case 2:
                    case 4:
                        JLabel joueur = new JLabel("Joueur" + i / 2);
                        mainPanel.add(joueur);
                        break;
                    case 3:
                        nomJoueur1 = new JTextField();
                        mainPanel.add(nomJoueur1);
                        break;
                    case 5:
                        nomJoueur2 = new JTextField();
                        mainPanel.add(nomJoueur2);
                        break;
                }
            }
            
            demarrer = new JButton("Démarrer la partie");
            demarrer.setFont(new Font("Arial", Font.BOLD, 30));
            mainPanel.add(demarrer);

            demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                m.joueur1 = nomJoueur1.getText();
                m.joueur2 = nomJoueur2.getText();
                notifierObservateur(m);
            }
        });

        } else if (nbJoueurs == 3) {
            fenetre = new JFrame("Fenetre Debut");
            fenetre.setSize(400, 400);
            fenetre.setLocationRelativeTo(fenetre);

            mainPanel = new JPanel(new GridLayout(7, 1));
            for (int i = 2; i < 8; i++) {
                switch (i) {
                    case 2:
                    case 4:
                    case 6:
                        JLabel joueur = new JLabel("Joueur" + i / 2);
                        mainPanel.add(joueur);
                        break;
                    case 3:
                        nomJoueur1 = new JTextField();
                        mainPanel.add(nomJoueur1);
                        break;
                    case 5:
                        nomJoueur2 = new JTextField();
                        mainPanel.add(nomJoueur2);
                        break;
                    case 7:
                        nomJoueur3 = new JTextField();
                        mainPanel.add(nomJoueur3);
                        break;
                }
            }
            
        demarrer = new JButton("Démarrer la partie");
        demarrer.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(demarrer);

        demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                m.joueur1 = nomJoueur1.getText();
                m.joueur2 = nomJoueur2.getText();
                m.joueur3 = nomJoueur3.getText();
                notifierObservateur(m);

            }
        });

        } else {
            fenetre = new JFrame("Fenetre Debut");
            fenetre.setSize(400, 400);
            fenetre.setLocationRelativeTo(fenetre);

            mainPanel = new JPanel(new GridLayout(9, 1));
            for (int i = 2; i < 10; i++) {
                switch (i) {
                    case 2:
                    case 4:
                    case 6:
                    case 8:
                        JLabel joueur = new JLabel("Joueur" + i / 2);
                        mainPanel.add(joueur);
                        break;
                    case 3:
                        nomJoueur1 = new JTextField();
                        mainPanel.add(nomJoueur1);
                        break;
                    case 5:
                        nomJoueur2 = new JTextField();
                        mainPanel.add(nomJoueur2);
                        break;
                    case 7:
                        nomJoueur3 = new JTextField();
                        mainPanel.add(nomJoueur3);
                        break;
                    case 9:
                        nomJoueur4 = new JTextField();
                        mainPanel.add(nomJoueur4);
                        break;
                }
            }

        demarrer = new JButton("Démarrer la partie");
        demarrer.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(demarrer);
            
        demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                m.joueur1 = nomJoueur1.getText();
                m.joueur2 = nomJoueur2.getText();
                m.joueur3 = nomJoueur3.getText();
                m.joueur4 = nomJoueur4.getText();
                System.out.println("debug");
                notifierObservateur(m);

            }
        });
        
        }
        fenetre.add(mainPanel);

        

        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
