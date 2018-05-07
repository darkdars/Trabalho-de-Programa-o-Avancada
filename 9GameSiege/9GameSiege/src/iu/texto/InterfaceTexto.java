/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import java.util.Scanner;
import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
public class InterfaceTexto {
    
    Scanner scanner;
    Jogo jogo;
    
    public InterfaceTexto(){
        //inicia novo jogo
        
        scanner = new Scanner(System.in);
    }

    public InterfaceTexto(Jogo j) {
        this();
        this.jogo = j;
    }

    public void iniciarInterface() {
        
        if(jogo == null){
            mostrarMenuInicial();
        }
        
        
        
        mostrarMenuFinal();
    }

    private void mostrarMenuInicial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarMenuFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
    
}
