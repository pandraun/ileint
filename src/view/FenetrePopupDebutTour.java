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
import javax.swing.JLabel;
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

    public FenetrePopupDebutTour(String role) throws IOException {
        window = new JFrame("Informations Rôle");
        window.setLayout(new BorderLayout());

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

    public static void main(String[] args) throws IOException {
        FenetrePopupDebutTour fen = new FenetrePopupDebutTour("Pilote");
    }
}
