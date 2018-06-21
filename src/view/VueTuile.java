package view;

import ileint.Tuile.Tuile;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author fodorg
 */
public class VueTuile extends JPanel{
    
    private Tuile tuile;
    
    public VueTuile(Tuile tuile) {
        super();
        this.tuile = tuile;
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        this.add(new ImagePanel("DossierImage/Tuiles/"+tuile.getNom()+".png")); //  A CHANGER EN FONCTION DE L'ETAT
        
        
        
    }
    
    public void setTuile(Tuile tuile) {
        this.tuile = tuile;
        repaint();
    }
}
