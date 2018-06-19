/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        window = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        infoPanel = new JPanel(new BorderLayout());
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        JPanel reglesPanel = new JPanel(new BorderLayout());
        infoPanel.add(reglesPanel, BorderLayout.NORTH);
        JButton btnRegles = new JButton("Lire Règle");
        reglesPanel.add(btnRegles, BorderLayout.EAST);
        
        
    }
}
