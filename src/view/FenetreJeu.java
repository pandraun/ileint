/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import util.Utils;

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
        window.setLayout(new GridLayout(6, 8, 10, 10));
        for (int i = 0; i < 48; i++) {
            switch (i) {
                case 0:
                    //JButton role = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/explorateur.png")));
                    //window.add(role);

                    JButton role1 = new JButton();
                    JPanel panelJoueur1 = new JPanel(new BorderLayout());

                    JPanel panelRole1 = new JPanel();
                    JLabel labelRole1 = new JLabel("Role");
                    panelRole1.add(labelRole1);

                    JPanel emplacement1 = new JPanel();
                    JLabel labelEmplacement1 = new JLabel("Emplacement");
                    emplacement1.add(labelEmplacement1);

                    panelJoueur1.add(panelRole1, BorderLayout.NORTH);
                    panelJoueur1.add(emplacement1, BorderLayout.SOUTH);

                    role1.add(panelJoueur1);
                    window.add(role1);
                    break;
                case 7:
                    JButton role2 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/ingenieur.png")));
                    window.add(role2);
                    break;
                case 40:
                    JButton role3 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/navigateur.png")));
                    window.add(role3);
                    break;
                case 47:
                    JButton role4 = new JButton(new ImageIcon(new URL("https://raw.githubusercontent.com/maniert/ile_interdite2.0/master/src/images/images/personnages/pilote.png")));
                    window.add(role4);
                    break;
                case 1:
                    JPanel Cartej11 = new JPanel(new GridLayout(2, 3, 10, 4));
                    for (int j = 0; j < 6; j++) {
                        Cartej11.add(new JButton());
                    }
                    window.add(Cartej11);
                    break;
                case 2:
                    JPanel Cartej12 = new JPanel(new GridLayout(2, 3, 10, 4));
                    for (int j = 0; j < 6; j++) {
                        switch (j) {
                            case 0:
                            case 1:
                            case 3:
                                Cartej12.add(new JButton());
                                break;
                            default:
                                Cartej12.add(new JLabel());
                                break;
                        }
                        window.add(Cartej12);
                    }
                    break;
                case 5:
                case 6:
                case 9:
                case 14:
                case 33:
                case 38:
                case 41:
                case 42:
                case 45:
                case 46:
                case 8:
                    //Bouton retour ailleurs sur le plateau ?
//                    JPanel panelBas1 = new JPanel(new BorderLayout());
//                    JLabel panelBouton1 = new JLabel("Action restante");
//                    panelBas1.add(panelBouton1, BorderLayout.SOUTH);
//
//                    JPanel panelgrilleBouton = new JPanel(new GridLayout(3, 2));
//
//                    //mettre en surbrillance quand besoin est
//                    for (int k = 0; i < 6; i++) {
//                        JButton btnAction = new JButton();
//                        switch (k) {
//                            case 0:
//                                btnAction.setText("Se deplacer");
//                                btnAction.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        Message m = new Message();
//                                        m.type = TypesMessages.SE_DEPLACER;
//                                        //notifierObservateur(m);
//                                    }
//
//                                });
//                                break;
//                            case 1:
//                                btnAction.setText("Assecher");
//                                btnAction.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        Message m = new Message();
//                                        m.type = TypesMessages.ASSECHER;
//                                        //notifierObservateur(m);
//                                    }
//
//                                });
//                                break;
//                            case 2:
//                                btnAction.setText("Donner carte");
//                                btnAction.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        Message m = new Message();
//                                        m.type = TypesMessages.DONNER_CARTE;
//                                        //notifierObservateur(m);
//                                    }
//
//                                });
//                                break;
//                            case 3:
//                                btnAction.setText("Recuperer tresor");
//                                btnAction.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        Message m = new Message();
//                                        m.type = TypesMessages.RECUPERER_TRESOR;
//                                        //notifierObservateur(m);
//                                    }
//
//                                });
//                                break;
//                            case 4:
//                                btnAction.setText("Utiliser carte");
//                                btnAction.addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        Message m = new Message();
//                                        m.type = TypesMessages.SE_DEPLACER;
//                                        //notifierObservateur(m);
//                                    }
//
//                                });
//                                break;
//                            case 5:
//                                btnAction.setText("Autre");
//
//                                break;
//
//                        }
//                        //btnAction.add(btnAction);
//                    }
//
//                    panelBas1.add(panelgrilleBouton, BorderLayout.SOUTH);
//                    window.add(panelBas1);
//                    break;
                case 15:
                case 16:
                case 23:
                case 32:
                case 39:
                case 24:
                case 31:
                    JPanel caseVide = new JPanel();
                    window.add(caseVide);
                    break;
                default:
                    JButton eau = new JButton();
                    window.add(eau);
                    break;
            }

        }
        window.setVisible(true);
    }
}
