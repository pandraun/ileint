/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ileint.Aventurier.Aventurier;
import ileint.Aventurier.Navigateur;
import ileint.Grille.Grille;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.Tuile;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.relation.Role;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mazzolec
 */
public class FenetrePopupDebutTour extends Observe {
    private final JFrame window; 
    private final JPanel mainPanel;
    private final JButton btnOk;
    private JLabel contentPane;
    
    public FenetrePopupDebutTour(String role) {
        window = new JFrame();
        contentPane = new JLabel();
        
        /*if (role.equals("Pilote")) {
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourPilo.png"));
        } else if(role.equals("Explorateur")) {
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourExplo.png"));
        } else if(role.equals("Ingénieur")) {
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourIngé.png"));
        } else if(role.equals("Messager")) {
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourMessager.png"));
        } else if(role.equals("Plongeur")) {
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourPlong.png"));
        } else if(role.equals("Navigateur")) {*/
            contentPane.setIcon( new ImageIcon("DossierImage/imgCarteInondation.Nouveau dossier/tourNavigateur.png"));
        //}
        window.setContentPane(contentPane);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        
        btnOk = new JButton("Compris");
        btnOk.setOpaque(false);
        mainPanel.add(btnOk,BorderLayout.SOUTH);
        
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("appui bouton");
            }
        });
        window.add(mainPanel);
        window.setSize(500,800);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        FenetrePopupDebutTour fen = new FenetrePopupDebutTour("Navigateur");
    }
}

