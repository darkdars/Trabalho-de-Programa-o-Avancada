/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import estados.AwaitBeginning;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
public class InterfaceTexto {
    
    Scanner scanner;
    private Jogo jogo;
    
    public InterfaceTexto(){
        //inicia novo jogo
        
        scanner = new Scanner(System.in);
    }

    public InterfaceTexto(Jogo j) {
        this();
        this.jogo = j;
    }


    private void mostrarMenuInicial() {
        while(jogo == null){
            System.out.println("Deseja [c]arregar um jogo ou iniciar um [n]ovo?");
        
            switch(leCaracter()){
                case 'c':
                case 'C':
                    mostrarMenuCarregar();
                    break;
                case 'n':
                case 'N':
                    jogo = new Jogo();
                    break;
                default:
                    
            }
        }
        
        
    }
    
     public void run() {
        int i = 1;
        
        while(i == 1){
            if(jogo.getEstado() instanceof AwaitBeginning)
                mostrarMenuInicial();
        }
    }

    private void mostrarMenuFinal() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Fim do JOGO!\n");
    }

    char leCaracter() {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            System.in.read(new byte[System.in.available()]);

            //Le
            char c = (char)System.in.read();
            
            //limpa
            System.in.read(new byte[System.in.available()]);
            
            return c;
        } catch (IOException ex) {
            Logger.getLogger(InterfaceTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
       
    }

    private void mostrarMenuCarregar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
   
   
    
    
}
