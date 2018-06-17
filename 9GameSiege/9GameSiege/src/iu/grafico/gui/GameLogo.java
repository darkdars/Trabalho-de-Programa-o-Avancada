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
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class GameLogo extends JPanel implements Observer{
    
    private ObservableGame game;
    static final String imgName= "imagens/logo.png";
    private Image logo;

    public GameLogo(ObservableGame g) {
        game = g;
        game.addObserver(this);


        setupPanel();
    }


    private void setupPanel(){
        getImage();

        setOpaque(false);

        setPreferredSize(new Dimension(700,140));
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        setVisible(game.getEstado() instanceof AwaitTopCard);
    }

    private void getImage(){
        try {
            logo = ImageIO.read(Resources.getResourceFile(imgName));
        } catch (IOException ex) {
            Logger.getLogger(GameLogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*======================================= Overrides ======================================== */

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(logo,550,0,680-1,140-1,null);
        g.setColor(Color.black);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitTopCard)
            setVisible(true);
    }

}
