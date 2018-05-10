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
public class FlamingArrows extends Evento{
    
    public FlamingArrows(){
        super("Flaming Arrows", 2, new String[]{"tower"}, new String[]{"attack-tower"}, new String[]{"1"}, 
                "O grupo de torres avanca uma casa.\nQualquer ataque contra as torres recebem um bonus de 1.");
    }
}
