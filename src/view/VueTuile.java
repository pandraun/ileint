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

/**
 *
 * @author fodorg
 */
public class VueTuile extends JPanel{
    
    private Tuile tuile;
    private BufferedImage image;
    
    public VueTuile(Tuile tuile) {
        super();
        this.tuile = tuile;
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        try { //  A CHANGER EN FONCTION DE L'ETAT
            image = ImageIO.read(new File("DossierImage/Tuiles/" + tuile.getNom() +".png"));
        } catch (IOException ex) {
            Logger.getLogger(VueTuile.class.getName()).log(Level.SEVERE, null, ex);
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
}
