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
public class DeterminedEnemy extends Evento{
    
    public DeterminedEnemy(){
        super("Determined Enemy", 2, new String[]{"ram"}, new String[]{"attacks-ram"}, new String[]{"-1"});
    }
}
