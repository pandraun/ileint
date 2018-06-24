/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ileint.Carte.CarteInondation;
import ileint.Carte.CarteOrange;
import ileint.Joueur.Joueur;
import ileint.Tuile.Coordonnee;
import ileint.Tuile.Tuile;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Message;
import util.TypesMessages;
import util.Utils;

/**
 *
 * @author pandraun
 */
public class FenetreJeu extends Observe {

    private JFrame window;
    private JPanel grille;

    private VueTuile vuetuile;
    private HashMap<Coordonnee, VueTuile> hmVueTuile = new HashMap<>();
    private final JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private final JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
    private final JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private final JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
    private final JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private final JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
    private final JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private final JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));

    private JButton piocheOrange;
    private final JButton btnDefausseOrange;
    private JButton btnPiocheOrange;
    private JButton btnPiocheInondation;
    private final JButton btnDefausseInondation;
    private final JLabel labelNbCarteI;
    private final JLabel labelNbCarteO;
    private VueMain carteJ1;
    private VueMain carteJ2;
    private VueMain carteJ3;
    private VueMain carteJ4;

    private final JPanel role1;
    private final JPanel role2;
    private JPanel role3;
    private JPanel role4;
    private final JButton boutonRole1;
    private final JButton boutonRole2;
    private JButton boutonRole3;
    private JButton boutonRole4;

    GridBagConstraints c = new GridBagConstraints();

    private ArrayList<Joueur> joueurs;

    public FenetreJeu(ArrayList<Joueur> joueurs, Stack<CarteOrange> piocheOrange, Stack<CarteInondation> piocheInondation) throws MalformedURLException {

        this.window = new JFrame("Fenetre Jeu");
        window.addWindowListener(new java.awt.event.WindowListener() {
            public void windowOpened(java.awt.event.WindowEvent e) {
            }

            public void windowClosed(java.awt.event.WindowEvent e) {
            }

            public void windowIconified(java.awt.event.WindowEvent e) {
            }

            public void windowDeiconified(java.awt.event.WindowEvent e) {
            }

            public void windowActivated(java.awt.event.WindowEvent e) {
            }

            public void windowDeactivated(java.awt.event.WindowEvent e) {
            }

            public void windowClosing(java.awt.event.WindowEvent e) {
                Message message = new Message();
                message.type = TypesMessages.CLIQUE_QUITTER;
                notifierObservateur(message);
            }
        });

        this.joueurs = joueurs;

        //Background du jeu//////////////////////////////////////////////////////////////////////////////////////////////////////
        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon(new URL("https://aaronsinternetwhispersblog.files.wordpress.com/2011/12/sea_bg.png")));
        window.setContentPane(contentPane);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        window.setLayout(new GridBagLayout());

        //=======================================//
        //Joueur1
        //=======================================//
        role1 = new JPanel();
        role1.setOpaque(false);
        role1.setLayout(new BoxLayout(role1, BoxLayout.Y_AXIS));
        boutonRole1 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(0).getRole().getNom() + ".png"));

        role1.add(boutonRole1);
        boutonRole1.setPreferredSize(new Dimension(150, 210));
        JLabel EmplacementRole1 = new JLabel("J1: " + joueurs.get(0).getNomJoueur());
        role1.add(EmplacementRole1);
        boutonRole1.setContentAreaFilled(false);
        boutonRole1.setOpaque(false);
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 0;
        window.add(role1, c);

        //-----------Informations sur le Rôle du joueur------------//
        boutonRole1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.CHOIX_JOUEUR;
                m.joueurVise = joueurs.get(0);
                notifierObservateur(m);
            }
        });

        //=======================================//
        //Joueur2
        //=======================================//
        role2 = new JPanel();
        role2.setOpaque(false);
        role2.setLayout(new BoxLayout(role2, BoxLayout.Y_AXIS));
        boutonRole2 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(1).getRole().getNom() + ".png"));
        role2.add(boutonRole2);

        boutonRole2.setPreferredSize(new Dimension(150, 210));
        JLabel EmplacementRole2 = new JLabel("J2: " + joueurs.get(1).getNomJoueur());
        role2.add(EmplacementRole2);
        boutonRole2.setContentAreaFilled(false);
        boutonRole2.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        window.add(role2, c);

        //-----------Informations sur le Rôle du joueur------------//
        boutonRole2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.CHOIX_JOUEUR;
                m.joueurVise = joueurs.get(1);
                notifierObservateur(m);
            }
        });

        //=======================================//
        //Pioche et Defausse Cartes Orange
        //=======================================//
        JPanel panelOrange = new JPanel(new BorderLayout());
        panelOrange.setOpaque(false);
        JPanel sousPanelOrange = new JPanel(new GridLayout(2, 1, 4, 4));
        sousPanelOrange.setOpaque(false);
        labelNbCarteO = new JLabel("nb cartes : " + piocheOrange.size());             //Compteur des cartes dans la pioche Orange
        panelOrange.add(labelNbCarteO, BorderLayout.NORTH);
        panelOrange.add(sousPanelOrange);
        ImageIcon carteRouge = new ImageIcon("DossierImage/imgCarte/Fond rouge.png");
        Image im = carteRouge.getImage();
        int hauteur = 110;
        int largeur = 140;
        im = im.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
        btnPiocheOrange = new JButton(new ImageIcon(im));                           //Création de la pioche Orange
        btnPiocheOrange.setContentAreaFilled(false);
        btnDefausseOrange = new JButton();                                          //Création de la defausse Orange
        btnDefausseOrange.setContentAreaFilled(false);
        sousPanelOrange.add(btnPiocheOrange);
        sousPanelOrange.add(btnDefausseOrange);
        sousPanelOrange.setPreferredSize(new Dimension(140, 140));

        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 2;
        window.add(panelOrange, c);

        //-----------Lors d'un clic sur la Pioche de Cartes Oranges------------//
        btnPiocheOrange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (piocheOrange.size() > 0) {
                    Message m = new Message();
                    m.type = TypesMessages.PIOCHER_CARTE_ORANGE;
                    notifierObservateur(m);
                } else {
                    System.out.println("Pioche Orange Vide");
                    btnPiocheOrange.setEnabled(false);
                }
            }
        });

        //=======================================//
        //Pioche et Defausse Cartes Inondation
        //=======================================//
        JPanel panelInondation = new JPanel(new BorderLayout());
        panelInondation.setOpaque(false);
        JPanel sousPanelInondation = new JPanel(new GridLayout(2, 1, 4, 4));
        sousPanelInondation.setOpaque(false);
        JPanel panelnbCarteI = new JPanel(new BorderLayout());
        panelnbCarteI.setOpaque(false);
        panelInondation.add(panelnbCarteI, BorderLayout.NORTH);
        labelNbCarteI = new JLabel("nb cartes : " + piocheInondation.size());         //Compteur des cartes dans la pioche Inondation
        panelnbCarteI.add(labelNbCarteI, BorderLayout.EAST);
        panelInondation.add(sousPanelInondation);
        ImageIcon CarteBleu = new ImageIcon("DossierImage/imgCarte/Fond bleu.png");
        im = CarteBleu.getImage();
        hauteur = 110;
        largeur = 140;
        im = im.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
        btnPiocheInondation = new JButton(new ImageIcon(im));                       //Création de la pioche Inondation
        btnPiocheInondation.setContentAreaFilled(false);
        btnDefausseInondation = new JButton();                                      //Création de la defausse Inondation
        btnDefausseInondation.setContentAreaFilled(false);
        sousPanelInondation.add(btnPiocheInondation);
        sousPanelInondation.add(btnDefausseInondation);
        sousPanelInondation.setPreferredSize(new Dimension(140, 140));

        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 2;
        window.add(panelInondation, c);

        //-----------Lors d'un clic sur la Pioche de Cartes Inondations------------//
        btnPiocheInondation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (piocheInondation.size() > 0) {
                    Message m = new Message();
                    m.type = TypesMessages.PIOCHER_CARTE_INONDATION;
                    notifierObservateur(m);
                } else {
                    System.out.println("Pioche Inondation vide");
                    btnPiocheInondation.setEnabled(false);
                }
            }
        });

        //=======================================//
        //Joueur3
        //=======================================//
        if (joueurs.size() > 2) {

            role3 = new JPanel();
            role3.setOpaque(false);
            role3.setLayout(new BoxLayout(role3, BoxLayout.Y_AXIS));
            JLabel EmplacementRole3 = new JLabel("J3: " + joueurs.get(2).getNomJoueur());
            role3.add(EmplacementRole3);
            boutonRole3 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(2).getRole().getNom() + ".png"));
            role3.add(boutonRole3);

            boutonRole3.setContentAreaFilled(false);
            boutonRole3.setPreferredSize(new Dimension(150, 210));
            boutonRole3.setOpaque(false);
            c.anchor = GridBagConstraints.LAST_LINE_START;
            c.gridheight = 2;
            c.gridx = 7;
            c.gridy = 4;
            window.add(role3, c);

            //-----------Informations sur le Rôle du joueur------------//
            boutonRole3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.CHOIX_JOUEUR;
                    m.joueurVise = joueurs.get(2);
                    notifierObservateur(m);
                }
            });

            //=======================================//
            //Joueur4
            //=======================================//
            if (joueurs.size() > 3) {

                role4 = new JPanel();
                role4.setOpaque(false);
                role4.setLayout(new BoxLayout(role4, BoxLayout.Y_AXIS));
                JLabel EmplacementRole4 = new JLabel("J4: " + joueurs.get(3).getNomJoueur());
                role4.add(EmplacementRole4);
                boutonRole4 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(3).getRole().getRoleAventurier() + ".png"));
                role4.add(boutonRole4);

                boutonRole4.setPreferredSize(new Dimension(150, 210));
                boutonRole4.setContentAreaFilled(false);
                c.anchor = GridBagConstraints.LAST_LINE_END;
                c.gridheight = 2;
                c.gridx = 0;
                c.gridy = 4;
                window.add(role4, c);

                //-----------Informations sur le Rôle du joueur------------//
                boutonRole4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Message m = new Message();
                        m.type = TypesMessages.CHOIX_JOUEUR;
                        m.joueurVise = joueurs.get(3);
                        notifierObservateur(m);
                    }
                });

            }

            //======================================//
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Mise en place de la grille comportant les tuiles et les cartes des joueurs*
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //==Création de la Grille====================//
        grille = new JPanel(new GridBagLayout());
        grille.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 5;
        c.gridheight = 6;
        c.gridwidth = 6;
        c.gridx = 1;
        c.gridy = 1;
        window.add(grille, c);                                                      //ajout de la Grille a la fenetre principale

        //===========================================//
        //=======================================//
        //Placement des cartes du Joueur 1
        //=======================================//
        carteJ1 = new VueMain(joueurs.get(0).getMainJoueur(), joueurs.get(0).getRole().getCouleur().getCouleur());
        //carteJ1.setPreferredSize(new Dimension(256, 128));
        carteJ1.setOpaque(false);

        //-----------Lors d'un clic sur les Cartes du Joueurs 1------------//
        carteJ1.addMouseListener(new MouseListener() {                              //permet au joueur de séléctionner une carte
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = getColonne(e.getX());
                int y = getLigne(e.getY());
                if (x < 4 && y < 2) {
                    Message m = new Message();
                    m.type = TypesMessages.CHOIX_CARTE;
                    m.joueurActuel = joueurs.get(0);
                    m.carteSelectionne = carteJ1.getCarte(x, y);
                    if (m.carteSelectionne != null /*&& joueurs.get(0).getNumeroJoueur() == joueurCourant*/) {
                        notifierObservateur(m);
                    }
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //-----------Placement des cartes du Joueur 1 sur la grille------------//
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        grille.add(carteJ1, c);

        //=======================================//
        //Placement des cartes du Joueur 2
        //=======================================//
        carteJ2 = new VueMain(joueurs.get(1).getMainJoueur(), joueurs.get(1).getRole().getCouleur().getCouleur());
        carteJ2.setOpaque(false);

        //-----------Lors d'un clic sur les Cartes du Joueurs 2------------//
        carteJ2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {                              //permet au joueur de séléctionner une carte
                int x = getColonne(e.getX());
                int y = getLigne(e.getY());
                if (x < 4 && y < 2) {
                    Message m = new Message();
                    m.type = TypesMessages.CHOIX_CARTE;
                    m.joueurActuel = joueurs.get(1);
                    m.carteSelectionne = carteJ2.getCarte(x, y);
                    if (m.carteSelectionne != null /*&& joueurs.get(1).getNumeroJoueur() == joueurCourant*/) {
                        notifierObservateur(m);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //-----------Placement des cartes du Joueur 2 sur la grille------------//
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 0;
        grille.add(carteJ2, c);

        //=======================================//
        //Placement des cartes du Joueur 3
        //=======================================//
        if (joueurs.size() > 2) {

            carteJ3 = new VueMain(joueurs.get(2).getMainJoueur(), joueurs.get(2).getRole().getCouleur().getCouleur());
            carteJ3.setOpaque(false);

            //-----------Lors d'un clic sur les Cartes du Joueurs 3------------//
            carteJ3.addMouseListener(new MouseListener() {                          //permet au joueur de séléctionner une carte
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    int x = getColonne(e.getX());
                    int y = getLigne(e.getY());
                    if (x < 4 && y < 2) {
                        Message m = new Message();
                        m.type = TypesMessages.CHOIX_CARTE;
                        m.joueurActuel = joueurs.get(2);
                        m.carteSelectionne = carteJ3.getCarte(x, y);
                        if (m.carteSelectionne != null /*&& joueurs.get(2).getNumeroJoueur() == joueurCourant*/) {
                            notifierObservateur(m);
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

            //-----------Placement des cartes du Joueur 3 sur la grille------------//
            c.weightx = 0;
            c.gridheight = 1;
            c.gridwidth = 2;
            c.gridx = 4;
            c.gridy = 5;
            grille.add(carteJ3, c);

            //=======================================//
            //Placement des cartes du Joueur 4
            //=======================================//
            if (joueurs.size() > 3) {

                carteJ4 = new VueMain(joueurs.get(3).getMainJoueur(), joueurs.get(3).getRole().getCouleur().getCouleur());
                carteJ4.setOpaque(false);

                //-----------Lors d'un clic sur les Cartes du Joueurs 4------------//
                carteJ4.addMouseListener(new MouseListener() {                      //permet au joueur de séléctionner une carte
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        int x = getColonne(e.getX());
                        int y = getLigne(e.getY());
                        if (x < 4 && y < 2) {
                            Message m = new Message();
                            m.type = TypesMessages.CHOIX_CARTE;
                            m.joueurActuel = joueurs.get(3);
                            m.carteSelectionne = carteJ4.getCarte(x, y);
                            if (m.carteSelectionne != null /*&& joueurs.get(0).getNumeroJoueur() == joueurCourant*/) {
                                notifierObservateur(m);
                            }
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });

                //-----------Placement des cartes du Joueur 4 sur la grille------------//
                c.weightx = 0;
                c.gridheight = 1;
                c.gridwidth = 2;
                c.gridx = 0;
                c.gridy = 5;
                grille.add(carteJ4, c);

            }

        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Affichage de la fenetre Principale==========//
        window.pack();
        window.setSize(1080, 806);
        window.setResizable(false);
        window.setVisible(true);

        //============================================//
    }

    public void placerTuiles(HashMap<Coordonnee, Tuile> tuiles) {
        for (Tuile uneTuile : tuiles.values()) {
            if (uneTuile.getNom() != null) {
                int x = uneTuile.getCoordonnee().getY();
                int y = uneTuile.getCoordonnee().getX();
                vuetuile = new VueTuile(uneTuile);
                hmVueTuile.put(uneTuile.getCoordonnee(), vuetuile);
                vuetuile.setPreferredSize(new Dimension(120, 120));
                vuetuile.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Message m = new Message();
                        m.type = TypesMessages.CHOIX_TUILE;
                        m.tuileSelectionne = uneTuile;
                        notifierObservateur(m);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.weighty = 1;
                c.gridx = x;
                c.gridheight = 1;
                c.gridwidth = 1;
                c.gridy = y;
                grille.add(vuetuile, c);
            }

        }
    }

    public void setSurbrillance(HashMap<Coordonnee, Tuile> tuiles) {
        for (Tuile tuile : tuiles.values()) {
            if (tuile.getNom() != null) {
                hmVueTuile.get(tuile.getCoordonnee()).setSurbrillance(true);
            }

        }
    }

    public void setSurbrillanceDefault() {
        for (VueTuile vueTuile : hmVueTuile.values()) {
            vueTuile.setSurbrillance(false);
        }
    }

    public void setTuile(Tuile tuile) {
        hmVueTuile.get(tuile.getCoordonnee()).setTuile(tuile);
    }

    private int getColonne(int x) {
        return (x * 4) / 188;
    }

    private int getLigne(int y) {
        return (y * 2) / 133;
    }

    public void piocherCarteOrange(Joueur joueur, CarteOrange carte, int nbCarte) {
        labelNbCarteO.setText("nb cartes : " + nbCarte);
        switch (joueur.getNumeroJoueur()) {
            case 0:
                carteJ1.ajouterCarte(carte);
                break;
            case 1:
                carteJ2.ajouterCarte(carte);
                break;
            case 2:
                carteJ3.ajouterCarte(carte);
                break;
            default:
                carteJ4.ajouterCarte(carte);
                break;
        }
    }

    public void retirerCarteMainJoueur(Joueur joueur, CarteOrange carte) {
        switch (joueur.getNumeroJoueur()) {
            case 0:
                carteJ1.enleverCarte(carte);
                break;
            case 1:
                carteJ2.enleverCarte(carte);
                break;
            case 2:
                carteJ3.enleverCarte(carte);
                break;
            default:
                carteJ4.enleverCarte(carte);
                break;
        }
    }

    public void DefausserCarte(String nomCarteOrange) {
        ImageIcon CarteOrange = new ImageIcon("DossierImage/imgCartePiocheOrange/" + nomCarteOrange + ".png");
        Image im = CarteOrange.getImage();
        im = im.getScaledInstance(140, 70, Image.SCALE_DEFAULT);
        btnDefausseOrange.setIcon(new ImageIcon(im));
    }

    public void piocherInondation(Tuile tuile, int nbCarte) {
        labelNbCarteI.setText("nb cartes : " + nbCarte);
        ImageIcon CarteInondation = new ImageIcon("DossierImage/imgCartePiocheInondation/" + tuile.getNom().name() + ".png");
        Image im = CarteInondation.getImage();
        im = im.getScaledInstance(140, 70, Image.SCALE_DEFAULT);
        if (tuile.getEtat() != Utils.EtatTuile.COULEE) {
            btnDefausseInondation.setIcon(new ImageIcon(im));
        }
    }

    public void viderDefausseInondation(int nbCarte) {
        labelNbCarteI.setText("nb cartes : " + nbCarte);
        btnDefausseInondation.setIcon(null);
    }

    public void viderDefausseOrange(int nbCarte) {
        labelNbCarteO.setText("nb cartes : " + nbCarte);
        btnDefausseOrange.setIcon(null);
    }

    public void DonnerCarteJoueur(Joueur joueurCourant, Joueur joueurVise, CarteOrange carte) {
        switch (joueurCourant.getNumeroJoueur()) {
            case 0:
                carteJ1.enleverCarte(carte);
                break;
            case 1:
                carteJ2.enleverCarte(carte);
                break;
            case 2:
                carteJ3.enleverCarte(carte);
                break;
            default:
                carteJ4.enleverCarte(carte);
                break;
        }
        switch (joueurVise.getNumeroJoueur()) {
            case 0:
                carteJ1.ajouterCarte(carte);
                break;
            case 1:
                carteJ2.ajouterCarte(carte);
                break;
            case 2:
                carteJ3.ajouterCarte(carte);
                break;
            default:
                carteJ4.ajouterCarte(carte);
                break;
        }
    }

    public void recupererTresor(Joueur joueur) {
        switch (joueur.getNumeroJoueur()) {
            case 0:
                carteJ1.recupererTresor(joueur.getEmplacementJoueur().getCaseTresor());
                break;
            case 1:
                carteJ2.recupererTresor(joueur.getEmplacementJoueur().getCaseTresor());
                break;
            case 2:
                carteJ3.recupererTresor(joueur.getEmplacementJoueur().getCaseTresor());
                break;
            default:
                carteJ4.recupererTresor(joueur.getEmplacementJoueur().getCaseTresor());
                ;
                break;
        }
    }

    public void cliquableRole(int num, boolean bool) {
        switch (num) {
            case 0:
                boutonRole1.setEnabled(bool);
                break;
            case 1:
                boutonRole2.setEnabled(bool);
                break;
            case 2:
                boutonRole3.setEnabled(bool);
                break;
            default:
                boutonRole4.setEnabled(bool);
                break;
        }
    }

    public void cliquableRoleToutTrue() {
        boutonRole1.setEnabled(true);
        boutonRole2.setEnabled(true);
        if (joueurs.size() > 2) {
            boutonRole3.setEnabled(true);
            if (joueurs.size() > 3) {
                boutonRole4.setEnabled(true);
            }
        }
    }

    public void cliquableRoleToutFalse() {
        boutonRole1.setEnabled(false);
        boutonRole2.setEnabled(false);
        if (joueurs.size() > 2) {
            boutonRole3.setEnabled(false);
            if (joueurs.size() > 3) {
                boutonRole4.setEnabled(false);
            }
        }
    }

    public void setVisible(boolean bool) {
        window.setVisible(bool);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//*La grille comporte des panels a ses 4 coins contenant chacun la liste de carte du joueur qui lui est associé ce qui permet
//un gain de place sur la fenetre du jeu.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
