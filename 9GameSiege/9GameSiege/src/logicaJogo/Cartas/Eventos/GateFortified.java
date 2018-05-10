/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

/**
 *
 * @author Andre
 */
public class GateFortified extends Evento{
    
    public GateFortified(){
        super("Gate Fortified", 2, new String[]{"ladder", "ram"}, new String[]{"attack-ram"}, new String[]{"1"}, 
                "O grupo da ariete e da escada juntam forcas e avancam uma casa.\nTodos os ataques a ariete recebem um bonus de 1.");
    }
}
