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
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;
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
    
    public FenetreJeu() throws MalformedURLException{
        
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        
        this.window = new JFrame();
        window.setSize(width, height);
        window.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int j = 0;
        for(int i = 0; i < 48; i++){
            if (i%8==0){
                j+=1;
            }
            switch (i){
                case 0:
                    JButton role = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
                    role.setPreferredSize(new Dimension(150,210));                    
                    c.anchor = GridBagConstraints.FIRST_LINE_START;
                    c.gridheight = 2;
                    c.gridx = i%8;
                    c.gridy = j;
                    window.add(role, c);
                    break;
                case 7:
                    JButton role2 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
                    role2.setPreferredSize(new Dimension(150,210));                    
                    c.anchor = GridBagConstraints.FIRST_LINE_END;
                    c.gridheight = 2;
                    c.gridx = i%8;
                    c.gridy = j;
                    window.add(role2, c);
                    break;
                case 32:
                    JButton role3 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
                    role3.setPreferredSize(new Dimension(150,210));                    
                    c.anchor = GridBagConstraints.LAST_LINE_START;
                    c.gridheight = 2;
                    c.gridx = i%8;
                    c.gridy = j;
                    window.add(role3, c);
                    break;
                case 39:
                    JButton role4 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
                    role4.setPreferredSize(new Dimension(150,210));                    
                    c.anchor = GridBagConstraints.LAST_LINE_END;
                    c.gridheight = 2;
                    c.gridx = i%8;
                    c.gridy = j;
                    window.add(role4, c);
                    break;
                case 1:
                case 2:
                case 5:
                case 6:
                case 9:
                case 14:
                case 33:
                case 38:
                case 41:
                case 42:
                case 45:
                case 46:
                case 8:
                case 15:
                case 16:
                case 23:
                case 24:
                case 31:
                case 40:
                case 47:

                    break;
                default:
                    JButton eau = new JButton(/*new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/tuiles/Heliport.png"))*/);
                    eau.setPreferredSize(new Dimension(10,10));
                    c.fill = GridBagConstraints.BOTH;
                    c.gridheight = 1;
                    c.weightx = 0.5;
                    c.weighty = 0.5;
                    c.gridx = i%8;
                    c.gridy = j;
                    window.add(eau, c);
                    break;
                }
            
        }
        window.setVisible(true);
    }
}
