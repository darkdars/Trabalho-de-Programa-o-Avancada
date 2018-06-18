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
public class AwaitCloseCombat extends EstadoAdapter{
    
    public AwaitCloseCombat(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    public IEstado opcaoCloseCombat(int target){
        switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() == 0){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(2) + dadosJogo.getBonusEnemy(3)> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Escada nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() == 0){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(2) + dadosJogo.getBonusEnemy(2)> dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Ariete nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
          
                        break;
    }
        
         dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            if(dadosJogo.checkEnemyCloseCombat() >= 3 || dadosJogo.check0SpaceStatusTrack() >= 2){
                dadosJogo.setTexto("Perdeu!");
            return new AwaitEnd(dadosJogo); 
        }
        
        return this; 
}

}