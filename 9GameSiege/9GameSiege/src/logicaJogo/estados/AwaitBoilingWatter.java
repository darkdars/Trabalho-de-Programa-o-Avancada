/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import logicaJogo.DadosJogo;

/**
 *
 * @author jhssi
 */
public class AwaitBoilingWatter extends EstadoAdapter{
    
    public AwaitBoilingWatter(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado tower(){
        dadosJogo.rollDice();
        if(dadosJogo.getEnemyTracks().isVidaTorre() == false){
            dadosJogo.setTexto("Nao existe torre! Escolha outra opcao!");
            return new AwaitPlayerAction(dadosJogo);
        }

         if(dadosJogo.getEnemyTracks().getTorre() == 1){
            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(1)> dadosJogo.getEnemyTracks().getTorreStrengh()){
                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
            }else{
                dadosJogo.setTexto("O ataque falhou!");
            }    
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            if(dadosJogo.checkEnemyCloseCombat() >= 3 || dadosJogo.check0SpaceStatusTrack() >= 2){
                dadosJogo.setTexto("Perdeu!");
                return new AwaitEnd(dadosJogo); 
            }
        }else{
            dadosJogo.setTexto("Nao da para atacar! A Torre nao esta dentro do circulo (casa 1)!");
        }
        
        return new AwaitPlayerAction(dadosJogo);
    }
    
    @Override
    public IEstado ariete(){
        dadosJogo.rollDice();
        if(dadosJogo.getEnemyTracks().getAriete() == 1){
            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(2)> dadosJogo.getEnemyTracks().getArieteStrengh()){
                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
            }else{
                dadosJogo.setTexto("O ataque falhou!");
            }    
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            if(dadosJogo.checkEnemyCloseCombat() >= 3 || dadosJogo.check0SpaceStatusTrack() >= 2){
                dadosJogo.setTexto("Perdeu!");
            return new AwaitEnd(dadosJogo); 
            }  
        }else{
            dadosJogo.setTexto("Nao da para atacar! A Ariete nao esta dentro do circulo (casa 1)!");
        }
        
        return new AwaitPlayerAction(dadosJogo);
    }
    
    @Override
    public IEstado escadas(){
        dadosJogo.rollDice();
        if(dadosJogo.getEnemyTracks().getEscada() == 1){
            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(3)> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
            }else{
                dadosJogo.setTexto("O ataque falhou!");
            }    
              dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            if(dadosJogo.checkEnemyCloseCombat() >= 3 || dadosJogo.check0SpaceStatusTrack() >= 2){
                dadosJogo.setTexto("Perdeu!");
            return new AwaitEnd(dadosJogo); 
            }
        }else{
            dadosJogo.setTexto("Nao da para atacar! A Escada nao esta dentro do circulo (casa 1)!");
        }
        return new AwaitPlayerAction(dadosJogo);
    }
    
}
