/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import iu.grafico.gui.GameButtonsPanel;
import java.util.Observable;
import javax.swing.JPanel;
import logicaJogo.Jogo;
import logicaJogo.estados.AwaitEnd;
import logicaJogo.estados.AwaitTopCard;
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
    
    public void NextCard()
    {
        
        jogo.setEstado(jogo.getEstado().cardChoose());
        jogo.setEstado(jogo.getEstado().enemyMovementPhase());
        jogo.setEstado(jogo.getEstado().eventPhase());
        jogo.setEstado(jogo.getEstado().avancaPhase());
        
        if(jogo.getEstado() instanceof AwaitEnd)
            jogo.setEstado(jogo.getEstado().end());
       
        
        setChanged();
        notifyObservers();
    }
    
    public void skipCard()
    {
        
        jogo.setEstado(jogo.getEstado().skipCard());
        if(jogo.getDadosJogo().getListaCards() < 6){
            jogo.setEstado(jogo.getEstado().winLosePhase());
        }else{
            jogo.setEstado(jogo.getEstado().endDayPhase());
        }
       
        if(jogo.getEstado() instanceof AwaitTopCard){
            NextCard();
        }
        else if(jogo.getEstado() instanceof AwaitEnd){
            jogo.setEstado(jogo.getEstado().end());
        }
        
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

    public int getMuralha() {
        return jogo.getDadosJogo().getStatusCard().getMuralha();
    }

    public int getMoral() {
        return jogo.getDadosJogo().getStatusCard().getMoral();
    }

    public int getSupplies() {
        return jogo.getDadosJogo().getStatusCard().getMantimentos();
    }

    public int getTunnel() {
        return jogo.getDadosJogo().getStatusCard().getTunel();
    }

    public int getRaidSupplies() {
        return jogo.getDadosJogo().getStatusCard().getMantimentosRoubados();
    }
    
    public void setEstadoAction(int opcao){
        jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
    }
    
    public void cancel() {
        jogo.setEstado(jogo.getEstado().cancel());
        
        setChanged();
        notifyObservers();
    }
    public void change() {
        
        setChanged();
        notifyObservers();
    }
    
    public void awaitArcherAttck(){
        jogo.setEstado(jogo.getEstado().archerAttck());
        setChanged();
        notifyObservers();
    }
    
    public void updateObservers(){
        setChanged();
        notifyObservers();
    }
    
    
}
