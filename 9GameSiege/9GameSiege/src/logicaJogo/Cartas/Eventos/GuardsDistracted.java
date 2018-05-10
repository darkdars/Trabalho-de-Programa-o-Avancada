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
public class GuardsDistracted extends Evento{
    public GuardsDistracted(){
        super("Guards Distracted", 2, new String[]{"sword"}, new String[]{"action-sabotage", "action-morale"},  new String[]{"1", "1"}, "");
    }
}
