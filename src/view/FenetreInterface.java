/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.Message;
import util.TypesMessages;

/**
 *
 * @author piolleta
 */
public class FenetreInterface extends Observe {

    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel panelBas;
    private final JPanel panelHaut;

    private final JButton btnQuitter;

    private final Font f;

    public FenetreInterface() throws IOException {
        //Creation de la fenetre
        window = new JFrame("Aide interface");
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();
        window.setSize(new Dimension(1280, 650));
        window.setLocation((width / 2 - 640), (height / 2 - 325));

        final BufferedImage image = ImageIO.read(new File("DossierImage/FenetreInterface/interface1.jpg"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        window.setContentPane(pane);

        //Element de la fenetre
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        panelBas = new JPanel();
        panelBas.setOpaque(false);
        panelHaut = new JPanel();
        panelHaut.setOpaque(false);

        //Texte question
        f = new Font("Ile int", Font.PLAIN, 23);

        panelBas.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        btnQuitter = new JButton("J'ai compris");
        btnQuitter.setPreferredSize(new Dimension(150, 25));

        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.FERMER_INTERFACE;
                notifierObservateur(m);
            }
        });

        panelBas.add(btnQuitter);

        mainPanel.add(panelHaut, BorderLayout.CENTER);
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        window.add(mainPanel);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void visible(boolean bool) {
        window.setVisible(bool);
    }

    public void quitterFenetre() {
        window.dispose();
    }

}
