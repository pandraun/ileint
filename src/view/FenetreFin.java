/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import util.Message;
import util.TypesMessages;

/**
 *
 * @author piolleta
 */
public class FenetreFin extends Observe {

    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel panelBas;
    private final JPanel panelHaut;

    private final JButton btnRetenter;
    private final JButton btnRejouer;
    private final JButton btnQuitter;

    private JTextArea textInfoJeu;
    private final Font f;

    public FenetreFin(boolean aGagne) {

        //Creation de la fenetre
        window = new JFrame();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();
        window.setSize(new Dimension(500, 300));
        window.setLocation((width / 2 - 250), (height / 2 - 150));

        mainPanel = new JPanel(new BorderLayout());
        panelBas = new JPanel();
        panelHaut = new JPanel();

        panelBas.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        //Panels pour les informations de jeu + mise en place du texte et de son apparence + ajout
        textInfoJeu = new JTextArea("LEL t nul");
        f = new Font("Ile int", Font.PLAIN, 30);
        textInfoJeu.setForeground(Color.GRAY);
        textInfoJeu.setFont(f);
        textInfoJeu.setEditable(false);
        textInfoJeu.setPreferredSize(new Dimension(400, 180));
        panelHaut.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panelHaut.add(textInfoJeu);

        btnQuitter = new JButton("Quitter le jeu");
        btnRejouer = new JButton("Rejouer une partie");
        btnRetenter = new JButton("Retenter sa chance");

        btnQuitter.setPreferredSize(new Dimension(180, 30));
        btnRejouer.setPreferredSize(new Dimension(180, 30));
        btnRetenter.setPreferredSize(new Dimension(180, 30));

        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                System.exit(0);
                notifierObservateur(m);
            }
        });
        
        btnRejouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                notifierObservateur(m);            }
        });
        
        btnRetenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.DEMARRER;
                notifierObservateur(m);            }
        });

        if (aGagne == true) {
            panelBas.add(btnRejouer);
        } else {
            panelBas.add(btnRetenter);
        }

        panelBas.add(btnQuitter);

        mainPanel.add(panelHaut, BorderLayout.CENTER);
        mainPanel.add(panelBas, BorderLayout.SOUTH);

        window.add(mainPanel);
        window.setResizable(false);
        window.setVisible(true);

    }

    public void setTextInfoJeu(String nouveauString) {
        textInfoJeu.setText(nouveauString);
    }
    
    public void visible(boolean bool){
        window.setVisible(bool);
    }
public static void main(String[] args) {
       FenetreFin controleur = new FenetreFin(true);
    }
}
