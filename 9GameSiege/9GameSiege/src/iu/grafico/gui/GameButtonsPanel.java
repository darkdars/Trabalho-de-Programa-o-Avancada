/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class GameButtonsPanel  extends JPanel implements Observer{

    private ObservableGame game;
    private JButton resolve, resolve2cards, b1, b2;
    private JLabel chooseCardLabel;
    private JRadioButton jb1, jb2;
    private ButtonGroup group;
    private JPanel resolveForOneCard, resolveForTwoCards, OptionPainel, tradingPanel, CombatPanel, dicePanel, SpellPanel, FeatPanel;

    private Box vBoxForResolveForOneCard, vboxForResolveForTwoCards;
    private Box vBox;

    public GameButtonsPanel(ObservableGame g) {
        this.game = g;
        game.addObserver(this);


        setupComponents();
        registarListeners();

        setPreferredSize(new Dimension(330,500));
       // setOpaque(false);

        setBackground( new Color(0, 0, 0, 64));
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setVisible(game.getEstado() instanceof AwaitTopCard);

    }


    private void setupComponents() {

        setupButtons();


    }

    private void setupButtons() {
        
    }

    private void registarListeners(){
    
    }

    private void resolveMouseListener() {
        resolve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                resolve.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                resolve.setBackground(Color.blue);
            }
        });
    }

    private void resolveMListener() {
        resolve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                // resolve.setFont(new Font("Charlemagne Std", Font.BOLD, 16));
                resolve.setBackground(Color.red);
                resolve.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                resolve.setBackground(Color.green);

                // resolve.setFont(new Font("Charlemagne Std", Font.PLAIN, 13));
                resolve.setForeground(Color.black);

            }
        });
    }

    /* ============================================== Classes Interiores ============================================== */

    class ResolveOneCard implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          //  game.getGameData().getCard(game.getGameData().getCounter()).resolveCard(game.getGameModel());
            //game.checkCardsCounter();
        }
    }

    class ResolveTwoCards implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(jb1.isSelected()) {
            //    game.getGameData().cardChoosen(1);
              //  game.getGameData().getCard(game.getGameData().getCounter()).resolveCard(game.getGameModel());
                //game.checkCardsCounter();

            }
            else if(jb2.isSelected()){
                //game.getGameData().cardChoosen(2);
                //game.getGameData().getCard(game.getGameData().getCounter()).resolveCard(game.getGameModel());
                //game.checkCardsCounter();
            }
        }
    }

    public void noChooseOneOftwoVisible(){

    }

    /* ================================================== Overrides ================================================== */

    @Override
    public void update(Observable o, Object arg) {


        
    }
}
