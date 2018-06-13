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
     StartOptionPanel optionPanel;
     EnemyTracksPanel enemyTracksPanel;
     StatusCardPanel statusCardPanel;
     
     
      public CardSiegeGamePanel(ObservableGame game)
    {
        this.game = game;
        
        setupComponents();
        setupLayout();
    }
      
      
      
      private void setupComponents()
    {
        optionPanel = new StartOptionPanel(game);
        
        optionPanel.setPreferredSize(new Dimension(450,0));
        
        enemyTracksPanel = new EnemyTracksPanel(game);
        //enemyTracksPanel.setPreferredSize(new Dimension(450,0));
        
        statusCardPanel = new StatusCardPanel(game);
        //statusCardPanel.setPreferredSize(new Dimension(450,0));
        
        
    }
    
    private void setupLayout()
    {
       JPanel pCenter, pSouth, pWest, pEast;
       
       setLayout(new BorderLayout());
       
       /*pEast = new JPanel();
       pEast.setLayout(new BorderLayout());
       pEast.*/
     add(enemyTracksPanel,BorderLayout.EAST);
     add(statusCardPanel,BorderLayout.CENTER);
     add(optionPanel,BorderLayout.CENTER);
       
        
        validate();
   
    }

}
