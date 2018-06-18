/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Utils;

/**
 *
 * @author pandraun
 */
public class FenetreJeu {
    private JFrame window;
    private JPanel grille;
    private JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
    private JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
    private JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
    private JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));
    
    
    
    
    public FenetreJeu() throws MalformedURLException{
        
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        
        this.window = new JFrame();
        window.setSize(width, height);
        
        window.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //======================================//
        
        JPanel role1 = new JPanel();
        role1.setLayout(new BoxLayout(role1, BoxLayout.Y_AXIS));
        JButton boutonRole1 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
        role1.add(boutonRole1);
        boutonRole1.setPreferredSize(new Dimension(150,210));
        JLabel EmplacementRole1 = new JLabel("Emplacement");
        role1.add(EmplacementRole1);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 0;
        window.add(role1,c);

        //--------------------------//
        
        
        
        
        
        //======================================//

        JPanel role2 = new JPanel();
        role2.setLayout(new BoxLayout(role2, BoxLayout.Y_AXIS));
        JButton boutonRole2 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/navigateur.png")));
        role2.add(boutonRole2);
        boutonRole2.setPreferredSize(new Dimension(150,210));
        JLabel EmplacementRole2 = new JLabel("Emplacement");
        role2.add(EmplacementRole2);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 0;
        window.add(role2,c);

        //--------------------------//
        
        
        
        
        
        //======================================//
        
        
        JPanel tresor = new JPanel(new GridLayout(2,2));
        caliceAbsent.setPreferredSize(new Dimension(40,100));
        tresor.add(caliceAbsent);
        cristalAbsent.setPreferredSize(new Dimension(40,100));
        tresor.add(cristalAbsent);
        pierreAbsent.setPreferredSize(new Dimension(40,100));
        tresor.add(pierreAbsent);
        statueAbsent.setPreferredSize(new Dimension(40,100));
        tresor.add(statueAbsent);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 2;
        window.add(tresor,c);
        
        
        //======================================//

        
        JPanel role3 = new JPanel();
        role3.setLayout(new BoxLayout(role3, BoxLayout.Y_AXIS));
        JLabel EmplacementRole3 = new JLabel("Emplacement");
        role3.add(EmplacementRole3);
        JButton boutonRole3 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/ingenieur.png")));
        role3.add(boutonRole3);
        boutonRole3.setPreferredSize(new Dimension(150,210));
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 4;
        window.add(role3,c);

        //--------------------------//
        
        
        
        
        
        //======================================//

        JPanel role4 = new JPanel();
        role4.setLayout(new BoxLayout(role4, BoxLayout.Y_AXIS));
        JLabel EmplacementRole4 = new JLabel("Emplacement");
        role4.add(EmplacementRole4);
        JButton boutonRole4 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/pilote.png")));
        role4.add(boutonRole4);
        boutonRole4.setPreferredSize(new Dimension(150,210));
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 4;
        window.add(role4,c);

        //--------------------------//
        
        
        
        
        
        //======================================//

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        
        grille = new JPanel(new GridLayout(6,6,10,10));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridheight = 6;
        c.gridwidth = 6;
        c.gridx = 1;
        c.gridy = 1;
        window.add(grille,c);
        
        for(int i = 0; i < 36; i++){
            switch (i){
                case 0:
                    JPanel Cartej11 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej11.add(new JButton());
                    }
                    grille.add(Cartej11);
                    break;
                case 1:
                    JPanel Cartej12 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 0:
                            case 1:
                            case 3:
                                Cartej12.add(new JButton());
                                break;
                            default:
                                Cartej12.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej12);
                    }
                    break;
                case 4:
                    JPanel Cartej21 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 1:
                            case 2:
                            case 5:
                                Cartej21.add(new JButton());
                                break;
                            default:
                                Cartej21.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej21);
                    }
                    break;
                case 5:
                    JPanel Cartej22 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej22.add(new JButton());
                    }
                    grille.add(Cartej22);
                    break;
                case 30:
                    JPanel Cartej31 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej31.add(new JButton());
                    }
                    grille.add(Cartej31);
                    break;
                case 31:
                    JPanel Cartej32 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 0:
                            case 3:
                            case 4:
                                Cartej32.add(new JButton());
                                break;
                            default:
                                Cartej32.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej32);
                    }
                    break;
                case 34:
                    JPanel Cartej41 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 2:
                            case 4:
                            case 5:
                                Cartej41.add(new JButton());
                                break;
                            default:
                                Cartej41.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej41);
                    }
                    break;
                case 35:
                    JPanel Cartej42 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej42.add(new JButton());
                    }
                    grille.add(Cartej42);
                    break;
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 32:
                case 33:
                    JButton tuile = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tuiles/Heliport.png")));
                    tuile.setPreferredSize(new Dimension(120,120));
                    grille.add(tuile);
                    System.out.println(height/6);
                    System.out.println(width/8);
                    break;
                default:
                    JPanel caseVide = new JPanel();
                    grille.add(caseVide);
                    break;
                }
            
        }
        window.pack();
        window.setVisible(true);
    }
}
