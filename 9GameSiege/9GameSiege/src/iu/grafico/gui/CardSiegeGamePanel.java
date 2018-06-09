/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jhssi
 */
public class CardSiegeGamePanel extends JPanel {
    
     ObservableGame game;
     
      public CardSiegeGamePanel(ObservableGame game)
    {
        this.game = game;
        
        setupComponents();
        setupLayout();
    }
      
      
      
      private void setupComponents()
    {
        
    }
    
    private void setupLayout()
    {
       
        
        validate();
       
    }

}
