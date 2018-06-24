/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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

    public FenetrePopupDebutTour(String role) throws IOException {
        window = new JFrame("Informations Rôle");
        window.setLayout(new BorderLayout());

        switch (role) {
            case "Pilote":
                chemin = "DossierImage/imgCarteTourJoueur/pilote.png";
                break;
            case "Explorateur":
                chemin = "DossierImage/imgCarteTourJoueur/explo.png";
                break;
            case "Ingenieur":
                chemin = "DossierImage/imgCarteTourJoueur/inge.png";
                break;
            case "Messager":
                chemin = "DossierImage/imgCarteTourJoueur/mess.png";
                break;
            case "Plongeur":
                chemin = "DossierImage/imgCarteTourJoueur/plon.png";
                break;
            default:
                chemin = "DossierImage/imgCarteTourJoueur/navigo.png";
                break;
        }

        final BufferedImage image = ImageIO.read(new File(chemin));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        window.setContentPane(pane);

        mainPanel = new JPanel();
        mainPanel.setOpaque(false);

        btnOk = new JButton("Compris");
        window.setLayout(null);
        btnOk.setBounds(140, 422, 110, 22);
        window.add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });

        window.setLocation(400, 150);
        window.setSize(404, 480);
        window.setResizable(false);
        window.setVisible(true);
    }

}
