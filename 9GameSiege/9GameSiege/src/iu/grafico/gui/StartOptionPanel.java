/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitBeginning;

/**
 *
 * @author jhssi
 */
public class StartOptionPanel extends JPanel implements Observer{

    ObservableGame game;
    
    //Opcoes
     JButton iniciar = new JButton("Iniciar");
     JButton acerca = new JButton("Acerca");
     JButton sair = new JButton("Sair");
     
     //Imagem
     String imageFiles ="imagens/paginaInicial.png";
     Image home;
     
     
     StartOptionPanel(ObservableGame g) 
    {
        game=g;
        game.addObserver(this);

        setupComponentes();
        setupLayout();
        
        
        setVisible(game.getEstado() instanceof AwaitBeginning);
        

    }
     
     private void setupLayout()
    {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        iniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        acerca.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(Box.createHorizontalBox());
        add(iniciar);
        
        add(Box.createVerticalStrut(10));
        add(acerca);
        
        add(Box.createHorizontalBox());
        add(sair);
       
       
   
         validate();
       
    }
     
     private void setupComponentes(){
      
         iniciar.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ev) {
                
               game.ResolveStart();
            }
         });
         
     
         acerca.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ev) {
                
               //game.ResolveInicio();
            }
         });
         
         sair.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ev) {
               System.exit(0); 
               
            }
         });
         
         
     }
     
     
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        try {
            home = ImageIO.read(Resources.getResourceFile(imageFiles));
        } catch (IOException ex) {
            
        }
        g.drawImage(home,0,0,getWidth()-1,getHeight()-1,null);
    }
     
     
    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getEstado() instanceof AwaitBeginning);
    }
    
}
