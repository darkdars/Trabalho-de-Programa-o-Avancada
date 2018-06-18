/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;


import iu.grafico.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logicaJogo.estados.AwaitBeginning;

/**
 *
 * @author jhssi
 */
public class CardSiegeGamePanel extends JPanel implements Observer{
    
     private ObservableGame game;
     private StartOptionPanel optionPanel;
     private EnemyTracksPanel enemyTracksPanel;
     private StatusCardPanel statusCardPanel;
     private GameLogo logo;
     private CardSelected cSelected;
     private GameButtonsPanel gameButtons;
     private JPanel pNorth, pCenter, pCenterLeft, pCenterRight, pSouth, pSouthLeft, pSouthCenter, pSouthRight, pWest, pEast;
     private JPanel pStart, pMainButtons;
     private String imgName = "imagens/paginaInicial.png";
     private Image bg;
     
     
      public CardSiegeGamePanel(ObservableGame game)
    {
        this.game = game;
        
        getBackgroundImg();
        
        setupComponents();
        setupLayout();
    }
      
      
      
      private void setupComponents()
    {
        optionPanel = new StartOptionPanel(game);
        
        optionPanel.setPreferredSize(new Dimension(450,0));
        
        enemyTracksPanel = new EnemyTracksPanel(game);
        enemyTracksPanel.setPreferredSize(new Dimension(450,0));
        
        statusCardPanel = new StatusCardPanel(game);
        statusCardPanel.setPreferredSize(new Dimension(450,0));
        
        logo = new GameLogo(game);
        logo.setPreferredSize(new Dimension(50,200));
        
        cSelected  = new CardSelected(game);
        
        gameButtons = new GameButtonsPanel(game);
    }
    
    private void setupLayout()
    {
      
      
      setLayout(new BorderLayout());
      setBackground(Color.darkGray);
      
      
      setupNorth();
      setupCenter();
      setupSouth();
      setupEast();
      setupWest();
      
     
        pNorth.add(logo);
        pCenterLeft.add(cSelected);
        
        pCenterRight.add(gameButtons);
       

       // pSouth.add(cards);

        pWest.add(enemyTracksPanel, BorderLayout.WEST);
        pEast.add(statusCardPanel, BorderLayout.EAST);




        add(pNorth, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        add(pEast, BorderLayout.EAST);
        add(pWest, BorderLayout.WEST);

        //add(mainPanel, BorderLayout.CENTER);
       validate();
   
    
       
    }   
       
      private void getBackgroundImg(){

        try {
            bg = ImageIO.read(Resources.getResourceFile(imgName));
            bg = bg.getScaledInstance(1, -1, 300);

        } catch (IOException ex) {
           // Logger.getLogger(GameLogo.class.getName()).log(Level.SEVERE, null, ex);
           //Corrigir isto
        }

    }
    
    // Setup Panels
    
    private void setupNorth() {
        pNorth = new JPanel();
        pNorth.setOpaque(false);
        pNorth.setLayout(new BorderLayout());
        pNorth.setBorder(new EmptyBorder(0, 45, 0, 0));
    }

    private void setupCenter() {
        pCenter = new JPanel();
        pCenter.setOpaque(false);
        pCenter.setLayout(new BorderLayout());
        pCenter.setBorder(new EmptyBorder(0, 0, 0, 100));
        


        pCenterLeft = new JPanel();
        pCenterLeft.setLayout(new BorderLayout());
        pCenterLeft.setBorder(new EmptyBorder(0, 0, 20, 0));
        pCenterLeft.setOpaque(false);

        pCenterRight = new JPanel();
        pCenterRight.setLayout(new BoxLayout(pCenterRight, BoxLayout.Y_AXIS));
        pCenterRight.setOpaque(false);


        pCenter.add(pCenterLeft, BorderLayout.WEST);
        pCenter.add(pCenterRight, BorderLayout.EAST);
    }

    private void setupSouth() {
        pSouth = new JPanel();
        pSouth.setOpaque(false);
        pSouth.setLayout(new BorderLayout());

        pSouthLeft = new JPanel();
        pSouthLeft.setOpaque(false);
        pSouthLeft.setLayout(new BorderLayout());
       // pSouthLeft.add(dPanel);
        pSouthLeft.setBorder(new EmptyBorder(0, 0, 5, 90));

        pSouthRight = new JPanel();
        pSouthRight.setOpaque(false);
        pSouthRight.setLayout(new BorderLayout());
       // pSouthRight.add(logsPanel, BorderLayout.EAST);
        pSouthRight.setBorder(new EmptyBorder(0, 90, 5, 25));

        pSouthCenter = new JPanel();
        pSouthCenter.setOpaque(false);
        pSouthCenter.setLayout(new GridBagLayout());
        pSouthCenter.setBorder(new EmptyBorder(0, 20, 5, 0));

       // pSouthCenter.add(cards);


        pSouth.setBorder(new EmptyBorder(0, 30, 5, 0));

        pSouth.add(pSouthCenter, BorderLayout.CENTER);
        pSouth.add(pSouthRight, BorderLayout.EAST);
        pSouth.add(pSouthLeft, BorderLayout.WEST);
    }

    private void setupEast() {
         pEast = new JPanel();
        pEast.setOpaque(false);

        pEast.setLayout(new BorderLayout());
        pEast.setBorder(new EmptyBorder(0, 0, 0, 20));
    }

    private void setupWest() {
        pWest = new JPanel();
        pWest.setOpaque(false);

        pWest.setLayout(new BorderLayout());

    }

    
     @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(!(game.getEstado() instanceof AwaitBeginning))
            g.drawImage(bg, 0, 0, this);


        if(game.getEstado() instanceof AwaitBeginning){

            remove(pCenter);
            add(optionPanel, BorderLayout.CENTER);

            pNorth.setVisible(false);
            pSouth.setVisible(false);
            pEast.setVisible(false);
            pWest.setVisible(false);
            pCenter.setVisible(false);
            optionPanel.setVisible(true);
        }
        else {
            remove(optionPanel);

            add(pCenter, BorderLayout.CENTER);

            pNorth.setVisible(true);
            pSouth.setVisible(true);;
            pEast.setVisible(true);
            pWest.setVisible(true);
            pCenter.setVisible(true);
            optionPanel.setVisible(false);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setBackground(Color.blue);
        revalidate();
        repaint();
    }

    
}
