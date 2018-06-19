/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Message;
import util.TypesMessages;

/**
 *
 * @author pandraun
 */
public class FenetreInfo extends Observe {

    private JFrame window;
    private JPanel mainPanel;

    private JPanel infoPanel;

    private JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
    private JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
    private JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
    private JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));

    public FenetreInfo() throws MalformedURLException {

        //Fenetre principale
        window = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = 869;
        int width = (int) dimension.getWidth() - 1090;
        window.setSize(new Dimension(width, height));
        window.setLocation(1090, 0);

        //Lire règle
        infoPanel = new JPanel(new BorderLayout());
        JPanel reglesPanel = new JPanel(new BorderLayout());
        JButton btnRegles = new JButton("Lire Règle");

        reglesPanel.add(btnRegles, BorderLayout.EAST);
        infoPanel.add(reglesPanel, BorderLayout.NORTH);

        //Info jeu
        JPanel panelInfoJeu = new JPanel();
        JLabel labelInfoJeu = new JLabel("ryhujklmjoifyfyfyfyfyfyfyfyfyfyfyfyjknnkjnk");

        panelInfoJeu.add(labelInfoJeu);
        infoPanel.add(panelInfoJeu, BorderLayout.CENTER);

        //Info role
        JPanel panelRole = new JPanel();
        JLabel labelRole = new JLabel("Ingenieur");

        panelRole.add(labelRole);
        infoPanel.add(panelRole, BorderLayout.SOUTH);

        //Panel actions
        JPanel panelMilieu = new JPanel();
        JPanel panelActions = new JPanel(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 3;
        gc.weighty = 5;

        //Bouton Deplacer
        JButton btnDeplacer = new JButton();
        btnDeplacer.setText("Deplacer");
        btnDeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.SE_DEPLACER;
                notifierObservateur(m);
                System.out.println("wut wuuuut");
            }

        });
        gc.gridx = 0;
        gc.gridy = 0;
        panelActions.add(btnDeplacer, gc);

        //Bouton Assecher
        JButton btnAssecher = new JButton();
        btnAssecher.setText("Assecher");
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.ASSECHER;
                notifierObservateur(m);
            }
        });
        gc.gridx = 2;
        gc.gridy = 0;
        panelActions.add(btnAssecher, gc);

        //Bouton Donner
        JButton btnDonner = new JButton();
        btnDonner.setText("Donner");
        btnDonner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.DONNER_CARTE;
                notifierObservateur(m);
            }
        });
        gc.gridx = 0;
        gc.gridy = 1;
        panelActions.add(btnDonner, gc);

        //Bouton trésor
        JButton btnTresor = new JButton();
        btnTresor.setText("Recuperer");
        btnTresor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.RECUPERER_TRESOR;
                notifierObservateur(m);
            }
        });
        gc.gridx = 2;
        gc.gridy = 1;
        panelActions.add(btnTresor, gc);

        //Bouton utiliser carte
        JButton btnUtiliserCarte = new JButton();
        btnUtiliserCarte.setText("Utiliser");
        btnUtiliserCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.UTILISER_CARTE;
                notifierObservateur(m);
            }
        });
        gc.gridx = 0;
        gc.gridy = 2;
        panelActions.add(btnUtiliserCarte, gc);

        //Bouton Autre A MODIFIER
        JButton btnAutre = new JButton();
        btnAutre.setText("Autre");
        gc.gridx = 1;
        gc.gridy = 3;
        panelActions.add(btnAutre, gc);

        //Bouton Passer
        JButton btnPasser = new JButton();
        btnPasser.setText("Passer");
        btnPasser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.PASSER_TOUR;
                notifierObservateur(m);
            }
        });
        gc.gridx = 2;
        gc.gridy = 2;
        panelActions.add(btnPasser, gc);

        //Ajout
        panelMilieu.add(panelActions);

        //Bas fenetre
        JPanel panelBasFenetre = new JPanel();
        JPanel panelBas = new JPanel(new GridLayout(2, 1));

        //panelBas.add(IMAGE JAUGE DEAU)
        GridLayout tresor = new GridLayout(1, 4);

        tresor.setHgap(15);
        tresor.setVgap(10);

        JPanel panelTresor = new JPanel(tresor);

        caliceAbsent.setPreferredSize(new Dimension(100, 100));
        cristalAbsent.setPreferredSize(new Dimension(100, 100));
        pierreAbsent.setPreferredSize(new Dimension(100, 100));
        statueAbsent.setPreferredSize(new Dimension(100, 100));

        panelTresor.add(caliceAbsent);
        panelTresor.add(cristalAbsent);
        panelTresor.add(pierreAbsent);
        panelTresor.add(statueAbsent);

        panelBasFenetre.add(panelTresor);
        panelBasFenetre.add(panelBas);

        //Rajout de la partie nord au main panel
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        mainPanel.add(panelBasFenetre, BorderLayout.SOUTH);

        window.setResizable(false);
        window.setVisible(true);
    }

}
