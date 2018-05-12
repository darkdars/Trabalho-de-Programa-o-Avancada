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
    public IEstado playerAction(int opcao){
        
        switch(opcao){
            case 0:
                return new AwaitWinLosePhase(dadosJogo);
            case 1: // Archers Attack
                
                break;
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
        
        
        
        
        
        
        return this;
    }
    
    
}
