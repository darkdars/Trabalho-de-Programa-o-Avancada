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
public class AwaitBeginning extends EstadoAdapter {
    
    public AwaitBeginning(DadosJogo dadosJogo){
        super(dadosJogo);
    }
    
   @Override
   public IEstado start(){
       dadosJogo.newDadosJogo();
       dadosJogo.baralhaCartas();
       return new AwaitTopCard(dadosJogo);
   }
    
}
