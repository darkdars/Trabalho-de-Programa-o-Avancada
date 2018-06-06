/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import logicaJogo.Jogo;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author jhssi
 */
class PainelEventos extends JPanel implements Observer{

    Jogo jogo;
    JLabel restantes;
    
    PainelEventos(Jogo jogo) {
         super();
        
        this.jogo = jogo;
/**
        jogo.getFase().addObserver(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.restantes = new JLabel("Eventos restantes: " + jogo.getNEventosRestantes() + " Ano: " + jogo.getAno());
        restantes.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        this.add(restantes);
        this.add(new Evento(jogo), JPanel.CENTER_ALIGNMENT);
**/
        this.setPreferredSize(new Dimension(200 + 10, 300 + 10));

    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
