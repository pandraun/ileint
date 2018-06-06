/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pandraun
 */
public class FenetreDebut  extends JFrame {
    private final JFrame fenetre; 
    private final JPanel mainPanel;
    private final JPanel nbJoueurBTF;
    
    private JLabel LabelJoueur;
    private final JButton moins;
    private final JButton plus;
    private JTextField nbJoueurs;
    private final JButton demarrer;
    
    public FenetreDebut() throws MalformedURLException {
        fenetre = new JFrame("Choix du nombre de joueurs");
        fenetre.setSize(700, 400);
        fenetre.setLocationRelativeTo(null);
        
        mainPanel = new JPanel();
        nbJoueurBTF = new JPanel();
        
        /* Composants de la partie */
        
        JLabel ileInterdite = new JLabel( new ImageIcon( new URL( "http://s.scifi-universe.com/critiques/images-old/ileinterdite_bf_01.jpg" ) ) );
                
        moins = new JButton("<");
        moins.setFont(new Font("Arial", Font.BOLD, 45));
        nbJoueurs = new JTextField("2");
        nbJoueurs.setHorizontalAlignment(JTextField.CENTER);;
        nbJoueurs.setFont(new Font("Arial", Font.BOLD, 45));
        nbJoueurs.setEditable(false);
        plus = new JButton(">");
        plus.setFont(new Font("Arial", Font.BOLD, 45));
        demarrer = new JButton("Démarrer la partie");
        demarrer.setFont(new Font("Arial", Font.BOLD, 30));
        
        /* Placement des composants */
        fenetre.setLayout(new GridLayout(2,1));
        fenetre.getContentPane().add( ileInterdite );

        nbJoueurBTF.setLayout(new GridLayout(1,3));
        fenetre.add(mainPanel);
        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(nbJoueurBTF);
        nbJoueurBTF.add(moins);
        nbJoueurBTF.add(nbJoueurs);
        nbJoueurBTF.add(plus);
        
        mainPanel.add(demarrer);
        
        moins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(nbJoueurs.getText())==3) {
                    nbJoueurs.setText("2");
                } else if (Integer.parseInt(nbJoueurs.getText())==4) {
                    nbJoueurs.setText("3");
                }
            }
            
        });
        
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(nbJoueurs.getText())==2) {
                    nbJoueurs.setText("3");
                } else if (Integer.parseInt(nbJoueurs.getText())==3) {
                    nbJoueurs.setText("4");
                }
            }
            
        });
        
        demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
              
                
            }    
        });
            
        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setVisible(true);
        
        
    }
    
    public static void main(String [] args) throws MalformedURLException {
        // Instanciation de la fenêtre 
        FenetreDebut f = new FenetreDebut();
    }
    
}
