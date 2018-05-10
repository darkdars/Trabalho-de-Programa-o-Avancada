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
public class CoverDarkness extends Evento{
    
    public CoverDarkness(){
        super("Cover Darkness", 3, new String[]{"sword"}, new String[]{"actions-sabotage", "actions-raid"}, new String[]{"1", "1"},
                "Os inimigos mais longe do castelo avancam uma casa.\nAs accoes de Sabotage e de raid tem bonus de 1, no lancamento do dado.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
