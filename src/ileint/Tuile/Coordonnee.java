package ileint.Tuile;

import java.util.ArrayList;

/**
 *
 * @author fodorg
 */
public class Coordonnee {
    private int x;
    private int y;
    
    public Coordonnee(int x, int y) {
        setX(x);
        setY(y);
    }

    public ArrayList<Coordonnee> getCases(Coordonnee pos) {
        ArrayList<Coordonnee> cases = new ArrayList<>();
        Coordonnee sauv;
        for (int i = 0; i!= 4 && i<9; i++) {
            sauv = new Coordonnee(pos.getX()-1,pos.getY()-1);
            cases.add(sauv);
        }            
        return cases;
    }
    
    
        //-------------------------------- GETTERS SETTERS --------------------------------------------
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    
}
