/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import logicaJogo.estados.AwaitBeginning;
import logicaJogo.estados.IEstado;
import java.util.List;
import logicaJogo.estados.AwaitCardSelect;

/**
 *
 * @author jhssi
 */



public class Jogo {

    private DadosJogo dadosJogo;
    private IEstado estado;
    
    public Jogo(){
     dadosJogo = new DadosJogo();
     estado = new AwaitBeginning(dadosJogo);      
    }
    
    public void CheckStart(){
        setEstado(getEstado().start());
    }
    
    public DadosJogo getDadosJogo() {
        return dadosJogo;
    }

    public void setDadosJogo(DadosJogo dadosJogo) {
        this.dadosJogo = dadosJogo;
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    
    public String getTextoDadosJogo(){
        return dadosJogo.getTexto();
    }
    
    public void setTextoDadosJogo(String texto){
        dadosJogo.setTexto(texto);
    }

    public int lineCheck() {
        //ver se está alguem na linha da frente se estiver tem de lancar dado
        if(dadosJogo.enemyLineCheck() != 0){ // Se nao houver passa para CardPlayPhase
          
            //Rodar o dado
            dadosJogo.rollDice();
            
            if(dadosJogo.getDice() == 1){ //Soldados capturados
               
                // Primeiro passo
                dadosJogo.setEnemyLineSpace(1); 
                
                //Segundo passo
                
                if(dadosJogo.getSupliesS() != 0)
                    dadosJogo.setSuplies(0);
        
                // Terceiro Passo
                dadosJogo.reduceMoral(1);  
        }
            return dadosJogo.getDice();
    }
        return 0;
    }
  
    

   

    
    
    
    
        
}
