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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class CardSelected extends JPanel implements Observer{

    private ObservableGame game;

    static final String imgName = "imagens/cartaTras.png";

    static Image img, img1;

    public CardSelected(ObservableGame g) {
        game = g;
        game.addObserver(this);


        setupPanel();

    }

    private void setupPanel(){
        //getImage();
        //setOpaque(false);
        setBackground(Color.darkGray);

        setPreferredSize(new Dimension(360,400));

        setLayout(new BorderLayout());

        setVisible(game.getEstado() instanceof AwaitTopCard);
    }

    private void getImage(){
        try {
            img = ImageIO.read(Resources.getResourceFile(imgName));
        } catch (IOException ex) {
            Logger.getLogger(GameLogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Image getCardImage(){
        ImageIcon icon = null;
        Icon newicon = null;
        String imgPath = "";

        
        //Ver Carta Selecionada e igualar

    switch(game.getJogo().getDadosJogo().getCartaSelecionada().getNumCarta()){
            case 1:
                imgPath = "imagens/card1.png";
                break;
            case 2:
                imgPath = "imagens/card2.png";
                break;
            case 3:
                imgPath = "imagens/card3.png";
                break;
            case 4:
                imgPath = "imagens/card4.png";
                break;
            case 5:
                imgPath = "imagens/card5.png";
                break;
            case 6:
                imgPath = "imagens/card6.png";
                break;
            case 7:
                imgPath = "imagens/card7.png";
                break;
            default:
                imgPath = "imagens/cartaTras.png";
                break;
        }
       
            
        try {
            img = ImageIO.read(Resources.getResourceFile(imgPath));
        } catch (IOException ex) {
            Logger.getLogger(GameLogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

     /* =================================== Listeners =========================================== */



    /* ================================================== Overrides ================================================== */



    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Image img = getCardImage();

        if(img != null)
            g.drawImage(img,0,0,245,337,null);

    }


    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitTopCard);
        revalidate();
        repaint();
    }
}