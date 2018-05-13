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
public class BadWeather extends Evento{
    
    public BadWeather(){
        super("Bad Weather", 2, new String[]{"none"}, new String[]{"actions-raid", "actions-sabotage"}, new String[]{"only"}, 
                "Nenhum inimigo vai Avançar durante este evento.\nDurante este evento so accoes de raid e sabotagem podem ser realizadas." );
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
            dadosJogo.setOpcoesUtilizadasIndice(0);
            dadosJogo.setOpcoesUtilizadasIndice(1);
            dadosJogo.setOpcoesUtilizadasIndice(2);
            dadosJogo.setOpcoesUtilizadasIndice(3);
            dadosJogo.setOpcoesUtilizadasIndice(4);
            dadosJogo.setOpcoesUtilizadasIndice(5);
            
    }
    
    
}

