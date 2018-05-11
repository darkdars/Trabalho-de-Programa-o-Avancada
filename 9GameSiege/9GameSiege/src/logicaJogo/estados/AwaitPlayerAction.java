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
        
        System.out.println("" + opcao);
        
        
        
        
        
        return this;
    }
    
    
}
