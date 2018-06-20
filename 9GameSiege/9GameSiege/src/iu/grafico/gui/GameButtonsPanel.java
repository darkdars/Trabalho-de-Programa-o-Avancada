/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class GameButtonsPanel  extends JPanel implements Observer{

    private ObservableGame game;
    private JButton resolve, resolve2cards, b1, b2;
   
    private JButton archerAttackB;
    private JButton boilingWaterAttackB;
    private JButton closeCombatB;
    private JButton coupureB;
    private JButton rallyTrops;
    private JButton tunnelMovementB;
    private JButton supplyRaidB;
    private JButton sabotageB;
    private JPanel playerActionButtons;
    
    private JButton nextCardB;
    
    private JButton towerB;
    private JButton arieteB;
    private JButton escadasB;
    private JPanel attackButtons;
    
    private JButton normalRallyB;
    private JButton superRallyB;
    private JPanel rallyButtons;
    
    private JButton enterTunnelB;
    private JButton freeMoveB;
    private JButton fastMoveB;
    private JPanel tunelButtons;
    
    private JButton cancelB;
    

    public GameButtonsPanel(ObservableGame g) {
        this.game = g;
        game.addObserver(this);
        
        setupComponents();

        setPreferredSize(new Dimension(330,500));
       // setOpaque(false);
        setBackground(Color.darkGray);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(game.getEstado() instanceof AwaitTopCard|| game.getEstado() instanceof AwaitPlayerAction);
    }


    private void setupComponents() {
        playerActionButtons();
        setPlayerActionButtons();
        setPlayerActionButtonsListeners();

    }

    private void playerActionButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        setLayout(new GridLayout(2,1));
        playerActionButtons = new JPanel();
        playerActionButtons.setLayout(new GridLayout(4,2));
        archerAttackB = new JButton("Archer Attack");
        archerAttackB.setBackground(Color.white);
        boilingWaterAttackB = new JButton("Boiling Water Attack");
        boilingWaterAttackB.setBackground(Color.white);
        closeCombatB = new JButton("Close Combat");
        closeCombatB.setBackground(Color.white);
        coupureB = new JButton("Coupure");
        coupureB.setBackground(Color.white);
        rallyTrops = new JButton("Rally Trops");
        rallyTrops.setBackground(Color.white);
        tunnelMovementB = new JButton("Tunnel Movement");
        tunnelMovementB.setBackground(Color.white);
        supplyRaidB = new JButton("Supply Raid");
        supplyRaidB.setBackground(Color.white);
        sabotageB = new JButton("Sabotage");
        sabotageB.setBackground(Color.white);
        
        playerActionButtons.add(archerAttackB);
        playerActionButtons.add(boilingWaterAttackB);
        playerActionButtons.add(closeCombatB);
        playerActionButtons.add(coupureB);
        playerActionButtons.add(rallyTrops);
        playerActionButtons.add(tunnelMovementB);
        playerActionButtons.add(supplyRaidB);
        playerActionButtons.add(sabotageB);
        this.add(playerActionButtons, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        nextCardB = new JButton("Draw Next Card");
        nextCardB.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextCardB.setBackground(Color.white);

        this.add(nextCardB, gridBagConstraints);
        
        cancelB = new JButton("Cancel");
        cancelB.setBackground(Color.white);
        cancelB.addMouseListener(new ButtonMouseListener(cancelB));
        cancelB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.getEstado().cancel();
            }
         });
        
        
        
    }
    
    private void setPlayerActionButtons() {
        attackButtons.addMouseListener(new ButtonMouseListener(archerAttackB));
        boilingWaterAttackB.addMouseListener(new ButtonMouseListener(boilingWaterAttackB));
        closeCombatB.addMouseListener(new ButtonMouseListener(closeCombatB));
        coupureB.addMouseListener(new ButtonMouseListener(coupureB));
        rallyTrops.addMouseListener(new ButtonMouseListener(rallyTrops));
        tunnelMovementB.addMouseListener(new ButtonMouseListener(tunnelMovementB));
        supplyRaidB.addMouseListener(new ButtonMouseListener(supplyRaidB));
        sabotageB.addMouseListener(new ButtonMouseListener(sabotageB));
        nextCardB.addMouseListener(new ButtonMouseListener(nextCardB));
    }
    
    private void setPlayerActionButtonsListeners (){
        archerAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
         });
        boilingWaterAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        closeCombatB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        coupureB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(4);
            }
         });
        rallyTrops.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
         });
        tunnelMovementB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(6);
            }
         });
        supplyRaidB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(7);
            }
         });
        sabotageB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(8);
            }
         });
        nextCardB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(game.getEstado() instanceof AwaitPlayerAction)
                        game.skipCard();
                if(game.getEstado() instanceof AwaitTopCard )
                        game.NextCard();
            }
         });
    }
    
    private void attackButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        setLayout(new GridLayout(2,1));
        attackButtons = new JPanel();
        attackButtons.setLayout(new GridLayout(4, 1));
        towerB = new JButton("Attack Torre");
        towerB.setBackground(Color.white);
        arieteB = new JButton("Attack Ariete");
        arieteB.setBackground(Color.white);
        escadasB = new JButton("Attack Escadas");
        escadasB.setBackground(Color.white);
        
        attackButtons.add(towerB);
        attackButtons.add(arieteB);
        attackButtons.add(escadasB);
        attackButtons.add(cancelB);
        this.add(attackButtons, gridBagConstraints);       
        
    }

    private void setAttackButtons() {
        towerB.addMouseListener(new ButtonMouseListener(archerAttackB));
        arieteB.addMouseListener(new ButtonMouseListener(boilingWaterAttackB));
        escadasB.addMouseListener(new ButtonMouseListener(closeCombatB));
    }

    /* ============================================== setButtonsActionListeners ============================================== */

    private void setAttackButtonsListeners (){
        archerAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
         });
        boilingWaterAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        closeCombatB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        coupureB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(4);
            }
         });
        rallyTrops.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                
            }
         });
        tunnelMovementB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(6);
            }
         });
        supplyRaidB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(7);
            }
         });
        sabotageB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.setEstadoAction(8);
            }
         });
        nextCardB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(game.getEstado() instanceof AwaitPlayerAction)
                        game.skipCard();
                if(game.getEstado() instanceof AwaitTopCard )
                        game.NextCard();
            }
         });
    }

    /* ================================================== Overrides ================================================== */

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitTopCard);
        revalidate();
        repaint();
    }
}
