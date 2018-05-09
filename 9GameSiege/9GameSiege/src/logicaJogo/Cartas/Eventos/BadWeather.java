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
public class BadWeather extends Evento{
    
    public BadWeather(){
        super("Bad Weather", 2, new String[]{"none"}, new String[]{"actions-raid", "actions-sabotage"}, new String[]{"only"});
    }
}

