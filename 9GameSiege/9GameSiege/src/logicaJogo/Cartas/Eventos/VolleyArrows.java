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
public class VolleyArrows extends Evento{
    
    public VolleyArrows(){
        super("Volley Arrows", 3, new String[]{"ram"}, new String[]{"attack-all"}, new String[]{"1"}, 
                "O grupo da ariete avanca uma unidade\nDurante este evento todos os ataques recebem um bonus de 1.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        prepare(dadosJogo);
    }
}
