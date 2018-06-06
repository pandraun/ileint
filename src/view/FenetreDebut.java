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
    private JFrame fenetre; 
    private JPanel nbJoueurBTF;
    
    private JLabel LabelJoueur;
    private JButton moins;
    private JButton plus;
    private JTextField nbJoueurs;
    private JButton demarrer;
    
    public FenetreDebut() {
        fenetre = new JFrame("Choix du nombre de joueurs");
        fenetre.setSize(300, 100);
        fenetre.setLocationRelativeTo(null);
        
        setContentPane(new AfficheImage("C:\\impress2.gif"));
        getContentPane().setLayout(new BorderLayout()); 
        
        nbJoueurBTF = new JPanel();
        
        /* Composants pour choisir le joueur qui commence la partie */
        moins = new JButton("<");
        moins.setFont(new Font("Arial", Font.BOLD, 15));
        nbJoueurs = new JTextField("2");
        nbJoueurs.setHorizontalAlignment(JTextField.CENTER);;
        nbJoueurs.setFont(new Font("Arial", Font.BOLD, 15));
        plus = new JButton(">");
        plus.setFont(new Font("Arial", Font.BOLD, 15));
        demarrer = new JButton("Demarrer partie");
        
        
        /* Placement des composants */
        fenetre.setLayout(new GridLayout(2,1));
        nbJoueurBTF.setLayout(new GridLayout(1,3));
        fenetre.add(nbJoueurBTF);
        nbJoueurBTF.add(moins);
        nbJoueurBTF.add(nbJoueurs);
        nbJoueurBTF.add(plus);
        
        fenetre.add(demarrer);
        
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
            
        fenetre.setVisible(true);
        
        
    }
    
    public void AfficheImage(String s){
        
    }
    
    public static void main(String [] args) {
        // Instanciation de la fenêtre 
        FenetreDebut f = new FenetreDebut();
    }
    
}
