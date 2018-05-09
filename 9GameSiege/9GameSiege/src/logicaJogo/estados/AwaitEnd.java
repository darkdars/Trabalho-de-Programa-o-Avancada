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
public class AwaitEnd extends EstadoAdapter{
    
    public AwaitEnd(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado end(){
        return new AwaitBeginning(dadosJogo);
    }
}
