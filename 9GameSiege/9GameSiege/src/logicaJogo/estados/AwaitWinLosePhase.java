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
public class AwaitWinLosePhase extends EstadoAdapter{
    
    public AwaitWinLosePhase(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado winLosePhase(){
        //MUDAr
        if(dadosJogo.checkEnemyCloseCombat() >= 2 || dadosJogo.check0SpaceStatusTrack()){
            return new AwaitEnd(dadosJogo);
        }
        
        
        return new AwaitBeginning(dadosJogo);
    }
    
}
