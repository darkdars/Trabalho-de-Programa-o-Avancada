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
public class TrebuchetAttack extends Evento{
    
    public TrebuchetAttack(){
        super("Trebuchet Attack", 3, {"damageT", "damageT", "damageT"}, {"damageT", "damageT", "damageT"}, {"2","1","1"})
    }
}
