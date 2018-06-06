/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author pandraun
 */
public class AfficheImage extends Container {
    private Image image;
    
    public AfficheImage(String s) {
        image = getToolkit().getImage(s);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } 
    
    
}
