/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import util.Message;
import util.TypesMessages;

/**
 *
 * @author piolleta
 */
public class FenetreConfirmationQuitter extends Observe {

    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel panelBas;
    private final JPanel panelHaut;

    private final JButton btnOui;
    private final JButton btnNon;

    private JLabel textConfirm;
    private final Font f;

    public FenetreConfirmationQuitter() {

        //Creation de la fenetre
        window = new JFrame();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();
        window.setSize(new Dimension(500, 170));
        window.setLocation((width / 2 - 250), (height / 2 - 150));

        //Element de la fenetre
        mainPanel = new JPanel(new BorderLayout());
        panelBas = new JPanel();
        panelHaut = new JPanel();

        //Texte question
        textConfirm = new JLabel("Etes-vous sûr de vouloir quitter ?");
        f = new Font("Ile int", Font.PLAIN, 23);
        textConfirm.setForeground(Color.GRAY);
        textConfirm.setFont(f);
        panelHaut.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelHaut.add(textConfirm);

        panelBas.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        btnOui = new JButton("Oui, je veux quitter");
        btnOui.setPreferredSize(new Dimension(180,30));
        
        btnOui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.OUI_QUITTER;
                notifierObservateur(m);
            }
        });

        btnNon = new JButton("Non, je reste");
        btnNon.setPreferredSize(new Dimension(180,30));
        
        btnNon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.type = TypesMessages.NON_RESTER;
                notifierObservateur(m);
            }
        });
        
        panelBas.add(btnNon);
        panelBas.add(btnOui);

        mainPanel.add(panelHaut, BorderLayout.CENTER);
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        window.add(mainPanel);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void visible(boolean bool) {
        window.setVisible(bool);
    }
    
    public void quitterFenetre(){
        window.dispose();
    }

}
