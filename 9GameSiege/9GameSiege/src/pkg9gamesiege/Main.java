/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9gamesiege;

import iu.grafico.*;
import iu.grafico.gui.CardSiegeView;
import iu.texto.InterfaceTexto;


/**
 *
 * @author jhssi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //InterfaceTexto iT = new InterfaceTexto();
        //iT.runJogo();
      
        //InterfaceGrafica iG = new InterfaceGrafica();
        //iG.iniciarInterface();

        CardSiegeView GUI = new CardSiegeView(new ObservableGame());
        
    }
    
}
