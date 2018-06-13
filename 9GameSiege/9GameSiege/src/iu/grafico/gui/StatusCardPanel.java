/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitEndDayPhase;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class StatusCardPanel extends JPanel implements Observer {

    ObservableGame game;
    String imageFiles[] ={"images/statusCard.PNG","images/piaoVerde.png"};
    Image imagem[]= new Image[imageFiles.length];
    boolean loaded = false;
    
    StatusCardPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        
        setupLayout();
        
        setVisible(game.getEstado() instanceof AwaitTopCard);
    }
    
    
      Image getImagem(ObservableGame game,int i)
    {

       if(!loaded){
           int j=0;
           loaded=true;
           for(String fileName:imageFiles){
               try {
            imagem[j++] = ImageIO.read(Resources.getResourceFile(fileName));
            } catch (IOException ex) {
            }
           }
       }
       
       return imagem[i];
    }
    
    
     @Override
    public void paintComponent(Graphics g)
    {
        int height = getHeight();
        int width = getWidth();
        int width_image =750;
        int height_image = 1050;
        int shift_area = 30;
        int shift_y = 40;
        int j=0,k=0;
        
        int x = (width_image*height)/height_image;
        super.paintComponent(g);
        
      
        g.drawImage(getImagem(game,0),0,0,x,(getHeight()-1),null);
        g.drawRect(0,0,x,(getHeight())-1);
    }

     private void setupLayout() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    @Override
    public void update(Observable o, Object arg) {
       setVisible(game.getEstado() instanceof AwaitTopCard || game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitEndDayPhase);
       //revalidate();
       repaint();
    }

  
}
