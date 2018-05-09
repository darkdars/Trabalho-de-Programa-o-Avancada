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
public class AwaitCardSelect extends EstadoAdapter {

    public AwaitCardSelect(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    @Override
    public IEstado cardChoose(){
        //Pegar na carta de cima do baralho
        System.out.println("Falta implementar para pegar na primeira carta!\n");
        return this;
    }
    
}
