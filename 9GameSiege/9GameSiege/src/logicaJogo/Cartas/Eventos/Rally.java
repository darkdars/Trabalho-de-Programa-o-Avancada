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
public class Rally extends Evento{
    
    public Rally(){
        super("Rally!", 3, new String[]{"ram", "tower"}, new String[]{"attacks-close", "attacks-circle"}, new String[]{"1", "1"}, 
                "A ariete e a escada avancam uma unidade.\nOs ataques em close combat e nos circulos recebem um bonus de 1.");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
