package view;

import ileint.Carte.CarteOrange;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import util.TypeTresor;

/**
 *
 * @author fodorg
 */
public class VueMain extends JPanel {

    private ArrayList<CarteOrange> cartes;
    private BufferedImage image;
    private final Color couleur;

    public VueMain(ArrayList<CarteOrange> cartes, Color couleur) {
        super();
        this.cartes = cartes;
        this.couleur = couleur;
        Border border = BorderFactory.createLineBorder(couleur);
        this.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createLineBorder(couleur, 3)));
        repaint();
    }

    public void paintComponent(Graphics g) { //~42*64
        this.setSize(new Dimension(256, 128));
        int x = 0;
        int y = 0;
        int i = 1;

        for (CarteOrange carte : cartes) {
            if (i == 5) {
                x = 0;
                y = 69;
            }
            chercherImage(carte);
            g.drawImage(image, x, y, null);
            i++;
            x += 47;

        }
    }

    private void chercherImage(CarteOrange carte) {
        if (carte.getTypeTresor() != null) {
            try {
                image = ImageIO.read(new File("DossierImage/imgCartesJoueur/" + carte.getTypeTresor() + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(VueMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                image = ImageIO.read(new File("DossierImage/imgCartesJoueur/" + carte.getTypeClasse() + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(VueMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ajouterCarte(CarteOrange carte) {
        repaint();
    }

    public void enleverCarte(CarteOrange carte) {
        repaint();
    }

    public void recupererTresor(TypeTresor type) {
        int compteur = 0;

        for (CarteOrange carte : cartes) {
            if (carte.getTypeTresor() != null) {
                if (carte.getTypeTresor().equals(type) && compteur < 4) {
                    cartes.remove(carte);
                    compteur++;
                }
            }
            
        }
        repaint();
    }

    public CarteOrange getCarte(int x, int y) {
        int i = x;
        if (y >= 1) {
            i += 4;
        }
        if (i < cartes.size()) {
            return cartes.get(i);
        } else {
            return null;
        }

    }

    public ArrayList<CarteOrange> bla() {
        return cartes;
    }
}
