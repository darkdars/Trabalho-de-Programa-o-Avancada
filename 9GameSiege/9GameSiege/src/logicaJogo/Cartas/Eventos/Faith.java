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
public class Faith extends Evento{
    
    public Faith(){
        super("Faith", 3, new String[]{"ladder", "ram", "ladder"}, new String[]{"attacks-ram", "attacks-ladder", "attacks-tower"}, new String[]{"1", "1", "1"}, "");
    }
}
