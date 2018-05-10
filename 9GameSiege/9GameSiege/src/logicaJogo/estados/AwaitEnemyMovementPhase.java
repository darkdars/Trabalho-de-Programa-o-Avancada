/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import java.util.List;
import logicaJogo.DadosJogo;

/**
 *
 * @author jhssi
 */
public class AwaitEnemyMovementPhase extends EstadoAdapter{
    
    public AwaitEnemyMovementPhase(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
     public IEstado enemyMovementPhase(){ 

         //Primeiro Obter evento depois dar handle
         
         for(int i = 0; i < dadosJogo.getEventoAtual().getEnemySize();i++){
             
             if(dadosJogo.getEventoAtual().getEnemyString(i) == "sword"){
                 //Obter unidades mais lentas
                 
                 
                 
                 
                 
                 
             }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "tower"){
                 
             }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "ladder"){
                 
             }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "ram"){
                 
             }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "none"){
                 
             }
             
             
         }
         
         
         
         
         return this;
     }
    
}
