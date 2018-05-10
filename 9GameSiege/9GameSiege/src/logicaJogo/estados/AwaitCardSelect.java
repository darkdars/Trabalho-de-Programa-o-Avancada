/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import java.util.HashSet;
import java.util.Set;
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
        dadosJogo.setCartaSelecionada(dadosJogo.getCard(dadosJogo.getListaCards()));
        return this;
    }
    
    @Override
    public IEstado eventPhase(){
        //Determina evento e faz o que o evento faz
        //dadosJogo.setEvento();
        
        return new AwaitEnemyMovementPhase(dadosJogo);
    }
    
    
}
