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
        optionPanel = new StartOptionPanel(game);
        
        optionPanel.setPreferredSize(new Dimension(450,0));
        
        caraStatsPanel = new CharacterStatsPanel(game);
        
        dungeonPanel = new DungeonPanel(game);
        
 
        cartasPanel = new CartasPanel(game);
        
        cartaGrande = new CartaGrande(game);
        
        mensagemPanel = new MensagemPanel(game);
        
        merchantPanel = new MerchantPanel(game);
        
        restingPanel = new RestingPanel(game);
        
        combatPanel = new CombatPanel(game);
        
        featsPanel = new FeatsPanel(game);
        
        spellsPanel = new SpellsPanel(game);
        
    }
    
    private void setupLayout()
    {
        JPanel pCenter, pSouth,pWest,pEast;
        
        
        setLayout(new BorderLayout());
     
        
   
       pEast = new JPanel();
       pEast.setLayout(new BorderLayout());
       pEast.add(optionPanel,BorderLayout.EAST);
       pEast.add(featsPanel,BorderLayout.CENTER);
       pEast.add(spellsPanel,BorderLayout.WEST);
       
       pWest=new JPanel();
       pWest.setLayout(new GridLayout(2,1,0,0));
       pWest.add(caraStatsPanel);
       pWest.add(dungeonPanel);//dungeonPanel
       
       pCenter = new JPanel();
       pCenter.setLayout(new BorderLayout());
       pCenter.add(cartasPanel,BorderLayout.NORTH);
       pCenter.add(merchantPanel,BorderLayout.WEST);
       pCenter.add(restingPanel,BorderLayout.SOUTH);
       pCenter.add(combatPanel,BorderLayout.EAST);
       
       pSouth = new JPanel();
       pSouth.setLayout(new GridLayout(1,2,0,0));
       pSouth.add(cartaGrande);
       pSouth.add(mensagemPanel);
       
       pCenter.add(pSouth);
      
        add(pCenter,BorderLayout.CENTER);
        
        add(pWest,BorderLayout.WEST);
   
        add(pEast,BorderLayout.EAST);
        
        
       
   
        
        
        validate();
       
    }

}
