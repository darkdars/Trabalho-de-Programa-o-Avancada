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
public class EnemyFatigue extends Evento{
    
    public EnemyFatigue(){
        super("Enemy Fatigue", 3, new String[]{"ladder"}, new String[]{"actions-sabotage", "actions-raid", "actions-coupure"}, new String[]{"1", "1", "1"}, 
                "O grupo das escadas avanca uma casa.\nNeste evento as accoes de coupure, raid e sabotagem recebem um bonus de 1.");
    }
}
