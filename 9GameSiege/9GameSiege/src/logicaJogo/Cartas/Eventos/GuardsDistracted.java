/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

import logicaJogo.DadosJogo;

/**
 *
 * @author Andre
 */
public class GuardsDistracted extends Evento{
    public GuardsDistracted(){
        super("Guards Distracted", 2, new String[]{"sword"}, new String[]{"actions-sabotage", "actions-morale"},  new String[]{"1", "1"}, 
                "A(s) unida(s) atrasada(s) recebe(m) um boste de moral e avanca(m) uma unidade");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        prepare(dadosJogo);
    }
}
