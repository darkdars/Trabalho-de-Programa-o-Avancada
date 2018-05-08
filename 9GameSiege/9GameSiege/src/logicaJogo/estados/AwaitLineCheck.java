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
        
    }
    
}
