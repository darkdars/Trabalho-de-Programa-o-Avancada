/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JTabbedPane;
import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
public class PainelTecnologias extends JTabbedPane implements Observer
{
    Jogo jogo;

    public PainelTecnologias(Jogo jogo)
    {
        super();

        this.jogo = jogo;

       

        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
