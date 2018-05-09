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
public class IronShields extends Evento{
    
    public IronShields(){
        super("Iron Shields", 2, new String[]{"tower"}, new String[]{"attacks-tower"}, new String[]{"-1"});
    }
}
