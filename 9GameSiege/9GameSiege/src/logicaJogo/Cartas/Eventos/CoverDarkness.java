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
public class CoverDarkness extends Evento{
    
    public CoverDarkness(){
        super("Cover Darkness", 3, new String[]{"sword"}, new String[]{"action-sabotage", "action-raid"}, new String[]{"1", "1"});
    }
}
