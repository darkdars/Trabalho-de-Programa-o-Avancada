/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.util.Observable;
import logicaJogo.Jogo;
import logicaJogo.estados.IEstado;

/**
 *
 * @author jhssi
 */
public class ObservableGame extends Observable{
    Jogo jogo;
    
    public ObservableGame(){
        jogo = new Jogo();
    }
    
    public IEstado getEstado()
    {
        return jogo.getEstado();
    }
    
}
