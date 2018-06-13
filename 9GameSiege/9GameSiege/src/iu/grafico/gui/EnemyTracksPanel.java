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
        
    
        //INCOMPLETO
        //Desenhar casa por das váriaveis
        switch (game.getEscadas()) {
            case 4:
                break;
            case 3:
                break;
            case 2:
                break;
            case 1:
                break;
            case 0:
                break;
        }
        
        switch (game.getAriete()) {
            case 4:
                break;
            case 3:
                break;
            case 2:
                break;
            case 1:
                break;
            case 0:
                break;
        }
        
        switch (game.getTorre()) {
            case 4:
                break;
            case 3:
                break;
            case 2:
                break;
            case 1:
                break;
            case 0:
                break;
        }
        
        switch(game.getTrincheiras()){
            case 3:
                break;
            case 2:
                break;
            case 1:
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
