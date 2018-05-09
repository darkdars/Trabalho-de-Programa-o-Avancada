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
public class AwaitLineCheck extends EstadoAdapter{
    
    public AwaitLineCheck(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado ResolveLine(){
        //ver se está alguem na linha da frente se estiver tem de lancar dado
        if(dadosJogo.enemyLineCheck() == 0){ // Se nao houver passa para CardPlayPhase
            return new AwaitCardSelect(dadosJogo);
        }else{ // se houver seguir os passos
            //Rodar o dado
            dadosJogo.rollDice();
            
            if(dadosJogo.getDice() == 1){ //Soldados capturados
               
                // Primeiro passo
                dadosJogo.setEnemyLineSpace(1); 
                
                //Segundo passo
                
                if(dadosJogo.getSupliesS() != 0)
                    dadosJogo.setSuplies(0);
        
                // Terceiro Passo
                dadosJogo.reduceMoral(1);
                
                
            }
            
            return new AwaitCardSelect(dadosJogo);
      
    }
    
}

}