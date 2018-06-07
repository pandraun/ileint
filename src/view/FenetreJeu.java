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

    public FenetreJeu() throws MalformedURLException {

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();

        this.window = new JFrame();
        window.setSize(width, height);
        window.setLayout(new GridLayout(6, 6, 15, 10));
        for (int i = 0; i < 36; i++) {
            switch (i) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 11:
                case 24:
                case 29:
                case 30:
                case 31:
                case 34:
                case 35:
                    JButton EauSombree = new JButton(new ImageIcon(new URL("http://s.scifi-universe.com/critiques/images-old/ileinterdite_bf_01.jpg")));
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
