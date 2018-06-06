/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
public class InterfaceGrafica {
    
     Jogo jogo  = new Jogo();

    public void iniciarInterface()
    {
        FramePrincipal fp = new FramePrincipal();

        //jogo.configurar();

        //FrameJogo fp = new FrameJogo(jogo);
    }
}
