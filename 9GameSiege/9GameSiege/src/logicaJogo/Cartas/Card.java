/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import logicaJogo.Cartas.Eventos.Evento;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Card {
    private int numCarta;
    private List<Evento> eventos;
    
    public Card(int num, Evento ev1, Evento ev2, Evento ev3){            
       this.numCarta = num;
       eventos.add(ev1);
       eventos.add(ev2);
       eventos.add(ev3);              
    }
}
