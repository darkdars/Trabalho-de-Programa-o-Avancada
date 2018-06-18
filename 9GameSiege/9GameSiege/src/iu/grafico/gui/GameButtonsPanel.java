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
    
    
    private JRadioButton jb1, jb2;
    private ButtonGroup group;
    private JPanel resolveForOneCard, resolveForTwoCards, OptionPainel, tradingPanel, CombatPanel, dicePanel, SpellPanel, FeatPanel;

    private Box vBoxForResolveForOneCard, vboxForResolveForTwoCards;
    private Box vBox;

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
        setupButtons();
        setButtonsMouseListener();
        setButtonsActionListeners();

    }

    private void setupButtons() {
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
        
        
    }

    private void registarListeners(){
    
    }

    private void setButtonsMouseListener() {
        archerAttackB.addMouseListener(new ButtonMouseListener(archerAttackB));
        boilingWaterAttackB.addMouseListener(new ButtonMouseListener(boilingWaterAttackB));
        closeCombatB.addMouseListener(new ButtonMouseListener(closeCombatB));
        coupureB.addMouseListener(new ButtonMouseListener(coupureB));
        rallyTrops.addMouseListener(new ButtonMouseListener(rallyTrops));
        tunnelMovementB.addMouseListener(new ButtonMouseListener(tunnelMovementB));
        supplyRaidB.addMouseListener(new ButtonMouseListener(supplyRaidB));
        sabotageB.addMouseListener(new ButtonMouseListener(sabotageB));
        nextCardB.addMouseListener(new ButtonMouseListener(nextCardB));
    }

    /* ============================================== setButtonsActionListeners ============================================== */

    private void setButtonsActionListeners (){
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
            }
         });
        supplyRaidB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        sabotageB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
            }
         });
        nextCardB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.NextCard();
            }
         });
    }

    /* ================================================== Overrides ================================================== */

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitTopCard);
    }
}
