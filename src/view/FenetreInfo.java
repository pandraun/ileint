/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author piolleta
 */

import ileint.Aventurier.Aventurier;
import ileint.Joueur.Joueur;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import util.Message;
import util.TypesMessages;

public class FenetreInfo extends Observe {

    //Les différentes parties de l'affichage
    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel infoPanel;
    private final JPanel panelRole;
    private final JPanel reglesPanel;
    private final JPanel panelInfoJeu;
    private final JPanel panelMilieu;
    private final JPanel panelActions;
    private final JPanel panelBasFenetre;
    private final JPanel panelBas;
    private final JPanel panelTresor;
    private final JPanel panelAutresActions;
    private final JPanel panelAc;

    //Les boutons pour l'apparence des trésors
    private final JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private final JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
    private final JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private final JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
    private final JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private final JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
    private final JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private final JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));

    //Les boutons pour les différentes actions possibles
    private JButton btnDeplacer;
    private JButton btnAssecher;
    private JButton btnDonner;
    private JButton btnTresor;
    private JButton btnUtiliserCarte;
    private JButton btnPasser;
    private JButton btnAnnuler;

    //Les boutons pour les actions spéciales
    private JButton btnHelico;
    private JButton btnDepAutresJoueurs;

    //Le bouton pour l'affichage des règles et aides
    private final JButton btnRegles;
    private final JButton btnAides;

    //Apparence du texte
    private JTextArea textInfoJeu;
    private Font f;

    //Element changeant suivant informations du controleur
    private JLabel labelRole;
    private Joueur joueurCourant;

    //Elements pour le CardLayout
    private CardLayout layButton;
    private JPanel pBoutons;
    private Dimension d;

    public FenetreInfo() throws MalformedURLException {

        //Fenetre principale
        window = new JFrame();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = 805;
        int width =  520;  //(int) dimension.getWidth() - 1150;
        window.setSize(new Dimension(width, height));
        window.setLocation(1150, 0);

        //Panels pour les règles de jeu + instantiation + ajout
        mainPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel(new BorderLayout());
        reglesPanel = new JPanel(new BorderLayout());
        btnRegles = new JButton("Lire les règles");
        btnAides = new JButton("Lire aide interface");
        btnRegles.setPreferredSize(new Dimension(165,25));
        btnAides.setPreferredSize(new Dimension(165,25));
        reglesPanel.add(btnAides, BorderLayout.WEST);
        reglesPanel.add(btnRegles, BorderLayout.EAST);
        infoPanel.add(reglesPanel, BorderLayout.NORTH);
        
        //Panels pour les informations de jeu + mise en place du texte et de son apparence + ajout
        panelInfoJeu = new JPanel();
        textInfoJeu = new JTextArea("\n  A vous de jouer !\n\n  Choisissez une action \n  parmis celle-ci dessous:");
        f = new Font("Ile int", Font.PLAIN, 30);
        textInfoJeu.setForeground(Color.GRAY);
        textInfoJeu.setFont(f);
        textInfoJeu.setEditable(false);
        textInfoJeu.setPreferredSize(new Dimension(440, 250));
        panelInfoJeu.add(textInfoJeu);
        infoPanel.add(panelInfoJeu, BorderLayout.CENTER);

        //Panel pour le role + instantiation + ajout
        panelRole = new JPanel();
        labelRole = new JLabel("Ingenieur");
        panelRole.add(labelRole);
        infoPanel.add(panelRole, BorderLayout.SOUTH);

        //Instantiation des panels pour les actions
        panelMilieu = new JPanel(new BorderLayout());
        panelActions = new JPanel(new GridBagLayout());

        //Paramètre du GridBagLayout
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(10, 15,10, 15);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 3;
        gc.weighty = 3;
        d = new Dimension (150,25);

        //Bouton Deplacer
        btnDeplacer = new JButton("Se déplacer");
        btnDeplacer.setPreferredSize(d);
        btnDeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.SE_DEPLACER;
                notifierObservateur(m);
            }
        });
        gc.gridx = 0;
        gc.gridy = 0;
        panelActions.add(btnDeplacer, gc);

        //Bouton Assecher
        btnAssecher = new JButton("Assécher");
        btnAssecher.setPreferredSize(d);
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
        btnDonner = new JButton("Donner carte");
        btnDonner.setPreferredSize(d);
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
        btnTresor = new JButton("Récupérer");
        btnTresor.setPreferredSize(d);
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
        btnUtiliserCarte = new JButton("Utiliser carte");
        btnUtiliserCarte.setPreferredSize(d);
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

        //Bouton spécial
        JPanel p1, p2, p3;
        layButton = new CardLayout();
        pBoutons = new JPanel(layButton);

        p1 = new JPanel();
        btnHelico = new JButton("Hélico");
        btnHelico.setPreferredSize(d);
        btnHelico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.DEPLACEMENT_HELICO;
                notifierObservateur(m);
            }
        });
        p1.add(btnHelico);
        pBoutons.add(p1, "helico");

        p2 = new JPanel();
        btnDepAutresJoueurs = new JButton("Déplacer autre\njoueur");
        btnDepAutresJoueurs.setPreferredSize(d);
        btnDepAutresJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.DEPLACER_AUTRES_JOUEURS;
                notifierObservateur(m);
            }
        });
        p2.add(btnDepAutresJoueurs);
        pBoutons.add(p2, "depautresjoueurs");

        p3 = new JPanel();
        pBoutons.add(p3, "rien");

        gc.gridx = 2;
        gc.gridy = 2;
        panelActions.add(pBoutons, gc);
        panelMilieu.add(panelActions, BorderLayout.NORTH);
        
        //Paramètre du 2e GridBagLayout
        GridBagConstraints gc2 = new GridBagConstraints();
        gc2.fill = GridBagConstraints.BOTH;
        gc2.insets = new Insets(30, 15,10, 15);
        gc2.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc2.weightx = 1;
        gc2.weighty = 3;
        
        //Panel pour actions annuler passer et nbactions
        panelAutresActions = new JPanel();
        panelAc = new JPanel(new GridBagLayout());
        
        //Bouton Annuler
        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setPreferredSize(d);
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.ANNULER;
                notifierObservateur(m);
            }
        });
        gc.gridx = 0;
        gc.gridy = 0;
        panelAc.add(btnAnnuler, gc2);
        
        //Bouton Passer
        btnPasser = new JButton("Passer tour");
        btnPasser.setPreferredSize(d);
        btnPasser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.PASSER_TOUR;
                notifierObservateur(m);
            }
        });
        gc.gridx = 0;
        gc.gridy = 2;
        panelAc.add(btnPasser, gc2);

        panelAutresActions.add(panelAc, gc2);
        panelMilieu.add(panelAutresActions);
        //Panel pour la jauge d'eau et les trésors
        panelBasFenetre = new JPanel();
        panelBas = new JPanel(new GridLayout(2, 1));

        //Grid layout pour les trésors
        GridLayout tresor = new GridLayout(1, 4);
        tresor.setHgap(15);
        tresor.setVgap(10);

        //Panel pour les trésors
        panelTresor = new JPanel(tresor);

        //Mise en place des trésors
        caliceAbsent.setPreferredSize(new Dimension(100, 100));
        cristalAbsent.setPreferredSize(new Dimension(100, 100));
        pierreAbsent.setPreferredSize(new Dimension(100, 100));
        statueAbsent.setPreferredSize(new Dimension(100, 100));

        panelTresor.add(caliceAbsent);
        panelTresor.add(cristalAbsent);
        panelTresor.add(pierreAbsent);
        panelTresor.add(statueAbsent);

        //Ajout des trésors
        panelBasFenetre.add(panelTresor);
        panelBasFenetre.add(panelBas);

        //Ajout des différentes parties au main panel
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        mainPanel.add(panelBasFenetre, BorderLayout.SOUTH);

        //Ajout de mainPanel à la fenre + etat
        window.add(mainPanel);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void cliquableDeplacer(boolean boo) {
        btnDeplacer.setEnabled(boo);
    }

    public void cliquableAssechement(boolean boo) {
        btnAssecher.setEnabled(boo);
    }

    public void cliquableDonner(boolean boo) {
        btnDonner.setEnabled(boo);
    }

    public void cliquableUtiliser(boolean boo) {
        btnUtiliserCarte.setEnabled(boo);
    }

    public void cliquablePasser(boolean boo) {
        btnPasser.setEnabled(boo);
    }

    public void cliquableTresor(boolean boo) {
        btnTresor.setEnabled(boo);
    }

    public void modifierLabelJoueur(Joueur joueur) {
        labelRole.setText(joueur.getRole().getNom() + " (" + joueur.getNomJoueur() + ")");
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public void boutonSpeciale(String nomRole) {
        if (nomRole.equals("Navigateur")) {
            layButton.show(pBoutons, "depautresjoueurs");
            btnDepAutresJoueurs.setEnabled(true);
        } else if (nomRole.equals("Pilote")) {
            layButton.show(pBoutons, "helico");
            btnHelico.setEnabled(true);

        } else {
            layButton.show(pBoutons, "rien");
        }
    }

    public void setLabelRole(JLabel labelRole) {
        this.labelRole = labelRole;
    }

    
}
