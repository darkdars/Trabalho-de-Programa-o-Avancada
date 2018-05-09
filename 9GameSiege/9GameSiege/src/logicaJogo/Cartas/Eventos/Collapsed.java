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
public class Collapsed extends Evento{
    
    public Collapsed(){
        super("Collapsed!", 2, new String[]{"ladder", "ram"}, new String[]{"remove-tower"}, new String[]{"4"});
    }
}
