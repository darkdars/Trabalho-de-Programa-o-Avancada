/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

import logicaJogo.DadosJogo;

/**
 *
 * @author Andre
 */
public class Collapsed extends Evento{
    
    public Collapsed(){
        super("Collapsed!", 2, new String[]{"ladder", "ram"}, new String[]{"remove-tower"}, new String[]{"4"}, 
                "A ariete e as escadas avancam uma casa\nCaso a Torre esteja na casa de partida, esta sera removida do jogo.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
