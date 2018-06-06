/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import logicaJogo.Jogo;
/**
 *
 * @author jhssi
 */
class FramePrincipal extends JFrame {
    
    public FramePrincipal(){
        super();
        
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
         JButton temp;

        this.getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));

        temp = new JButton("Começar novo jogo");
        temp.addActionListener(new NovoListener());
        temp.setAlignmentX(JButton.CENTER_ALIGNMENT);
        this.getContentPane().add(temp);

        this.getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));

        temp = new JButton("Carregar Jogo");
        temp.addActionListener(new CarregarListener());
        temp.setAlignmentX(JButton.CENTER_ALIGNMENT);
        this.getContentPane().add(temp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setSize(new Dimension(200, 500));
        validate();
    }
    
    FramePrincipal getMe() { return this; }
    
    private class NovoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getMe().setVisible(false);
            Jogo jogo = new Jogo();
            jogo.CheckStart();
            FrameJogo fj = new FrameJogo(jogo);
            fj.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    getMe().setVisible(true);
                }
            });
        }
    }
    
     private class CarregarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser guardar = new JFileChooser();
            guardar.addChoosableFileFilter(new SaveFilter());
            guardar.setAcceptAllFileFilterUsed(false);
            int retorno = guardar.showOpenDialog(getMe());

            Jogo jogo;

            if (retorno == JFileChooser.APPROVE_OPTION) {
                File file = guardar.getSelectedFile();
                //This is where a real application would open the file.
                jogo = Jogo.carregarJogo(file.getAbsolutePath());

                FrameJogo fj = new FrameJogo(jogo);
                fj.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        getMe().setVisible(true);
                    }
                });
            }
        }
}
     
public class SaveFilter extends FileFilter {

            //Accept all directories and all gif, jpg, tiff, or png files.
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }

                if(f.getAbsolutePath().endsWith(".mse")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "Jogos MSE";
            }
        }
    }

