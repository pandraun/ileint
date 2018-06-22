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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
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
public class FenetreJeu extends Observe{

    private JFrame window;
    private JPanel grille;
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
    private JPanel carteJ1;
    private int nbCarteJ1 = 0;
    private int nbCaseCarteJ1 = 0;
    private JPanel carteJ2;
    private int nbCarteJ2 = 0;
    private int nbCaseCarteJ2 = 0;
    private JPanel carteJ3;
    private int nbCarteJ3 = 0;
    private int nbCaseCarteJ3 = 0;
    private JPanel carteJ4;
    private int nbCarteJ4 = 0;
    private int nbCaseCarteJ4 = 0;
    
    GridBagConstraints c = new GridBagConstraints();
    
    public FenetreJeu(ArrayList<Joueur> joueurs, Stack<CarteOrange> piocheOrange, Stack<CarteInondation> piocheInondation) throws MalformedURLException{

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();

        this.window = new JFrame("Fenetre Jeu");
        JLabel contentPane = new JLabel();
        //ImagePanel panel = new ImagePanel(new ImageIcon(new URL ("http://image.jeuxvideo.com/downloads/fonds-ecrans-wallpaper/00011568/xenoblade-chronicles-wii-29571-wp.jpg")).getImage());
        contentPane.setIcon( new ImageIcon(new URL ("https://aaronsinternetwhispersblog.files.wordpress.com/2011/12/sea_bg.png")));
        //window.add(panel);
        window.setContentPane( contentPane );
        window.setLayout(new GridBagLayout());        
        //====================================è==//
        
        JPanel role1 = new JPanel();
        role1.setOpaque(false);
        role1.setLayout(new BoxLayout(role1, BoxLayout.Y_AXIS));
        JButton boutonRole1 = new JButton(new ImageIcon("DossierImage/RoleAventurier/"+joueurs.get(0).getRole().getNom()+".png"));

        role1.add(boutonRole1);
        boutonRole1.setPreferredSize(new Dimension(150,210));
        JLabel EmplacementRole1 = new JLabel("J1: "+joueurs.get(0).getNomJoueur());
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
        window.add(role1,c);

        //======================================//

        JPanel role2 = new JPanel();
        role2.setOpaque(false);
        role2.setLayout(new BoxLayout(role2, BoxLayout.Y_AXIS));
        JButton boutonRole2 = new JButton(new ImageIcon("DossierImage/RoleAventurier/"+joueurs.get(1).getRole().getNom()+".png"));
        role2.add(boutonRole2);
        boutonRole2.setPreferredSize(new Dimension(150,210));
        JLabel EmplacementRole2 = new JLabel("J2: "+joueurs.get(1).getNomJoueur());
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
        window.add(role2,c);

        //======================================//
        
        JPanel panelOrange = new JPanel(new GridLayout(2,1,4,4));
        panelOrange.setOpaque(false);
        ImageIcon carteRouge = new ImageIcon("DossierImage/imgCarte/Fond rouge.png");
        Image im = carteRouge.getImage();
        int hauteur = 110;
        int largeur = 140;
        im = im.getScaledInstance(largeur,hauteur,Image.SCALE_DEFAULT);
        btnPiocheOrange = new JButton(new ImageIcon(im));
        btnPiocheOrange.setContentAreaFilled(false);
        //piocheOrange.setSize(new Dimension(100,70));
        btnDefausseOrange = new JButton();
        btnDefausseOrange.setContentAreaFilled(false);
        //defausseOrange.setSize(new Dimension(100,70));
        panelOrange.add(btnPiocheOrange);
        panelOrange.add(btnDefausseOrange);
        panelOrange.setPreferredSize(new Dimension(140,140));
        
        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 2;
        window.add(panelOrange,c);
        
        //Action de pioche Orange
        btnPiocheOrange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.PIOCHER_CARTE_ORANGE;
                notifierObservateur(m);
            }
        });
        
        
        JPanel panelInondation = new JPanel(new GridLayout(2,1,4,4));
        panelInondation.setOpaque(false);
        ImageIcon CarteBleu = new ImageIcon("DossierImage/imgCarte/Fond bleu.png");
        im = CarteBleu.getImage();
        hauteur = 110;
        largeur = 140;
        im = im.getScaledInstance(largeur,hauteur,Image.SCALE_DEFAULT);
        btnPiocheInondation = new JButton(new ImageIcon(im));
        btnPiocheInondation.setContentAreaFilled(false);
        //piocheInondation.setSize(new Dimension(100,70));
        btnDefausseInondation = new JButton();
        btnDefausseInondation.setContentAreaFilled(false);
        //defausseInondation.setSize(new Dimension(100,70));
        panelInondation.add(btnPiocheInondation);
        panelInondation.add(btnDefausseInondation);
        panelInondation.setPreferredSize(new Dimension(140,140));
        
        c.weighty = 20;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridheight = 2;
        c.gridx = 7;
        c.gridy = 2;
        window.add(panelInondation,c);
        
        
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

        
        if (joueurs.size()>2){
        
            JPanel role3 = new JPanel();
            role3.setOpaque(false);
            role3.setLayout(new BoxLayout(role3, BoxLayout.Y_AXIS));
            JLabel EmplacementRole3 = new JLabel("J3: "+joueurs.get(2).getNomJoueur());
            role3.add(EmplacementRole3);
            JButton boutonRole3 = new JButton(new ImageIcon("DossierImage/RoleAventurier/"+joueurs.get(2).getRole().getNom()+".png"));
            role3.add(boutonRole3);
            boutonRole3.setContentAreaFilled(false);
            boutonRole3.setPreferredSize(new Dimension(150,210));
            boutonRole3.setOpaque(false);
            c.anchor = GridBagConstraints.LAST_LINE_START;
            c.gridheight = 2;
            c.gridx = 7;
            c.gridy = 4;
            window.add(role3,c);

            //======================================//

            if(joueurs.size()>3){

                JPanel role4 = new JPanel();
                role4.setOpaque(false);
                role4.setLayout(new BoxLayout(role4, BoxLayout.Y_AXIS));
                JLabel EmplacementRole4 = new JLabel("J4: "+joueurs.get(3).getNomJoueur());
                role4.add(EmplacementRole4);
                JButton boutonRole4 = new JButton(new ImageIcon("DossierImage/RoleAventurier/"+joueurs.get(3).getRole().getRoleAventurier()+".png"));
                role4.add(boutonRole4);
                boutonRole4.setPreferredSize(new Dimension(150,210));
                boutonRole4.setContentAreaFilled(false);
                c.anchor = GridBagConstraints.LAST_LINE_END;
                c.gridheight = 2;
                c.gridx = 0;
                c.gridy = 4;
                window.add(role4,c);

            }

            //======================================//
            
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////:
        
        grille = new JPanel(new GridBagLayout()); grille.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 5;
        c.gridheight = 6;
        c.gridwidth = 6;
        c.gridx = 1;
        c.gridy = 1;
        window.add(grille,c);
        
        carteJ1 = new JPanel(new GridBagLayout());
        carteJ1.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        grille.add(carteJ1,c);
        carteJ2 = new JPanel(new GridBagLayout());
        carteJ2.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 0;
        grille.add(carteJ2,c);
        carteJ3 = new JPanel(new GridBagLayout());
        carteJ3.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 5;
        grille.add(carteJ3,c);
        carteJ4 = new JPanel(new GridBagLayout());
        carteJ4.setOpaque(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 5;
        grille.add(carteJ4,c);
        
        placerMainJoueur(joueurs); 
        
        window.pack();
        window.setSize(1080, 806);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public void piocheCliquable(Boolean boo){
        piocheOrange.setEnabled(boo);
    }
    
    public void placerTuiles(HashMap<Coordonnee,Tuile> tuiles){
        for(Tuile uneTuile : tuiles.values()){
            if (uneTuile.getNom()!=null){
                int x = uneTuile.getCoordonnee().getX();
                int y = uneTuile.getCoordonnee().getY();
                /*JButton tuile = new JButton(new ImageIcon("DossierImage/Tuiles/"+uneTuile.getNom()+".png"));*/
                VueTuile tuile = new VueTuile(uneTuile);
                tuile.setPreferredSize(new Dimension(120,120));
                //tuile.setContentAreaFilled(false);                
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.weighty = 1;
                c.gridx = x;
                c.gridheight = 1;
                c.gridwidth = 1;
                c.gridy = y;
                grille.add(tuile,c);
            }


        }
    }
    
    public void placerMainJoueur(ArrayList<Joueur> joueurs){
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
    }
    
    
    
    public void piocherCarteOrange(ArrayList<Joueur> joueurs){
        carteJ1.removeAll();
        carteJ2.removeAll();
        carteJ3.removeAll();
        carteJ4.removeAll();
        //placerMainJoueur(joueurs);
        /*if (numeroJoueur==0){
            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+nomCarteOrange+".png");
            Image im = Carte.getImage();
            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
            JButton carteJoueur = new JButton(new ImageIcon(im));
            System.out.println("nbCarteJoueur "+numeroJoueur+" : "+nbCarteJ1);
            nbCarteJ1 += 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            if (nbCarteJ1<4){
                c.gridx = nbCarteJ1;
                c.gridy = 0;
            }else{
                c.gridx = nbCarteJ1%4;
                c.gridy = 1;
            }
            carteJ1.add(carteJoueur,c);
        }else if (numeroJoueur==1){
            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+nomCarteOrange+".png");
            Image im = Carte.getImage();
            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
            JButton carteJoueur = new JButton(new ImageIcon(im));
            System.out.println("nbCarteJoueur "+numeroJoueur+" : "+nbCarteJ2);
            nbCarteJ2 += 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            if (nbCarteJ2<4){
                c.gridx = nbCarteJ2;
                c.gridy = 0;
            }else{
                c.gridx = nbCarteJ2%4;
                c.gridy = 1;
            }
            carteJ1.add(carteJoueur,c);
        }else if (numeroJoueur==1){
            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+nomCarteOrange+".png");
            Image im = Carte.getImage();
            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
            JButton carteJoueur = new JButton(new ImageIcon(im));
            System.out.println("nbCarteJoueur "+numeroJoueur+" : "+nbCarteJ3);
            nbCarteJ3 += 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            if (nbCarteJ3<4){
                c.gridx = nbCarteJ3;
                c.gridy = 0;
            }else{
                c.gridx = nbCarteJ3%4;
                c.gridy = 1;
            }
            carteJ1.add(carteJoueur,c);
        }else{
            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+nomCarteOrange+".png");
            Image im = Carte.getImage();
            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
            JButton carteJoueur = new JButton(new ImageIcon(im));
            System.out.println("nbCarteJoueur "+numeroJoueur+" : "+nbCarteJ4);
            nbCarteJ4 += 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            if (nbCarteJ4<4){
                c.gridx = nbCarteJ4;
                c.gridy = 0;
            }else{
                c.gridx = nbCarteJ4%4;
                c.gridy = 1;
            }
            carteJ1.add(carteJoueur,c);
        }*/
    }
    
    public void piocherCarteInondation(String nomCarteInodation){
        
    }
    
    
    public void ajouterCarteMainJoueur(){
        
    }
    
    public void retirerCarteMainJoueur(ArrayList<Joueur> joueurs){
        carteJ1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                carteJ1.removeAll();
                carteJ1.setVisible(false);
                carteJ1.setVisible(true);
                nbCarteJ1 -= 1;
                nbCaseCarteJ1 = 0;
                
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
                            nbCarteJ1 +=1;
                            nbCaseCarteJ1 += 1;
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
                                }
                            });
                            carteJ1.add(carteJoueur,c);
                        }else{
                            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeClasse()+".png");
                            Image im = Carte.getImage();
                            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                            JButton carteJoueur = new JButton(new ImageIcon(im));
                            carteJoueur.setMinimumSize(new Dimension(24, 14));
                            carteJoueur.setMaximumSize(new Dimension(24, 14));
                            carteJoueur.setPreferredSize(new Dimension(24, 14));
                            //carteJoueur.setSize(new Dimension(35,64));
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
                                }
                            });
                            carteJ1.add(carteJoueur,c);
                        }
                    }
                    if(unJoueur.getMainJoueur().size()<8){
                        for(int i = 0; i<7-unJoueur.getMainJoueur().size(); i++){
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
                        }
                    }    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        carteJ2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                carteJ2.removeAll();
                carteJ2.setVisible(false);
                carteJ2.setVisible(true);
                nbCarteJ2 -= 1;
                nbCaseCarteJ2 = 0;
                
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
                            nbCarteJ2 +=1;
                            nbCaseCarteJ2 += 1;
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
                                }
                            });
                            carteJ2.add(carteJoueur,c);
                        }else{
                            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeClasse()+".png");
                            Image im = Carte.getImage();
                            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                            JButton carteJoueur = new JButton(new ImageIcon(im));
                            carteJoueur.setMinimumSize(new Dimension(24, 14));
                            carteJoueur.setMaximumSize(new Dimension(24, 14));
                            carteJoueur.setPreferredSize(new Dimension(24, 14));
                            //carteJoueur.setSize(new Dimension(35,64));
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
                                }
                            });
                            carteJ2.add(carteJoueur,c);
                        }
                    }
                    if(unJoueur.getMainJoueur().size()<8){
                        for(int i = 0; i<7-unJoueur.getMainJoueur().size(); i++){
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
                        }
                    }    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        carteJ3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                carteJ3.removeAll();
                carteJ3.setVisible(false);
                carteJ3.setVisible(true);
                nbCarteJ3 -= 1;
                nbCaseCarteJ3 = 0;
                
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
                            nbCarteJ3 +=1;
                            nbCaseCarteJ3 += 1;
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
                                }
                            });
                            carteJ3.add(carteJoueur,c);
                        }else{
                            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeClasse()+".png");
                            Image im = Carte.getImage();
                            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                            JButton carteJoueur = new JButton(new ImageIcon(im));
                            carteJoueur.setMinimumSize(new Dimension(24, 14));
                            carteJoueur.setMaximumSize(new Dimension(24, 14));
                            carteJoueur.setPreferredSize(new Dimension(24, 14));
                            //carteJoueur.setSize(new Dimension(35,64));
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
                                }
                            });
                            carteJ3.add(carteJoueur,c);
                        }
                    }
                    if(unJoueur.getMainJoueur().size()<8){
                        for(int i = 0; i<7-unJoueur.getMainJoueur().size(); i++){
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
                        }
                    }    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        carteJ4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                carteJ4.removeAll();
                carteJ4.setVisible(false);
                carteJ4.setVisible(true);
                nbCarteJ4 -= 1;
                nbCaseCarteJ4 = 0;
                
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
                            nbCarteJ4 +=1;
                            nbCaseCarteJ4 += 1;
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
                                }
                            });
                            carteJ4.add(carteJoueur,c);
                        }else{
                            ImageIcon Carte = new ImageIcon("DossierImage/AutreCarteJoueur/"+uneCarte.getTypeClasse()+".png");
                            Image im = Carte.getImage();
                            im = im.getScaledInstance(54,85,Image.SCALE_DEFAULT);
                            JButton carteJoueur = new JButton(new ImageIcon(im));
                            carteJoueur.setMinimumSize(new Dimension(24, 14));
                            carteJoueur.setMaximumSize(new Dimension(24, 14));
                            carteJoueur.setPreferredSize(new Dimension(24, 14));
                            //carteJoueur.setSize(new Dimension(35,64));
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
                                }
                            });
                            carteJ4.add(carteJoueur,c);
                        }
                    }
                    if(unJoueur.getMainJoueur().size()<8){
                        for(int i = 0; i<7-unJoueur.getMainJoueur().size(); i++){
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
                        }
                    }    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        //placerMainJoueur(joueurs);
    }
    
    public void DefausserCarte(String nomCarteOrange){
        btnDefausseInondation = new JButton(new ImageIcon("DossierImage/imgCartePiocheOrange/"+nomCarteOrange+".png"));
    }
    
}




/*carteJ1 = new JPanel(new GridLayout(2,3));
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        grille.add(carteJ1,c);
        carteJ2 = new JPanel(new GridLayout(2,3));
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 0;
        grille.add(carteJ2,c);
        carteJ3 = new JPanel(new GridLayout(2,3));
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 5;
        grille.add(carteJ3,c);
        carteJ4 = new JPanel(new GridLayout(2,3));
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 5;
        grille.add(carteJ4,c);*/
        
        //PlacerMainJoueur(joueurs);
        
        
        
        /*ImageIcon calice = new ImageIcon("DossierImage/imgCarte/Calice.png");
        im = calice.getImage();
        hauteur = 64;
        largeur = 35;
        im = im.getScaledInstance(largeur,hauteur,Image.SCALE_DEFAULT);
        
        
                    JPanel Cartej11 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej11.add(new JButton(new ImageIcon(im)));
                    }
                    grille.add(Cartej11);
                    break;
                case 1:
                    JPanel Cartej12 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 0:
                            case 1:
                            case 3:
                                Cartej12.add(new JButton(new ImageIcon(im)));
                                break;
                            default:
                                Cartej12.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej12);
                    }
                    break;
                case 4:
                    JPanel Cartej21 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 1:
                            case 2:
                            case 5:
                                Cartej21.add(new JButton(new ImageIcon(im)));
                                break;
                            default:
                                Cartej21.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej21);
                    }
                    break;
                case 5:
                    JPanel Cartej22 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej22.add(new JButton(new ImageIcon(im)));
                    }
                    grille.add(Cartej22);
                    break;
                case 30:
                    JPanel Cartej31 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej31.add(new JButton(new ImageIcon(im)));
                    }
                    grille.add(Cartej31);
                    break;
                case 31:
                    JPanel Cartej32 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 0:
                            case 3:
                            case 4:
                                Cartej32.add(new JButton(new ImageIcon(im)));
                                break;
                            default:
                                Cartej32.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej32);
                    }
                    break;
                case 34:
                    JPanel Cartej41 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        switch(j){
                            case 2:
                            case 4:
                            case 5:
                                Cartej41.add(new JButton(new ImageIcon(im)));
                                break;
                            default:
                                Cartej41.add(new JLabel());
                                break;
                        }
                        grille.add(Cartej41);
                    }
                    break;
                case 35:
                    JPanel Cartej42 = new JPanel(new GridLayout(2,3,10,4));
                    for(int j = 0; j < 6; j++){
                        Cartej42.add(new JButton(new ImageIcon(im)));
                    }
                    grille.add(Cartej42);
                    break;
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 32:
                case 33:
                    /*ImageIcon calice = new ImageIcon("DossierImage/imgCarte/Calice.png");
                    im = calice.getImage();
                    hauteur = 64;
                    largeur = 35;
                    im = im.getScaledInstance(largeur,hauteur,Image.SCALE_DEFAULT);
                    JButton tuile = new JButton(new ImageIcon("DossierImage/TuilesV2/Heliport_120x120.png"));
                    tuile.setPreferredSize(new Dimension(120,120));
                    tuile.setOpaque(false);
                    grille.add(tuile);
                    
                    tuile.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(tuile.getWidth());
                                System.out.println(tuile.getHeight());
                            }
                        });
                    
                    break;
                default:
                    JPanel caseVide = new JPanel();
                    grille.add(caseVide);
                    break;
                }

            }*/
