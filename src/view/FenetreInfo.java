/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pandraun
 */
public class FenetreInfo {
    private JFrame window;
    private JPanel mainPanel;
    
    private JPanel infoPanel;
    private JPanel boutonPanel;
    private JPanel accessoirePanel;
    
    public FenetreInfo(){
        
        //Fenetre principale
        window = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight() - 869;
        int width  = (int)dimension.getWidth() -1090;
        window.setSize(width, height);
        
        //Lire règle + info jeu + role
        infoPanel = new JPanel(new BorderLayout());
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        
        JPanel reglesPanel = new JPanel(new BorderLayout());
        infoPanel.add(reglesPanel, BorderLayout.NORTH);
        
        JButton btnRegles = new JButton("Lire Règle");
        reglesPanel.add(btnRegles, BorderLayout.EAST);
        
        JPanel panelInfoJeu = new JPanel();
        JLabel labelInfoJeu = new JLabel("ryhujklmj,oi");
        
        panelInfoJeu.add(labelInfoJeu);
        infoPanel.add(panelInfoJeu);
        
//        private JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
//    private JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
//    private JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
//    private JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
//    private JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
//    private JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
//    private JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
//    private JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));
//    
//    xt("Donner carte");
//                        btnDonner.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                Message m = new Message();
//                                m.type = TypesMessages.DONNER_CARTE;
//                                //notifierObservateur(m);
//                            }
//                        });
//                           
//                        JButton btnTresor = new JButton();
//                        panelBoutonRole1.add(btnTresor);
//                        btnTresor.setPreferredSize(new Dimension(40,20));
//                        btnTresor.setText("Recuperer tresor");
//                        btnTresor.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                Message m = new Message();
//                                m.type = TypesMessages.RECUPERER_TRESOR;
//                                //notifierObservateur(m);
//                            }
//                        });
//                              
//                        JButton btnUtiliserCarte = new JButton();
//                        panelBoutonRole1.add(btnUtiliserCarte);
//                        btnUtiliserCarte.setPreferredSize(new Dimension(40,20));
//                        btnUtiliserCarte.setText("Utiliser carte");
//                        btnUtiliserCarte.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                Message m = new Message();
//                                m.type = TypesMessages.SE_DEPLACER;
//                                //notifierObservateur(m);
//                            }
//                        });
//                            
//                        JButton btnAutre = new JButton();
//                        panelBoutonRole1.add(btnAutre);
//                        btnAutre.setPreferredSize(new Dimension(40,20));
//                        btnAutre.setText("Autre");
//
//                        JLabel nbActionRole1 = new JLabel("Action restante");
//                        
//                    role1.add(panelBoutonRole1);
//                    role1.add(nbActionRole1);*/       
//    }

        window.setVisible(true);
    }
    
    public static void main(String [] args) throws MalformedURLException {
        // Instanciation de la fenêtre 
        FenetreInfo f = new FenetreInfo();
        
    }
}
