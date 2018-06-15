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
import javax.accessibility.AccessibleContext;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import logicaJogo.estados.AwaitEndDayPhase;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class EnemyTracksPanel extends JPanel implements Observer{

    ObservableGame game;
    String imageFiles[] ={"imagens/enemyTracks.png","imagens/piaoVermelho.png","imagens/piaoAzul.png"};
    Image[] imagem= new Image[imageFiles.length];
    boolean loaded=false;
    
    EnemyTracksPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        int j = 0;
    
        setVisible(game.getEstado() instanceof AwaitTopCard);    
    }
    
    Image getImagem(ObservableGame game,int i)
    {

       if(!loaded){
           int j=0;
           loaded=true;
           for(String fileName:imageFiles){
               try {
                imagem[j] = ImageIO.read(Resources.getResourceFile(fileName));
                j++;
               } catch (IOException ex) {
           }
           }
       }
       
       return imagem[i];
    }
    
    
     @Override
    public void paintComponent(Graphics g)
    {
        int width_image =750;
        int height_image = 1050;
        int j=0;
       
        
        super.paintComponent(g);
 
        
        g.drawImage(getImagem(game,0),0,250,241,336,null);
        g.drawRect(0,250,241,336);
        
        //g.drawImage(getImagem(game,2),179,537,40,40,null);
    
        //INCOMPLETO
        //Desenhar casa por das váriaveis
        switch (game.getEscadas()) {
            case 4:
             g.drawImage(getImagem(game,1),17,472,40,40,null);
             g.drawRect(17,472,40,40);
                break;
            case 3:
             g.drawImage(getImagem(game,1),17,417,40,40,null);
             g.drawRect(17,417,40,40);
                break;
            case 2:
             g.drawImage(getImagem(game,1),17,362,40,40,null);
             g.drawRect(17,362,40,40);
                break;
            case 1:
             g.drawImage(getImagem(game,1),17,307,40,40,null);
             g.drawRect(17,307,40,40);
                break;
            case 0:
             g.drawImage(getImagem(game,1),78,255,40,40,null);
             g.drawRect(78,255,40,40);
                break;
        }
        
        switch (game.getAriete()) {
            case 4:
             g.drawImage(getImagem(game,1),98,472,40,40,null);
             g.drawRect(98,472,40,40);
                break;
            case 3:
             g.drawImage(getImagem(game,1),98,417,40,40,null);
             g.drawRect(98,417,40,40);
                break;
            case 2:
             g.drawImage(getImagem(game,1),98,362,40,40,null);
             g.drawRect(98,362,40,40);
                break;
            case 1:
             g.drawImage(getImagem(game,1),98,307,40,40,null);
             g.drawRect(98,307,40,40);
                break;
            case 0:
             g.drawImage(getImagem(game,1),98,255,40,40,null);
             g.drawRect(98,255,40,40);
                break;
        }
        
        switch (game.getTorre()) {
            case 4:
             g.drawImage(getImagem(game,1),179,472,40,40,null);
             g.drawRect(179,472,40,40);
                break;
            case 3:
             g.drawImage(getImagem(game,1),179,417,40,40,null);
             g.drawRect(179,417,40,40);
                break;
            case 2:
             g.drawImage(getImagem(game,1),179,362,40,40,null);
             g.drawRect(179,362,40,40);  
                break;
            case 1:
             g.drawImage(getImagem(game,1),179,307,40,40,null);
             g.drawRect(179,307,40,40);
                break;
            case 0:
             g.drawImage(getImagem(game,1),119,255,40,40,null);
             g.drawRect(119,255,40,40);
                break;
        }
        
        switch(game.getTrincheiras()){
            case 3:
               g.drawImage(getImagem(game,2),179,537,40,40,null);
               g.drawRect(179,255,40,40);
                break;
            case 2:
               g.drawImage(getImagem(game,2),98,537,40,40,null);
               g.drawRect(98,255,40,40);
                break;
            case 1:
              g.drawImage(getImagem(game,2),17,537,40,40,null);
              g.drawRect(17,255,40,40);
                break;
        }
        
    }
    
    

    public ObservableGame getGame() {
        return game;
    }

    public void setGame(ObservableGame game) {
        this.game = game;
    }

    public String[] getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(String[] imageFiles) {
        this.imageFiles = imageFiles;
    }

    public Image[] getImagem() {
        return imagem;
    }

    public void setImagem(Image[] imagem) {
        this.imagem = imagem;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
    
    

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getEstado() instanceof AwaitTopCard || game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitEndDayPhase);
    }
    
}
