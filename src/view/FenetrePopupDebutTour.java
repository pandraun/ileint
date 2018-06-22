/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mazzolec
 */
public class FenetrePopupDebutTour extends Observe {

    private final JFrame window;
    private final JPanel mainPanel;
    private final JButton btnOk;
    private final String chemin;
    private BufferedImage image;

    public FenetrePopupDebutTour(String role) {
        window = new JFrame();

        if (role.equals("Pilote")) {
            chemin = "DossierImage/imgCarteTourJoueur/pilote.png";
        } else if (role.equals("Explorateur")) {
            chemin = "DossierImage/imgCarteTourJoueur/explo.png";
        } else if (role.equals("Ingénieur")) {
            chemin = "DossierImage/imgCarteTourJoueur/inge.png";
        } else if (role.equals("Messager")) {
            chemin = "DossierImage/imgCarteTourJoueur/mess.png";
        } else if (role.equals("Plongeur")) {
            chemin = "DossierImage/imgCarteTourJoueur/plon.png";
        } else {
            chemin = "DossierImage/imgCarteTourJoueur/navigo.png";
        }

        

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        btnOk = new JButton("Compris");
        btnOk.setOpaque(false);
        mainPanel.add(btnOk, BorderLayout.SOUTH);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("appui bouton");
            }
        });

        window.add(mainPanel);
        window.setLocation(400, 150);
        window.setSize(404, 480);
        window.setResizable(false);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        FenetrePopupDebutTour fen = new FenetrePopupDebutTour("Pilote");
    }
}
