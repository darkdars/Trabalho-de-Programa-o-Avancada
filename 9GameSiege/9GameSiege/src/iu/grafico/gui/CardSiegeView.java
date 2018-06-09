/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jhssi
 */
public class CardSiegeView {

     ObservableGame game;
     CardSiegeGamePanel panel;
    
    public CardSiegeView(ObservableGame j)
    {
        super("Card Siege");
        
        game = j;
        game.addObserver(this);
        
       panel = new CardSiegeGamePanel(game);
       
       addComponents();
       menu();
       
       setVisible(true);
       this.setSize(700,500);
       this.setMinimumSize(new Dimension(650, 450));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       validate();
    }
    
}
