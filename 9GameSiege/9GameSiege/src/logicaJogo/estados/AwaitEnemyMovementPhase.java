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
         
         //Ver se é preciso condicoes para decrementar
         
         if(dadosJogo.getEventoAtual().getEnemySize() > 1){
                
             for(int i = 0; i < dadosJogo.getEventoAtual().getEnemySize();i++){
                 
                 if(dadosJogo.getEventoAtual().getEnemyString(i) == "tower"){
                     dadosJogo.getEnemyTracks().updateTorre(-1);
                 }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "ram"){
                     dadosJogo.getEnemyTracks().updateAriete(-1);
                 }else if(dadosJogo.getEventoAtual().getEnemyString(i) == "ladder"){
                     dadosJogo.getEnemyTracks().updateEscada(-1);
                 }
             
             
             }
               
         }else{
             if(dadosJogo.getEventoAtual().getEnemyString(0) == "sword"){
                 //Obter unidades mais lentas
                 for(int i = 0; i < 3;i++){
               
                     if((dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getTorre() &&  dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getAriete() && dadosJogo.getEnemyTracks().getTorre() == dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateEscada(-1);
                        dadosJogo.getEnemyTracks().updateAriete(-1);
                        dadosJogo.getEnemyTracks().updateTorre(-1);    
                    }else if((dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getTorre() &&  dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getAriete() && dadosJogo.getEnemyTracks().getTorre() != dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateAriete(-1);
                        dadosJogo.getEnemyTracks().updateEscada(-1);   
                    }else if((dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getTorre() &&  dadosJogo.getEnemyTracks().getEscada() != dadosJogo.getEnemyTracks().getAriete() && dadosJogo.getEnemyTracks().getTorre() == dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateAriete(-1);
                        dadosJogo.getEnemyTracks().updateTorre(-1);    
                    }else if((dadosJogo.getEnemyTracks().getEscada() != dadosJogo.getEnemyTracks().getTorre() &&  dadosJogo.getEnemyTracks().getEscada() == dadosJogo.getEnemyTracks().getAriete() && dadosJogo.getEnemyTracks().getTorre() == dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateEscada(-1);
                        dadosJogo.getEnemyTracks().updateTorre(-1);    
                    }else if((dadosJogo.getEnemyTracks().getEscada() >= dadosJogo.getEnemyTracks().getTorre() &&  dadosJogo.getEnemyTracks().getEscada() >= dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateEscada(-1);    
                    }else if((dadosJogo.getEnemyTracks().getEscada() <= dadosJogo.getEnemyTracks().getTorre() && dadosJogo.getEnemyTracks().getTorre() >= dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateTorre(-1);    
                    }else if((dadosJogo.getEnemyTracks().getEscada() <= dadosJogo.getEnemyTracks().getAriete() && dadosJogo.getEnemyTracks().getTorre() <= dadosJogo.getEnemyTracks().getAriete())){
                        dadosJogo.getEnemyTracks().updateAriete(-1);    
                    }
                 }
                              
             }else if(dadosJogo.getEventoAtual().getEnemyString(0) == "tower"){
                 dadosJogo.getEnemyTracks().updateTorre(-1);
             }else if(dadosJogo.getEventoAtual().getEnemyString(0) == "ladder"){
                 dadosJogo.getEnemyTracks().updateEscada(-1);
             }else if(dadosJogo.getEventoAtual().getEnemyString(0) == "ram"){
                 dadosJogo.getEnemyTracks().updateAriete(-1);
             }else if(dadosJogo.getEventoAtual().getEnemyString(0) == "none"){
                 return new AwaitPlayerAction(dadosJogo);
             }
             
             }
             
      
         return this;
     
}
     
     @Override
     public IEstado avancaPhase(){
         return new AwaitPlayerAction(dadosJogo);
     }
     
}
