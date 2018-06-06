/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
class FrameJogo extends JFrame {

    private Container cp;
    Jogo jogo;
    
    FrameJogo(Jogo j) {
        
        super("9 Card Siege"); // Define o titulo da frame

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jogo = j;

        cp = this.getContentPane();

        cp.setLayout(new GridBagLayout());

        actualizarFrame();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);

        setSize(1350, 800);

        validate();
    }
     
    void actualizarFrame()
    {
        cp.removeAll();

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 2;
        c.gridheight = 3;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        cp.add(new PainelRecursos(jogo), c);


        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 6;
        cp.add(new PainelSistemasPerto(jogo), c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        cp.add(new PainelSistemasLonge(jogo), c);

        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.insets.top = 10;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        PainelEventos pe = new PainelEventos(jogo);

        pe.setAlignmentX(PainelEventos.LEFT_ALIGNMENT);
        cp.add(pe, c);


        c.insets.top = 0;
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 10;
        c.insets.left = 15;

        PainelTecnologias pt = new PainelTecnologias(jogo);
        pt.setAlignmentY(JPanel.RIGHT_ALIGNMENT);
        cp.add(pt, c);

        c.anchor = GridBagConstraints.WEST;
        c.insets.left = 0;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.anchor = GridBagConstraints.CENTER;
        cp.add(new PainelBotoesSituacionais(jogo), c);
    }
}
