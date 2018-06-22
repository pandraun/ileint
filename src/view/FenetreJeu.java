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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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
    private JButton caliceAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/calice.png")));
    private JButton calicePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/calice.png")));
    private JButton cristalAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/cristal.png")));
    private JButton cristalPresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/cristal.png")));
    private JButton pierreAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/pierre.png")));
    private JButton pierrePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/pierre.png")));
    private JButton statueAbsent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/absent/statue.png")));
    private JButton statuePresent = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/Anne-Gaisne/IleInterdite/master/IleInterdite/images/Tr%C3%A9sors/present/statue.png")));

    private JButton piocheOrange;
    private JButton btnDefausseOrange;
    private JButton btnPiocheOrange;
    private JButton btnPiocheInondation;
    private JButton btnDefausseInondation;
    private VueMain carteJ1;
    private VueMain carteJ2;
    private VueMain carteJ3;
    private VueMain carteJ4;

    GridBagConstraints c = new GridBagConstraints();

    public FenetreJeu(ArrayList<Joueur> joueurs, Stack<CarteOrange> piocheOrange, Stack<CarteInondation> piocheInondation) throws MalformedURLException {

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();

        this.window = new JFrame("Fenetre Jeu");
        JLabel contentPane = new JLabel();
        //ImagePanel panel = new ImagePanel(new ImageIcon(new URL ("http://image.jeuxvideo.com/downloads/fonds-ecrans-wallpaper/00011568/xenoblade-chronicles-wii-29571-wp.jpg")).getImage());
        contentPane.setIcon(new ImageIcon(new URL("https://aaronsinternetwhispersblog.files.wordpress.com/2011/12/sea_bg.png")));
        //window.add(panel);
        window.setContentPane(contentPane);
        window.setLayout(new GridBagLayout());
        //====================================è==//

        JPanel role1 = new JPanel();
        role1.setOpaque(false);
        role1.setLayout(new BoxLayout(role1, BoxLayout.Y_AXIS));
        JButton boutonRole1 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(0).getRole().getNom() + ".png"));

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

        //-----------------------//
        boutonRole1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FenetrePopupDebutTour fen = new FenetrePopupDebutTour(joueurs.get(0).getRole().getNom());
                } catch (IOException ex) {
                    Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //======================================//
        JPanel role2 = new JPanel();
        role2.setOpaque(false);
        role2.setLayout(new BoxLayout(role2, BoxLayout.Y_AXIS));
        JButton boutonRole2 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(1).getRole().getNom() + ".png"));
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

        //-----------------------//
        boutonRole2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FenetrePopupDebutTour fen = new FenetrePopupDebutTour(joueurs.get(1).getRole().getNom());
                } catch (IOException ex) {
                    Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //======================================//
        JPanel panelOrange = new JPanel(new GridLayout(2, 1, 4, 4));
        panelOrange.setOpaque(false);
        ImageIcon carteRouge = new ImageIcon("DossierImage/imgCarte/Fond rouge.png");
        Image im = carteRouge.getImage();
        int hauteur = 110;
        int largeur = 140;
        im = im.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
        btnPiocheOrange = new JButton(new ImageIcon(im));
        btnPiocheOrange.setContentAreaFilled(false);
        //piocheOrange.setSize(new Dimension(100,70));
        btnDefausseOrange = new JButton();
        btnDefausseOrange.setContentAreaFilled(false);
        //defausseOrange.setSize(new Dimension(100,70));
        panelOrange.add(btnPiocheOrange);
        panelOrange.add(btnDefausseOrange);
        panelOrange.setPreferredSize(new Dimension(140, 140));

        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 2;
        window.add(panelOrange, c);

        //Action de pioche Orange
        btnPiocheOrange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.PIOCHER_CARTE_ORANGE;
                notifierObservateur(m);
            }
        });

        JPanel panelInondation = new JPanel(new GridLayout(2, 1, 4, 4));
        panelInondation.setOpaque(false);
        ImageIcon CarteBleu = new ImageIcon("DossierImage/imgCarte/Fond bleu.png");
        im = CarteBleu.getImage();
        hauteur = 110;
        largeur = 140;
        im = im.getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT);
        btnPiocheInondation = new JButton(new ImageIcon(im));
        btnPiocheInondation.setContentAreaFilled(false);
        //piocheInondation.setSize(new Dimension(100,70));
        btnDefausseInondation = new JButton();
        btnDefausseInondation.setContentAreaFilled(false);
        //defausseInondation.setSize(new Dimension(100,70));
        panelInondation.add(btnPiocheInondation);
        panelInondation.add(btnDefausseInondation);
        panelInondation.setPreferredSize(new Dimension(140, 140));

        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 2;
        window.add(panelInondation, c);

        /*//Action de pioche Inondation
        btnPiocheInondation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.PIOCHER_CARTE_ORANGE;
                notifierObservateur(m);                                                 //.peek()
                btnDefausseInondation = new JButton(new ImageIcon("DossierImage/imgCarte/"+defausseInondation.firstElement().getTuile().getNom()+".png"));

            }
        });*/
        //======================================//
        if (joueurs.size() > 2) {

            JPanel role3 = new JPanel();
            role3.setOpaque(false);
            role3.setLayout(new BoxLayout(role3, BoxLayout.Y_AXIS));
            JLabel EmplacementRole3 = new JLabel("J3: " + joueurs.get(2).getNomJoueur());
            role3.add(EmplacementRole3);
            JButton boutonRole3 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(2).getRole().getNom() + ".png"));
            role3.add(boutonRole3);
            boutonRole3.setContentAreaFilled(false);
            boutonRole3.setPreferredSize(new Dimension(150, 210));
            boutonRole3.setOpaque(false);
            c.anchor = GridBagConstraints.LAST_LINE_START;
            c.gridheight = 2;
            c.gridx = 7;
            c.gridy = 4;
            window.add(role3, c);

            //-----------------------//
            boutonRole3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        FenetrePopupDebutTour fen = new FenetrePopupDebutTour(joueurs.get(2).getRole().getNom());
                    } catch (IOException ex) {
                        Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            //======================================//
            if (joueurs.size() > 3) {

                JPanel role4 = new JPanel();
                role4.setOpaque(false);
                role4.setLayout(new BoxLayout(role4, BoxLayout.Y_AXIS));
                JLabel EmplacementRole4 = new JLabel("J4: " + joueurs.get(3).getNomJoueur());
                role4.add(EmplacementRole4);
                JButton boutonRole4 = new JButton(new ImageIcon("DossierImage/RoleAventurier/" + joueurs.get(3).getRole().getRoleAventurier() + ".png"));
                role4.add(boutonRole4);
                boutonRole4.setPreferredSize(new Dimension(150, 210));
                boutonRole4.setContentAreaFilled(false);
                c.anchor = GridBagConstraints.LAST_LINE_END;
                c.gridheight = 2;
                c.gridx = 0;
                c.gridy = 4;
                window.add(role4, c);

                //-----------------------//
                boutonRole4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FenetrePopupDebutTour fen = new FenetrePopupDebutTour(joueurs.get(3).getRole().getNom());
                        } catch (IOException ex) {
                            Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            }

            //======================================//
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        
        grille = new JPanel(new GridBagLayout());
        grille.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 5;
        c.gridheight = 6;
        c.gridwidth = 6;
        c.gridx = 1;
        c.gridy = 1;
        window.add(grille, c);

        carteJ1 = new VueMain(joueurs.get(0).getMainJoueur());
        //carteJ1.setPreferredSize(new Dimension(256, 128));
        carteJ1.setOpaque(false);
        carteJ1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                int x = getColonne(e.getX());
                int y = getLigne(e.getY());
                Message m = new Message();
                m.type = TypesMessages.CHOIX_CARTE;
                m.carteSelectionne = carteJ1.getCarte(x, y);
                if (m.carteSelectionne != null) {
                    notifierObservateur(m);
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
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        grille.add(carteJ1, c);
        
        carteJ2 = new VueMain(joueurs.get(1).getMainJoueur());
        carteJ2.setOpaque(false);
        carteJ2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                int x = getColonne(e.getX());
                int y = getLigne(e.getY());
                Message m = new Message();
                m.type = TypesMessages.CHOIX_CARTE;
                m.carteSelectionne = carteJ2.getCarte(x, y);
                if (m.carteSelectionne != null) {
                    notifierObservateur(m);
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
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 0;
        grille.add(carteJ2, c);
        
        if (joueurs.size() > 2) {
            
            carteJ3 = new VueMain(joueurs.get(2).getMainJoueur());
            carteJ3.setOpaque(false);
            carteJ3.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = getColonne(e.getX());
                    int y = getLigne(e.getY());
                    Message m = new Message();
                    m.type = TypesMessages.CHOIX_CARTE;
                    m.carteSelectionne = carteJ3.getCarte(x, y);
                    if (m.carteSelectionne != null) {
                        notifierObservateur(m);
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
            c.weightx = 0;
            c.gridheight = 1;
            c.gridwidth = 2;
            c.gridx = 4;
            c.gridy = 5;
            grille.add(carteJ3, c);

            if (joueurs.size() > 3) {
            
                carteJ4 = new VueMain(joueurs.get(3).getMainJoueur());
                carteJ4.setOpaque(false);
                carteJ4.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int x = getColonne(e.getX());
                        int y = getLigne(e.getY());
                        Message m = new Message();
                        m.type = TypesMessages.CHOIX_CARTE;
                        m.carteSelectionne = carteJ4.getCarte(x, y);
                        if (m.carteSelectionne != null) {
                            notifierObservateur(m);
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
                c.weightx = 0;
                c.gridheight = 1;
                c.gridwidth = 2;
                c.gridx = 0;
                c.gridy = 5;
                grille.add(carteJ4, c);

            }
        
        }
                window.pack();
                window.setSize(1080, 806);
                window.setResizable(false);
                window.setVisible(true);
            
            
        
    }

    public void piocheCliquable(Boolean boo) {
        piocheOrange.setEnabled(boo);
    }

    public void placerTuiles(HashMap<Coordonnee, Tuile> tuiles) {
        for (Tuile uneTuile : tuiles.values()) {
            if (uneTuile.getNom() != null) {
                int x = uneTuile.getCoordonnee().getY();
                int y = uneTuile.getCoordonnee().getX();
                vuetuile = new VueTuile(uneTuile);
                vuetuile.setPreferredSize(new Dimension(120, 120));
                vuetuile.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("clique sur : " + uneTuile.getNom().toString());
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
    
    private int getColonne(int x) {
        return (x * 4) / 168;
    }
    
    private int getLigne(int y) {
        return (y * 2) / 128;
    }
    
    public void piocherCarteOrange(Joueur joueur, CarteOrange carte){
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
    

    public void piocherCarteInondation() {
        //ImageIcon CarteOrange = new ImageIcon("DossierImage/imgCartePiocheOrange/" + carte. + ".png");
        //Image im = CarteOrange.getImage();
        //im = im.getScaledInstance(140, 70, Image.SCALE_DEFAULT);
        //btnDefausseOrange.setIcon(new ImageIcon(im));
    }

    public void ajouterCarteMainJoueur() {
        
    }

    public void retirerCarteMainJoueur(Joueur joueur, CarteOrange carte) {
        
        if(carte.getTypeTresor()!=null){
            DefausserCarte(carte.getTypeTresor().name());
        }else{
            DefausserCarte(carte.getTypeClasse());
        }
            
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
        System.out.println("nom Carte : /"+nomCarteOrange+"/");
        ImageIcon CarteOrange = new ImageIcon("DossierImage/imgCartePiocheOrange/" + nomCarteOrange + ".png");
        Image im = CarteOrange.getImage();
        im = im.getScaledInstance(140, 70, Image.SCALE_DEFAULT);
        btnDefausseOrange.setIcon(new ImageIcon(im));
    }

}


/*public void placerMainJoueur(ArrayList<Joueur> joueurs){
        for(Joueur unJoueur : joueurs){
            for(CarteOrange uneCarte : unJoueur.getMainJoueur()){
                ajouterCarteMainJoueur();
                if (uneCarte.getTypeTresor()!=null){
                    ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeTresor()+".png");
                    Image im = Carte.getImage();
                    im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                    JButton carteJoueur = new JButton(new ImageIcon(im));
                    carteJoueur.setMinimumSize(new Dimension(24, 14));
                    carteJoueur.setMaximumSize(new Dimension(24, 14));
                    carteJoueur.setPreferredSize(new Dimension(24, 14));
                    //carteJoueur.setSize(new Dimension(35,64));
                    //carteJoueur.setPreferredSize(new Dimension());
                    switch (unJoueur.getNumeroJoueur()) {
                        case 0:
                            nbCarteJ1 +=1;
                            nbCaseCarteJ1 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ1%4;
                            if (nbCaseCarteJ1<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m);  
                                    
                                    nbCarteJ1 -=1;
                                    carteJ1.remove(carteJoueur);
                                    carteJ1.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ1.setVisible(false);
                                    carteJ1.setVisible(true);
                                }
                            });
                            
                            carteJ1.add(carteJoueur,c);
                            break;
                        case 1:
                            nbCarteJ2 +=1;
                            nbCaseCarteJ2 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ2%4;
                            if (nbCaseCarteJ2<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m); 
                                    
                                    nbCarteJ2 -=1;
                                    carteJ2.remove(carteJoueur);
                                    carteJ2.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ2.setVisible(false);
                                    carteJ2.setVisible(true);
                                }
                            });
                            
                            carteJ2.add(carteJoueur,c);
                            break;
                        case 2:
                            nbCarteJ3 +=1;
                            nbCaseCarteJ3 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ3%4;
                            if (nbCaseCarteJ3<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m); 
                                    
                                    nbCarteJ3 -=1;
                                    carteJ3.remove(carteJoueur);
                                    carteJ3.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ3.setVisible(false);
                                    carteJ3.setVisible(true);
                                }
                            });
                            
                            carteJ3.add(carteJoueur,c);
                            break;
                        default:
                            nbCarteJ4 +=1;
                            nbCaseCarteJ4 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ4%4;
                            if (nbCaseCarteJ4<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m); 
                                    
                                    nbCarteJ4 -=1;
                                    carteJ4.remove(carteJoueur);
                                    carteJ4.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ4.setVisible(false);
                                    carteJ4.setVisible(true);
                                }
                            });
                            
                            carteJ4.add(carteJoueur,c);
                            break;
                    }
                }else{
                    ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeClasse()+".png");
                    Image im = Carte.getImage();
                    im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                    JButton carteJoueur = new JButton(new ImageIcon(im));
                    carteJoueur.setMinimumSize(new Dimension(24, 14));
                    carteJoueur.setMaximumSize(new Dimension(24, 14));
                    carteJoueur.setPreferredSize(new Dimension(24, 14));
                    //carteJoueur.setSize(new Dimension(35,64));
                    switch (unJoueur.getNumeroJoueur()) {
                        case 0:
                            nbCarteJ1 +=1;
                            nbCaseCarteJ1 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ1%4;
                            if (nbCaseCarteJ1<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m); 
                                    
                                    nbCarteJ1 -=1;
                                    carteJ1.remove(carteJoueur);
                                    carteJ1.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ1.setVisible(false);
                                    carteJ1.setVisible(true);
                                }
                            });
                            
                            carteJ1.add(carteJoueur,c);
                            break;
                        case 1:
                            nbCarteJ2 +=1;
                            nbCaseCarteJ2 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ2%4;
                            if (nbCaseCarteJ2<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m);  
                                    
                                    nbCarteJ2 -=1;
                                    carteJ2.remove(carteJoueur);
                                    carteJ2.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ2.setVisible(false);
                                    carteJ2.setVisible(true);
                                }
                            });
                            
                            carteJ2.add(carteJoueur,c);
                            break;
                        case 2:
                            nbCarteJ3 +=1;
                            nbCaseCarteJ3 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ3%4;
                            if (nbCaseCarteJ3<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m);  
                                    
                                    nbCarteJ3 -=1;
                                    carteJ3.remove(carteJoueur);
                                    carteJ3.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ3.setVisible(false);
                                    carteJ3.setVisible(true);
                                }
                            });
                            
                            carteJ3.add(carteJoueur,c);
                            break;
                        default:
                            nbCarteJ4 +=1;
                            nbCaseCarteJ4 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ4%4;
                            if (nbCaseCarteJ4<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJoueur.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message();
                                    m.type = TypesMessages.CHOIX_CARTE;
                                    m.carteSelectionne = uneCarte;
                                    notifierObservateur(m); 
                                    
                                    nbCarteJ4 -=1;
                                    carteJ4.remove(carteJoueur);
                                    carteJ4.add(new JLabel(""));
                                    //placerMainJoueur(joueurs);
                                    carteJ4.setVisible(false);
                                    carteJ4.setVisible(true);
                                }
                            });
                            
                            carteJ4.add(carteJoueur,c);
                            break;
                    }
                }
            }
            if(unJoueur.getMainJoueur().size()<8){
                for(int i = 0; i<7-unJoueur.getMainJoueur().size(); i++){
                    switch (unJoueur.getNumeroJoueur()) {
                        case 0:
                            nbCaseCarteJ1 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ1;
                            if (nbCaseCarteJ1<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            carteJ1.add(new JLabel(""),c);
                            break;
                        case 1:
                            nbCaseCarteJ2 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ2;
                            if (nbCaseCarteJ2<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJ2.add(new JLabel(""),c);
                            break;
                        case 2:
                            nbCaseCarteJ3 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ3;
                            if (nbCaseCarteJ3<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJ3.add(new JLabel(""),c);
                            break;
                        default:
                            nbCaseCarteJ4 += 1;
                            //c.fill = GridBagConstraints.BOTH;
                            c.gridheight = 1;
                            c.gridwidth = 1;
                            c.gridx = nbCaseCarteJ4;
                            if (nbCaseCarteJ4<4){
                                c.gridy = 0;
                            }else{
                                c.gridy = 1;
                            }
                            
                            carteJ4.add(new JLabel(""),c);
                            break;
                    }
                }
            }
        }
    }*/
