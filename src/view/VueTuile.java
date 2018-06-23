package view;

import ileint.Joueur.Joueur;
import ileint.Tuile.Tuile;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Utils.EtatTuile;

/**
 *
 * @author fodorg
 */
public class VueTuile extends JPanel  {

    private Tuile tuile;
    private BufferedImage image;
    private boolean surbrillance;

    public VueTuile(Tuile tuile) {
        super();
        this.tuile = tuile;
        repaint();
    }

    public void paintComponent(Graphics g) {

        if (tuile.getEtat().equals(EtatTuile.COULEE)) {
            try {
                image = ImageIO.read(new File("DossierImage/Tuiles/CASECOULEE.png"));
            } catch (IOException ex) {
                Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!surbrillance) {
            if (tuile.getEtat().equals(EtatTuile.ASSECHEE)) {
                try {
                    image = ImageIO.read(new File("DossierImage/Tuiles/" + tuile.getNom() + ".png"));
                } catch (IOException ex) {
                    Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { //si la tuile est assechée
                try {
                    image = ImageIO.read(new File("DossierImage/Tuiles/" + tuile.getNom() + "2.png"));
                } catch (IOException ex) {
                    Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (tuile.getEtat().equals(EtatTuile.ASSECHEE)) {
                try {
                    image = ImageIO.read(new File("DossierImage/Tuiles/Surbrillance/" + tuile.getNom() + ".png"));
                } catch (IOException ex) {
                    Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    image = ImageIO.read(new File("DossierImage/Tuiles/Surbrillance innondé/" + tuile.getNom() + ".png"));
                } catch (IOException ex) {
                    Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        g.drawImage(image, 0, 0, null);

        int i = 4;
        for (Joueur joueur : tuile.getJoueursTuile()) {
            g.setColor(joueur.getRole().getCouleur().getCouleur());
            g.fillOval(i, 4, 25, 25);
            i += 29;
        }
    }

    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
        repaint();
    }

    public void setSurbrillance(boolean bool) {
        this.surbrillance = bool;
        repaint();
    }
}
