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
import java.awt.GridBagLayout;
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
import logicaJogo.estados.AwaitArchersAttack;
import logicaJogo.estados.AwaitBoilingWatter;
import logicaJogo.estados.AwaitCloseCombat;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitRally;
import logicaJogo.estados.AwaitTopCard;
import logicaJogo.estados.AwaitTunnel;

/**
 *
 * @author jhssi
 */
public class GameButtonsPanel  extends JPanel implements Observer{

    private ObservableGame game;
   
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
    
    private JPanel textP;
    private JLabel actionPointsL;
    private JLabel dayL;
    private JLabel dice;
    

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
        
        attackButtons();
        setAttackButtons();
        setAttackButtonsListeners ();
        
        rallyButtons();
        setRallyButtons();
        setRallyButtonsListeners ();
        
        tunnelButtons();
        setTunnelButtons();
        setTunnelButtonsListeners ();

    }

    private void playerActionButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(3,1));
        
        
        textP = new JPanel();
        textP.setLayout(new BoxLayout(textP, BoxLayout.Y_AXIS));
        textP.setBackground(Color.darkGray);
        textP.setPreferredSize(new Dimension(250,250));
        
        
        dice = new JLabel("Dice : " + game.getDado(), JLabel.CENTER);
        dice.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        actionPointsL = new JLabel("Action Points : " + game.getActionPoints(), JLabel.CENTER);
        actionPointsL.setAlignmentX(Component.CENTER_ALIGNMENT);
        
       
        dayL = new JLabel("Day : " + game.getDay(), JLabel.CENTER);
        dayL.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        actionPointsL.setForeground(Color.white);
        dayL.setForeground(Color.white);
        dice.setForeground(Color.white);
        
        
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
        
        this.add(playerActionButtons);
        
        
        nextCardB = new JButton("Draw Next Card");
        nextCardB.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextCardB.setBackground(Color.white);

        this.add(nextCardB);
        
        cancelB = new JButton("Cancel");
        cancelB.setBackground(Color.white);
        cancelB.addMouseListener(new ButtonMouseListener(cancelB));
        cancelB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.cancel();
            }
         });
    }
    
    private void setPlayerActionButtons() {
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
    
    private void setPlayerActionButtonsListeners (){
        archerAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitArcherAttck();
            }
         });
        boilingWaterAttackB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitBoilingWater();
            }
         });
        closeCombatB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitCloseCombat();
            }
         });
        coupureB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitCoupure();
            }
         });
        rallyTrops.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitRally();              
            }
         });
        tunnelMovementB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitTunnelMovement();
            }
         });
        supplyRaidB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitSupplyRaid();
            }
         });
        sabotageB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.checkPoints();
                game.awaitSabotage();
            }
         });
        nextCardB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                buttonEffects(Color.white);
                if(game.getEstado() instanceof AwaitPlayerAction)
                        game.skipCard();
                if(game.getEstado() instanceof AwaitTopCard )
                        game.NextCard();
            }
         });
    }
    
    
    /****************** AttackButtons ********************/
    
    private void attackButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        attackButtons = new JPanel();
        attackButtons.setLayout(new GridLayout(3, 1));
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
        //this.add(attackButtons, gridBagConstraints);       
        
    }

    private void setAttackButtons() {
        towerB.addMouseListener(new ButtonMouseListener(towerB));
        arieteB.addMouseListener(new ButtonMouseListener(arieteB));
        escadasB.addMouseListener(new ButtonMouseListener(escadasB));
    }

    private void setAttackButtonsListeners (){
        towerB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.attackTower();
            }
         });
        arieteB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.attackAriete();
            }
         });
        escadasB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.attackEscadas();
            }
         });
    }
    
    /****************** RallyButtons ********************/
    
    private void rallyButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        rallyButtons = new JPanel();
        rallyButtons.setLayout(new GridLayout(2, 1));
        normalRallyB = new JButton("Normal Rally");
        normalRallyB.setBackground(Color.white);
        superRallyB = new JButton("Royal Rally");
        superRallyB.setBackground(Color.white);
        
        rallyButtons.add(normalRallyB);
        rallyButtons.add(superRallyB);
        rallyButtons.add(cancelB);
        //this.add(rallyButtons, gridBagConstraints);       
        
    }

    private void setRallyButtons() {
        normalRallyB.addMouseListener(new ButtonMouseListener(normalRallyB));
        superRallyB.addMouseListener(new ButtonMouseListener(superRallyB));
    }

    private void setRallyButtonsListeners (){
        normalRallyB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.normalRally();
            }
         });
        superRallyB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.superRally();
            }
         });
    }
    
    /****************** TunnelButtons ********************/
    
    private void tunnelButtons() {
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        tunelButtons = new JPanel();
        tunelButtons.setLayout(new GridLayout(3, 1));
        enterTunnelB = new JButton("Enter Tunnel");
        enterTunnelB.setBackground(Color.white);
        freeMoveB = new JButton("Free Move");
        freeMoveB.setBackground(Color.white);
        fastMoveB = new JButton("FastMove");
        fastMoveB.setBackground(Color.white);
        
        tunelButtons.add(enterTunnelB);
        tunelButtons.add(freeMoveB);
        tunelButtons.add(fastMoveB);
        tunelButtons.add(cancelB);
        //this.add(tunelButtons, gridBagConstraints);       
        
    }

    private void setTunnelButtons() {
        enterTunnelB.addMouseListener(new ButtonMouseListener(enterTunnelB));
        freeMoveB.addMouseListener(new ButtonMouseListener(freeMoveB));
        fastMoveB.addMouseListener(new ButtonMouseListener(fastMoveB));
    }

    private void setTunnelButtonsListeners (){
        enterTunnelB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.enterTunnel();
            }
         });
        freeMoveB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.freeMove();
            }
         });
        fastMoveB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.fastMove();
            }
         });
    }
    
    
    /****************** ChangeButtons ********************/
    
    private void emptyPanel(){
        this.removeAll();
        textP.removeAll();
        dayL.setText("Dia : " + game.getDay() );
        actionPointsL.setText("Action Points : " + game.getActionPoints());
        dice.setText("Dice: " + game.getDado());
        textP.add(Box.createVerticalGlue());
        textP.add(dayL);
        textP.add(dice);
        textP.add(Box.createVerticalStrut(10));
        textP.add(actionPointsL);
        textP.add(Box.createVerticalStrut(20));
        
        
        this.add(textP);
    }
    
    public void changePlayerAction(){
        emptyPanel();
        this.add(playerActionButtons);
        this.add(nextCardB);
    }
    
    public void changeAttack(){
        emptyPanel();
        this.add( attackButtons);
        this.add( cancelB);
    }
    
    public void changeRally(){
        emptyPanel();
        this.add(rallyButtons);
        this.add(cancelB);
    }
    
    public void changeTunnel(){
        emptyPanel();
        this.add(tunelButtons);
        this.add(cancelB);
    }
    
    public void buttonEffects(Color color){
        
        archerAttackB.setBackground(color);
        boilingWaterAttackB.setBackground(color);
        closeCombatB.setBackground(color);
        coupureB.setBackground(color);
        rallyTrops.setBackground(color);
        tunnelMovementB.setBackground(color);
        supplyRaidB.setBackground(color);
        sabotageB.setBackground(color);
    }
    

    /* ================================================== update ================================================== */

    @Override
    public void update(Observable o, Object arg) {
        if(game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitTopCard){
            if(game.getActionPoints()<=0)
                buttonEffects(Color.red);
            changePlayerAction();
            setVisible(true);
        }
        else if(game.getEstado() instanceof AwaitArchersAttack || game.getEstado() instanceof AwaitBoilingWatter || game.getEstado() instanceof AwaitCloseCombat){
            changeAttack();
            setVisible(true);
        }
        else if(game.getEstado() instanceof AwaitRally){
            changeRally();
            setVisible(true);
        }
        else if(game.getEstado() instanceof AwaitTunnel){
            changeTunnel();
            setVisible(true);
        }
        else
            setVisible( false );
        revalidate();
        repaint();
    }
}