/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import java.util.ArrayList;
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
       eventos = new ArrayList<>();
       eventos.add(ev1);
       eventos.add(ev2);
       eventos.add(ev3);              
    }
    
    public int getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
    
    public Evento getEventos(int dia) {
        return eventos.get(dia);
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
