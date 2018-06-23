package view;

import ileint.Carte.CarteOrange;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author fodorg
 */
public class VueMain extends JPanel{
    
    private ArrayList<CarteOrange> cartes;
    private BufferedImage image;
    private int joueurCourant;
    
    public VueMain(ArrayList<CarteOrange> cartes, int joueurCourant) {
        super();
        this.cartes = cartes;
        this.joueurCourant = joueurCourant;
        repaint();
    }
    
    public void paintComponent(Graphics g) { //~42*64
        int x = 0;
        int y = 0;
        int i = 1;
        
        
        for (CarteOrange carte : cartes) {
            if (joueurCourant == 1){
                //System.out.println("1.joueur : "+ joueurCourant);
                if (i==5){
                    x = 0;
                    y = 69;
                }
                chercherImage(carte);
                g.drawImage(image, x, y, null);
                i++;
                x += 47;
            } else if (joueurCourant == 2){
                //System.out.println("2.joueur : "+ joueurCourant);
                if (i==5){
                    x = 168;
                    y = 69;
                }
                chercherImage(carte);
                g.drawImage(image, x, y, null);
                i++;
                x -= 47;
            } else if (joueurCourant == 3){
                //System.out.println("3.joueur : "+ joueurCourant);
                y = 69;
                if (i==5){
                    x = 168;
                    y = 0;
                }
                chercherImage(carte);
                g.drawImage(image, x, y, null);
                i++;
                x -= 47;
            } else if (joueurCourant == 4){
                //System.out.println("4.joueur : "+ joueurCourant);
                y = 69;
                if (i==5){
                    x = 0;
                    y = 0;
                }
                chercherImage(carte);
                g.drawImage(image, x, y, null);
                i++;
                x += 47;
            }
        }
        //i=0;
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
    
    public void ajouterCarte(CarteOrange carte){
        //cartes.add(carte);
        repaint();
    }
    
    public void enleverCarte(CarteOrange carte) {
        //cartes.remove(carte);
        repaint();
    }
    
    public CarteOrange getCarte(int x, int y) {
        int i = x;
        if (y>=1) {
            i += 4;
        }
        if (i<cartes.size()) {
            return cartes.get(i);
        } else {
            return null;
        }
        
    }
    
    public ArrayList<CarteOrange> bla(){
        return cartes;
    }
}
