/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Andre
 */
public class ButtonMouseListener implements MouseListener{
    
    private JButton button;
    
    public ButtonMouseListener(JButton jButton){
        this.button = jButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(Color.green);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(Color.white);
    }
    
}
