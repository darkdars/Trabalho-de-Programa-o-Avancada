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
public class IronShields extends Evento{
    
    public IronShields(){
        super("Iron Shields", 2, new String[]{"tower"}, new String[]{"attack-tower"}, new String[]{"-1"}, 
                "As torres avancam uma unidade.\nAs torres fortificaram os seu escudos, dai qualquer ataque as torres e reduzido por 1.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
