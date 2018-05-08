/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.List;
import logicaJogo.eventos.IEventos;

/**
 *
 * @author jhssi
 */



public class Jogo {
    
    IEstado estado;
    
    List<IEventos> eventos;
    IEventos ultimoEventoUtilizado;
    int eventoAtual;
    
    int dia;
    
    
        
}
