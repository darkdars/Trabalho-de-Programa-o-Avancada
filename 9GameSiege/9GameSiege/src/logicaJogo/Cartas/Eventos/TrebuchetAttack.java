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
    
    public TrebuchetAttack(int actions){
        super("Trebuchet Attack", actions, new String[]{"trebuchet", "trebuchet", "damageT"}, new String[]{"damage-wall", "damage-wall", "damage-wall"}, new String[]{"2","1","1"}, "");
    }
}
