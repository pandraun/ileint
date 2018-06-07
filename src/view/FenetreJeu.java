/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        window.setLayout(new GridLayout(6,8,20,10));
        for(int i = 0; i < 48; i++){
            switch (i){
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
                    JButton EauSombree = new JButton(new ImageIcon(new URL( "https://raw.githubusercontent.com/Arxwel/Ile-Interdite/master/src/ImagesTuiles/EauSombree.png")));
                    window.add(EauSombree);
                    break;
                case 0:
                case 7:
                case 8:
                case 15:
                case 16:
                case 23:
                case 24:
                case 31:
                case 32:
                case 39:
                case 40:
                case 47:
                    JLabel JL = new JLabel("");
                    window.add(JL);
                    break;
                default:
                    JButton Eau = new JButton();
                    window.add(Eau);
                    break;
                }
            
        }
        
        window.setVisible(true);
    }
}
