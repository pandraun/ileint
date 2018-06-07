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
        window.setLayout(new GridLayout(6,8,10,10));
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
                    JButton EauSombree = new JButton(new ImageIcon(new URL( "http://s.scifi-universe.com/critiques/images-old/ileinterdite_bf_01.jpg")));
                    window.add(EauSombree);
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
