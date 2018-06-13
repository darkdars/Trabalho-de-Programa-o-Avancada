/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.util.Observable;
import logicaJogo.Jogo;
import logicaJogo.estados.IEstado;

/**
 *
 * @author jhssi
 */
public class ObservableGame extends Observable{

    Jogo jogo;
    
    
    public ObservableGame(){
        jogo = new Jogo();
    }
    
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    
    public IEstado getEstado()
    {
        return jogo.getEstado();
    }
    
    public void setGame(Jogo jogo)
    {
        this.jogo = jogo;
        
        setChanged();
        notifyObservers();
    }
       
    public void ResolveStart()
    {
        jogo.CheckStart();
       
        
        setChanged();
        notifyObservers();
    }
       
    public int getEscadas(){
        return jogo.getDadosJogo().getEnemyTracks().getEscada();
    }
    
     public int getAriete(){
        return jogo.getDadosJogo().getEnemyTracks().getAriete();
    }
     
      public int getTorre(){
        return jogo.getDadosJogo().getEnemyTracks().getTorre();
    }
      
     public int getTrincheiras(){
         return jogo.getDadosJogo().getEnemyTracks().getTrincheiras();
     }
    
}
