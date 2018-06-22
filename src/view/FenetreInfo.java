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
import ileint.Joueur.Joueur;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import util.Message;
import util.TypeTresor;
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
    private final JPanel panelBas;
    private final JPanel panelTresor;
    private final JPanel panelAutresActions;
    private final JPanel panelAc;

    //Les labels pour l'apparence des trésors
    private final JLabel caliceAbsent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private final JLabel calicePresent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/pr%C3%A9sent/calice.png")));
    private final JLabel cristalAbsent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private final JLabel cristalPresent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/pr%C3%A9sent/cristal.png")));
    private final JLabel pierreAbsent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private final JLabel pierrePresent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/pr%C3%A9sent/pierre.png")));
    private final JLabel statueAbsent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private final JLabel statuePresent = new JLabel(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/pr%C3%A9sent/statue.png")));

    //Les labels pour l'apparence de la jauge
    private JLabel niv1 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau1.png"));
    private JLabel niv2 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau2.png"));
    private JLabel niv3 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau3.png"));
    private JLabel niv4 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau4.png"));
    private JLabel niv5 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau5.png"));
    private JLabel niv6 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau6.png"));
    private JLabel niv7 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau7.png"));
    private JLabel niv8 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau8.png"));
    private JLabel niv9 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau9.png"));
    private JLabel niv10 = new JLabel(new ImageIcon("DossierImage/jaugeEau/Niveau10.png"));

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
    private Font f2;

    //Element changeant suivant informations du controleur
    private JLabel labelRole;
    private Joueur joueurCourant;

    //Elements pour le CardLayout
    private CardLayout layButton;
    private JPanel pBoutons;
    private Dimension d;
    private CardLayout layNbAc;
    private JPanel pActions;
    private GridBagConstraints gc3;
    private CardLayout layTresor1;
    private JPanel panelTresor1;
    private CardLayout layTresor2;
    private JPanel panelTresor2;
    private CardLayout layTresor3;
    private JPanel panelTresor3;
    private CardLayout layTresor4;
    private JPanel panelTresor4;
    private CardLayout layJauge;
    private JPanel panelJauge;

    public FenetreInfo() throws MalformedURLException, IOException {

        //Fenetre principale
        this.window = new JFrame();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = 805;
        int width = 520;
        window.setSize(new Dimension(width, height));
        window.setLocation(1150, 0);

        final BufferedImage image = ImageIO.read(new File("DossierImage/imgAutre/fond1.png"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        window.setContentPane(pane);

        //Panels pour les règles de jeu + instantiation + ajout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        reglesPanel = new JPanel(new BorderLayout());
        reglesPanel.setOpaque(false);
        btnRegles = new JButton("Lire les règles");

        btnRegles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.LIRE_REGLES;
                notifierObservateur(m);
            }
        });

        btnAides = new JButton("Lire aide interface");

        btnAides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.LIRE_INTERFACE;
                notifierObservateur(m);
            }
        });

        btnRegles.setPreferredSize(new Dimension(165, 25));
        btnAides.setPreferredSize(new Dimension(165, 25));
        reglesPanel.add(btnAides, BorderLayout.WEST);
        reglesPanel.add(btnRegles, BorderLayout.EAST);
        infoPanel.add(reglesPanel, BorderLayout.NORTH);

        //window.setContentPane(new ImagePanel("DossierImage/imgAutre/sable.jpg"));
        //Panels pour les informations de jeu + mise en place du texte et de son apparence + ajout
        panelInfoJeu = new JPanel();
        panelInfoJeu.setOpaque(false);
        f = new Font("Ile int", Font.PLAIN, 20);
        textInfoJeu = new JTextArea();
        textInfoJeu.setForeground(Color.GRAY);
        textInfoJeu.setFont(f);
        textInfoJeu.setEditable(false);
        textInfoJeu.setPreferredSize(new Dimension(400, 150));
        panelInfoJeu.add(textInfoJeu);
        infoPanel.add(panelInfoJeu, BorderLayout.CENTER);

        //Panel pour le role + instantiation + ajout
        panelRole = new JPanel();
        panelRole.setOpaque(false);
        labelRole = new JLabel("Ingenieur");
        panelRole.add(labelRole);
        infoPanel.add(panelRole, BorderLayout.SOUTH);

        //Instantiation des panels pour les actions
        panelMilieu = new JPanel(new BorderLayout());
        panelMilieu.setOpaque(false);
        panelActions = new JPanel(new GridBagLayout());
        panelActions.setOpaque(false);

        //Paramètre du GridBagLayout
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(10, 0, 0, 0);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 3;
        gc.weighty = 3;
        d = new Dimension(150, 35);

        //Bouton Deplacer
        btnDeplacer = new JButton(new ImageIcon("DossierImage/IconeBouton/IconDeplacementExploV2.png"));
//        btnDeplacer.setHorizontalTextPosition(SwingConstants.WEST); 
//        btnDeplacer.setIcon(new ImageIcon("DossierImage/IconeBouton/IconDeplacementExplo.png"));

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
        JPanel panDeplacer = new JPanel();
        panDeplacer.setOpaque(false);
        panDeplacer.add(btnDeplacer);
        panelActions.add(panDeplacer, gc);

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
        JPanel panAssecher = new JPanel();
        panAssecher.setOpaque(false);
        panAssecher.add(btnAssecher);
        panelActions.add(panAssecher, gc);

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
        JPanel panDonner = new JPanel();
        panDonner.setOpaque(false);
        panDonner.add(btnDonner);
        panelActions.add(panDonner, gc);

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
        JPanel panRecuperer = new JPanel();
        panRecuperer.setOpaque(false);
        panRecuperer.add(btnTresor);
        panelActions.add(panRecuperer, gc);

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
        JPanel panUtiliser = new JPanel();
        panUtiliser.setOpaque(false);
        panUtiliser.add(btnUtiliserCarte);
        panelActions.add(panUtiliser, gc);

        //Bouton spécial
        JPanel p1, p2, p3;
        layButton = new CardLayout();
        pBoutons = new JPanel(layButton);
        pBoutons.setOpaque(false);

        p1 = new JPanel();
        p1.setOpaque(false);
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
        p2.setOpaque(false);
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
        p3.setOpaque(false);
        pBoutons.add(p3, "rien");

        //gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.ipadx = 0;
        gc.ipady = 0;
        panelActions.add(pBoutons, gc);
        panelMilieu.add(panelActions, BorderLayout.NORTH);

        //Paramètre du 2e GridBagLayout
        GridBagConstraints gc2 = new GridBagConstraints();
        gc2.fill = GridBagConstraints.BOTH;
        gc2.insets = new Insets(50, 15, 50, 15);
        gc2.ipady = gc2.anchor = GridBagConstraints.CENTER;
        gc2.weightx = 1;
        gc2.weighty = 3;
        d = new Dimension(120, 25);

        //Panel pour actions annuler passer et nbactions
        panelAutresActions = new JPanel();
        panelAutresActions.setOpaque(false);
        panelAc = new JPanel(new GridBagLayout());
        panelAc.setOpaque(false);

        //Bouton Annuler
        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setEnabled(false);
        btnAnnuler.setPreferredSize(d);
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.ANNULER;
                notifierObservateur(m);
            }
        });
        gc2.gridx = 0;
        gc2.gridy = 0;
        panelAc.add(btnAnnuler, gc2);

        //*********************************************************************
        //Icone spécial
        JPanel pan1, pan2, pan3;
        layNbAc = new CardLayout();
        pActions = new JPanel(layNbAc);
        pActions.setOpaque(false);
        f2 = new Font("NbAction", Font.BOLD, 25);

        pan1 = new JPanel();
        pan1.setOpaque(false);
        JLabel action1 = new JLabel("1");
        action1.setFont(f2);
        pan1.add(action1);
        pActions.add(pan1, "1action");

        pan2 = new JPanel();
        pan2.setOpaque(false);
        JLabel action2 = new JLabel("2");
        action2.setFont(f2);
        pan2.add(action2);
        pActions.add(pan2, "2action");

        pan3 = new JPanel();
        pan3.setOpaque(false);
        JLabel action3 = new JLabel("3");
        action3.setFont(f2);
        pan3.add(action3);
        pActions.add(pan3, "3action");

        gc2.gridx = 1;
        gc2.gridy = 0;
        panelAc.add(pActions, gc2);

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
        gc2.gridx = 2;
        gc2.gridy = 0;
        panelAc.add(btnPasser, gc2);

        panelAutresActions.add(panelAc, gc2);
        panelMilieu.add(panelAutresActions, BorderLayout.CENTER);

        //****************************************************
        //Panel pour la jauge d'eau et les trésors
        panelBas = new JPanel(new BorderLayout());
        panelBas.setOpaque(false);

        //Jauge d'eau
        //JLabel imageJauge = new JLabel(new ImageIcon("DossierImage/imgAutre/Niveau.png"));
        //panelBas.add(imageJauge, BorderLayout.NORTH);
        JPanel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;
        layJauge = new CardLayout();
        panelJauge = new JPanel(layJauge);
        panelJauge.setOpaque(false);

        j1 = new JPanel();
        j1.setOpaque(false);
        j1.add(niv1);
        panelJauge.add(j1, "niv1");
        j2 = new JPanel();
        j2.setOpaque(false);
        j2.add(niv2);
        panelJauge.add(j2, "niv2");
        j3 = new JPanel();
        j3.setOpaque(false);
        j3.add(niv3);
        panelJauge.add(j3, "niv3");
        j4 = new JPanel();
        j4.setOpaque(false);
        j4.add(niv4);
        panelJauge.add(j4, "niv4");
        j5 = new JPanel();
        j5.setOpaque(false);
        j5.add(niv5);
        panelJauge.add(j5, "niv5");
        j6 = new JPanel();
        j6.setOpaque(false);
        j6.add(niv6);
        panelJauge.add(j6, "niv6");
        j7 = new JPanel();
        j7 = new JPanel();
        j7.add(niv7);
        panelJauge.add(j7, "niv7");
        j8 = new JPanel();
        j8.setOpaque(false);
        j8.add(niv8);
        panelJauge.add(j8, "niv8");
        j9 = new JPanel();
        j9.setOpaque(false);
        j9.add(niv9);
        panelJauge.add(j9, "niv9");
        j10 = new JPanel();
        j10.setOpaque(false);
        j10.add(niv10);
        panelJauge.add(j10, "niv10");

        panelBas.add(panelJauge, BorderLayout.NORTH);

        //Panel pour les trésors
        panelTresor = new JPanel(new GridBagLayout());
        panelTresor.setOpaque(false);

        //Paramètre du  4e GridBagLayout
        gc3 = new GridBagConstraints();
        gc3.insets = new Insets(10, 15, 10, 15);
        gc3.weightx = 1;
        gc3.weighty = 4;

        //Mise en place des trésors
        caliceAbsent.setPreferredSize(new Dimension(80, 80));
        cristalAbsent.setPreferredSize(new Dimension(80, 80));
        pierreAbsent.setPreferredSize(new Dimension(80, 80));
        statueAbsent.setPreferredSize(new Dimension(80, 80));

        calicePresent.setPreferredSize(new Dimension(80, 80));
        cristalPresent.setPreferredSize(new Dimension(80, 80));
        pierrePresent.setPreferredSize(new Dimension(80, 80));
        statuePresent.setPreferredSize(new Dimension(80, 80));

        JPanel pp1, pp2;

        layTresor1 = new CardLayout();
        panelTresor1 = new JPanel(layTresor1);
        panelTresor1.setOpaque(false);
        pp1 = new JPanel();
        pp1.setOpaque(false);
        pp1.add(caliceAbsent);
        panelTresor1.add(pp1, "tresor1Absent");
        pp2 = new JPanel();
        pp2.setOpaque(false);
        pp2.add(calicePresent);
        panelTresor1.add(pp2, "tresor1Present");

        layTresor2 = new CardLayout();
        panelTresor2 = new JPanel(layTresor2);
        panelTresor2.setOpaque(false);
        pp1 = new JPanel();
        pp1.setOpaque(false);
        pp1.add(cristalAbsent);
        panelTresor2.add(pp1, "tresor2Absent");
        pp2 = new JPanel();
        pp2.setOpaque(false);
        pp2.add(cristalPresent);
        panelTresor2.add(pp2, "tresor2Present");

        layTresor3 = new CardLayout();
        panelTresor3 = new JPanel(layTresor3);
        panelTresor3.setOpaque(false);
        pp1 = new JPanel();
        pp1.setOpaque(false);
        pp1.add(pierreAbsent);
        panelTresor3.add(pp1, "tresor3Absent");
        pp2 = new JPanel();
        pp2.setOpaque(false);
        pp2.add(pierrePresent);
        panelTresor3.add(pp2, "tresor3Present");

        layTresor4 = new CardLayout();
        panelTresor4 = new JPanel(layTresor4);
        panelTresor4.setOpaque(false);
        pp1 = new JPanel();
        pp1.setOpaque(false);
        pp1.add(statueAbsent);
        panelTresor4.add(pp1, "tresor4Absent");
        pp2 = new JPanel();
        pp2.setOpaque(false);
        pp2.add(statuePresent);
        panelTresor4.add(pp2, "tresor4Present");

        gc.gridx = 0;
        gc.gridy = 0;
        panelTresor.add(panelTresor1, gc3);
        gc.gridx = 0;
        gc.gridy = 1;
        panelTresor.add(panelTresor2, gc3);
        gc.gridx = 0;
        gc.gridy = 2;
        panelTresor.add(panelTresor3, gc3);
        gc.gridx = 0;
        gc.gridy = 3;
        panelTresor.add(panelTresor4, gc3);

        layTresor1.show(panelTresor1, "tresor1Absent");
        layTresor2.show(panelTresor2, "tresor2Absent");
        layTresor3.show(panelTresor3, "tresor3Absent");
        layTresor4.show(panelTresor4, "tresor4Absent");

        //Ajout des trésors
        panelBas.add(panelTresor, BorderLayout.SOUTH);

        //Ajout des différentes parties au main panel
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        mainPanel.add(panelBas, BorderLayout.SOUTH);

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

    public void cliquableHelico(boolean bool) {
        btnHelico.setEnabled(bool);
    }

    public void cliquableDeplacementAutre(boolean bool) {
        btnDepAutresJoueurs.setEnabled(bool);
    }

    public void cliquableAnnuler(boolean bool) {
        btnAnnuler.setEnabled(bool);
    }

    public void modifierLabelJoueur(Joueur joueur) {
        labelRole.setText(joueur.getRole().getNom() + " (" + joueur.getNomJoueur() + ")");
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

    public void setTextInfoJeu(String nouveauTexte) {
        textInfoJeu.setText(nouveauTexte);
    }

    public void affichageAction(int nbAction) {
        if (nbAction == 1) {
            layNbAc.show(pActions, "1action");
        } else if (nbAction == 2) {
            layNbAc.show(pActions, "2action");
        } else {
            layNbAc.show(pActions, "3action");
        }
    }

    public void changerImageTresor(TypeTresor type) {
        if (type.equals(TypeTresor.CALICE)) {
            layTresor1.show(panelTresor1, "tresor1Present");
        } else if (type.equals(TypeTresor.CRISTAL)) {
            layTresor2.show(panelTresor2, "tresor2Present");
        } else if (type.equals(TypeTresor.PIERRE)) {
            layTresor3.show(panelTresor3, "tresor3Present");
        } else if (type.equals(TypeTresor.STATUE)) {
            layTresor4.show(panelTresor4, "tresor4Present");
        }
    }

    public void changerImageJauge(int niv) {
        System.out.println(niv);
        if (niv == 1) {
            layJauge.show(panelJauge, "niv1");
        } else if (niv == 2) {
            layJauge.show(panelJauge, "niv2");
        } else if (niv == 3) {
            layJauge.show(panelJauge, "niv3");
        } else if (niv == 4) {
            layJauge.show(panelJauge, "niv4");
        } else if (niv == 5) {
            layJauge.show(panelJauge, "niv5");
        } else if (niv == 6) {
            layJauge.show(panelJauge, "niv6");
        } else if (niv == 7) {
            layJauge.show(panelJauge, "niv7");
        } else if (niv == 8) {
            layJauge.show(panelJauge, "niv8");
        } else if (niv == 9) {
            layJauge.show(panelJauge, "niv9");
        } else if (niv == 10) {
            layJauge.show(panelJauge, "niv10");
        }
    }

    public void cliquableDefaut() {
        cliquableUtiliser(true);
        cliquableAssechement(true);
        cliquableDeplacementAutre(true);
        cliquableDeplacer(true);
        cliquableDonner(true);
        cliquableHelico(true);
        cliquablePasser(true);
        cliquableTresor(true);
        cliquableAnnuler(false);
    }

    public void cliquableBloque() {
        cliquableUtiliser(false);
        cliquableAssechement(false);
        cliquableDeplacementAutre(false);
        cliquableDeplacer(false);
        cliquableDonner(false);
        cliquableHelico(false);
        cliquablePasser(false);
        cliquableTresor(false);
        cliquableAnnuler(false);
    }

    public void cliquableAttenteDaction() {
        cliquableUtiliser(false);
        cliquableAssechement(false);
        cliquableDeplacementAutre(false);
        cliquableDeplacer(false);
        cliquableDonner(false);
        cliquableHelico(false);
        cliquablePasser(false);
        cliquableAnnuler(true);
        cliquableTresor(false);
    }

}
