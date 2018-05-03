/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

/**
 *
 * @author jhssi
 */



public class Jogo {
    
    public void start(){
        System.out.println("Inicio do Jogo!\n");
        
        
        
        
        
    }
    
    public int dado(){
        int min = 1, max = 6;
        return min + (int)(Math.random() * max);  
    }
    
}
