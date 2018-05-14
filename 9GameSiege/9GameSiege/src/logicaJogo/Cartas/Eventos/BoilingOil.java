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
public class BoilingOil extends Evento{
    
    public BoilingOil(){
        super("Boiling Oil", 2, new String[]{"ladder", "ram"}, new String[]{"attack-circle"}, new String[]{"2"}, 
                "A escada e o ariete vao atacar neste evento\n Ataque aos circulos inimigos, tem um bonus de 2 no lancamento do dado.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        prepare(dadosJogo);
    }
}
