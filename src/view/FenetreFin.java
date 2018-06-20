/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author piolleta
 */
public class FenetreFin {

    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel panelBas;
    
    private final JButton btnRetenter;
    private final JButton btnRejouer;
    private final JButton btnQuitter;

    public FenetreFin(boolean aGagne) {

        //Creation de la fenetre
        window = new JFrame();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();
        window.setSize(new Dimension(500, 300));
        window.setLocation((width/2-250), (height/2-150));
        
        mainPanel = new JPanel(new BorderLayout());
        panelBas = new JPanel();
        
        btnQuitter = new JButton("Quitter le jeu");
        panelBas.add(btnQuitter);
        
        
        
        
        
        btnRetenter = new JButton ("Retenter sa chance");
        btnRejouer = new JButton ("Rejouer une partie");
        
        
        
        
        
        mainPanel.add(panelBas);
        
        
        window.add(mainPanel);
        window.setResizable(false);
        window.setVisible(true);

    }
    
    public static void main(String[] args) {
       FenetreFin fenetreFin = new FenetreFin(true);
    }

}
