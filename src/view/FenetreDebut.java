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
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import util.Message;
import util.TypesMessages;
import util.Utils;

/**
 *
 * @author pandraun
 */
public class FenetreDebut  extends Observe {
    private final JFrame fenetre; 
    private final JPanel mainPanel;
    private final JPanel niveauEau;
    private final JPanel nbJoueurBTF;
    
    private JLabel LabelJoueur;
    private final JButton moins;
    private final JButton plus;
    private JTextField nbJoueurs;
    private final JButton continuer;
    public static int nbJ = 0;
    
    public FenetreDebut() throws MalformedURLException {
        fenetre = new JFrame("Fenetre Debut");
        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(fenetre);
        
        mainPanel = new JPanel();
        nbJoueurBTF = new JPanel();
        
        /* Composants de la partie */
        
        JLabel ileInterdite = new JLabel( new ImageIcon( new URL( "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwR0FAcHRchd6Nv221nWtgEsegeuzmnSukXSSWUVru8S_gtyIDUg" ) ) );
                
        moins = new JButton("<");
        moins.setFont(new Font("Arial", Font.BOLD, 45));
        nbJoueurs = new JTextField("2");
        nbJoueurs.setHorizontalAlignment(JTextField.CENTER);;
        nbJoueurs.setFont(new Font("Arial", Font.BOLD, 45));
        nbJoueurs.setEditable(false);
        plus = new JButton(">");
        plus.setFont(new Font("Arial", Font.BOLD, 45));
        continuer = new JButton("Continuer");
        continuer.setFont(new Font("Arial", Font.BOLD, 30));
        
        /* Placement des composants */
        fenetre.setLayout(new GridLayout(3,1));
        fenetre.getContentPane().add( ileInterdite );
        
        niveauEau = new JPanel(new GridLayout(3,1));
        fenetre.add(niveauEau);
        JLabel choixNiveau = new JLabel("Niveau d'eau :");
        choixNiveau.setFont(new Font("Arial", Font.BOLD, 30));
        choixNiveau.setHorizontalAlignment(0);
        niveauEau.add(choixNiveau);
        JSlider niveau = new JSlider(JSlider.HORIZONTAL,2, 10, 2);
        niveau.setMinorTickSpacing(1);
        niveau.setMajorTickSpacing(2);
        niveau.setPaintLabels(true);
        niveau.setPaintTicks(true);
        niveauEau.add(niveau);
        
        Hashtable labelTable = new Hashtable();
        labelTable.put( 2, new JLabel("2") );
        labelTable.put( 4, new JLabel("3") );
        labelTable.put( 6, new JLabel("4") );
        labelTable.put( 8, new JLabel("5") );
        labelTable.put( 10, new JLabel("6") );
        niveau.setLabelTable( labelTable );
        niveau.setPaintLabels(true);
        
        JLabel choixNbJoueur = new JLabel("Nombre de Joueur :");
        choixNbJoueur.setFont(new Font("Arial", Font.BOLD, 30));
        choixNbJoueur.setHorizontalAlignment(0);
        niveauEau.add(choixNbJoueur);
        

        nbJoueurBTF.setLayout(new GridLayout(1,3));
        fenetre.add(mainPanel);
        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(nbJoueurBTF);
        nbJoueurBTF.add(moins);
        nbJoueurBTF.add(nbJoueurs);
        nbJoueurBTF.add(plus);
        
        mainPanel.add(continuer);
        
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
        
        continuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                Message m = new Message();
                m.type = TypesMessages.CONTINUER;
                m.nbJoueur = nbJoueurs.getText();
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
    // LE MAIN EST DESORMAIS DANS ILEINT
    /*public static void main(String [] args) throws MalformedURLException {
        // Instanciation de la fenêtre 
        FenetreDebut f = new FenetreDebut();
    }*/
    
}
