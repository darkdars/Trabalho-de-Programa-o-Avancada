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
public class AwaitPlayerAction extends EstadoAdapter{
    
    public AwaitPlayerAction(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado playerAction(int opcao,int target){
            dadosJogo.rollDice();
        switch(opcao){
            case 0:
                return new AwaitWinLosePhase(dadosJogo);
            case 1: // Archers Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                            }else{
                                dadosJogo.setTexto("Nao da para mover! A Escada ja esta na posicao inicial!");
                                return this;
                            }
                        
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                            }else{
                                dadosJogo.setTexto("Nao da para mover! O ariete ja esta na posicao inicial!");
                                return this;
                            }
          
                        break;
                    case 3: // Siege Tower
                         if(dadosJogo.getEnemyTracks().getTorre() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                            }else{
                                dadosJogo.setTexto("Nao da para mover! A Torre ja esta na posicao inicial!");
                                return this;
                            }
                        break;
                }
                
                
                    
                
            
            case 2: // Boiling Water Attack
                
                break;
            case 3: // Close Combat Attack
                break;
            case 4: // Coupure
                break;
            case 5: // Rally Trops
                break;
            case 6: // Tunnel Movement
                break;
            case 7: // Supply Raid
                break;
            case 8: // Sabotage
                break;
        }
        
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            
        
        return this;
    }
    
    @Override
    public IEstado checkJogadasDisp(){
        if(dadosJogo.getJogadasDisp() == 0){
                return new AwaitWinLosePhase(dadosJogo);
            }
        return this;
    }
}
