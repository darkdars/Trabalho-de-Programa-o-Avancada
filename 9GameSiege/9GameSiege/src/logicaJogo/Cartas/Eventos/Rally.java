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
public class Rally extends Evento{
    
    public Rally(){
        super("Rally!", 3, new String[]{"ram", "tower"}, new String[]{"attacks"}, new String[]{""});
    }
}
