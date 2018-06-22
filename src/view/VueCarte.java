/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ileint.Carte.CarteOrange;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author pandraun
 */
public class VueCarte extends JPanel{
    private CarteOrange carte;
    private BufferedImage image;
    
    public VueCarte() {
        super();
    }
    
    public void paintComponent(Graphics g) {
        chercherImage(carte);
        g.drawImage(image, 0, 0, null);
    }
    
    private void chercherImage(CarteOrange carte) {
        if (carte.getTypeTresor() != null) {
            try {
                image = ImageIO.read(new File("DossierImage/imgCartesJoueur/"+carte.getTypeTresor()+".png"));
            } catch (IOException ex) {
                Logger.getLogger(VueMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                image = ImageIO.read(new File("DossierImage/imgCartesJoueur/"+carte.getTypeClasse()+".png"));
            } catch (IOException ex) {
                Logger.getLogger(VueMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setImage(CarteOrange carte) {
        this.carte = carte;
        repaint();
    }
    
    public void enleverImage() {
        try {
                image = ImageIO.read(new File(""));
            } catch (IOException ex) {
                Logger.getLogger(VueMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        repaint();
    }
}
