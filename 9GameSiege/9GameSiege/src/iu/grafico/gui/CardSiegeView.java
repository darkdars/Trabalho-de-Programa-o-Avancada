/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author jhssi
 */
public class CardSiegeView extends JFrame implements Observer{

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
    
    
      private void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel,BorderLayout.CENTER);
    }
      
      private void menu(){
          
      }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
