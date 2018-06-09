/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import com.sun.glass.events.KeyEvent;
import iu.grafico.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author jhssi
 */
public class CardSiegeView extends JFrame implements Observer{

     ObservableGame game;
     CardSiegeGamePanel panel;
    
    public CardSiegeView(ObservableGame j)
    {
        super("Card Siege");
        
        game = j;
        game.addObserver(this);
        
       panel = new CardSiegeGamePanel(game);
       
       addComponents();
       menu();
       
       setVisible(true);
       this.setSize(700,500);
       this.setMinimumSize(new Dimension(650, 450));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       validate();
    }
    
    
      private void addComponents()
    {
        Container cp=getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel,BorderLayout.CENTER);
    }
      
      private void menu(){
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu gameMenu = new JMenu("Jogo");
         
        JMenuItem newObjJMI = new JMenuItem("Parar");
        newObjJMI.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        JMenuItem readObjJMI = new JMenuItem("Carregar");
        newObjJMI.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        
        JMenuItem saveObjJMI = new JMenuItem("Gravar");
        newObjJMI.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        JMenuItem exitObjJMI = new JMenuItem("Sair");
        newObjJMI.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        
        gameMenu.add(newObjJMI);
        gameMenu.add(readObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.addSeparator();
        
        gameMenu.add(exitObjJMI);
        menuBar.add(gameMenu);
        
        newObjJMI.addActionListener(new ObjMenuBarListener());
        readObjJMI.addActionListener(new CarregarObjMenuBarListener());
        saveObjJMI.addActionListener(new GravarObjMenuBarListener());
        exitObjJMI.addActionListener(new SairListener());
        
        JMenu helpMenu = new JMenu("Opções");
        
        JMenuItem helpContentJMI = new JMenuItem("Ajuda");
        helpContentJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        
        JMenuItem aboutJMI = new JMenuItem("Acerca");
        aboutJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        
        helpMenu.add(helpContentJMI);
        helpMenu.add(aboutJMI);
        menuBar.add(helpMenu);
        
        helpContentJMI.addActionListener(new AjudaListener());
        aboutJMI.addActionListener(new AcercaListener());
      }

        class ObjMenuBarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
      
     class CarregarObjMenuBarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
      
      class GravarObjMenuBarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
      
       class SairListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
       
       class AjudaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
       
       class AcercaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
        }
       
       
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
