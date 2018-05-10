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
public class DeathLeader extends Evento{
    
    public DeathLeader(){
        super("Death of a Leader", 2, new String[]{"ladder", "tower"}, new String[]{"reduce-morale"}, new String[]{"1"}, 
                "Tanto as escadas como as torres avancam uma casa\nUm leader morrou, a moral e reduzida por 1.");
    }
}
