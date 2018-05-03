/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9gamesiege;

import logicaJogo.Jogo;


/**
 *
 * @author jhssi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Jogo jogo = new Jogo();
        
        jogo.start();
        
        
        System.out.println("Fim do jogo!\n");
        
    }
    
}
