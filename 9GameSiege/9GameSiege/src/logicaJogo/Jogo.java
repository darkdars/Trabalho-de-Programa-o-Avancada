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



public class Jogo extends EstadoAdapter {
    
 
    
    public IEstado lancaDados(int numero){
        int min = 1, max = 6;
        numero =  min + (int)(Math.random() * max);  
        return this;
    }
    
}
