/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import java.util.Observer;

/**
 *
 * @author jhssi
 */
public interface IEstado {

      /***** AwaitBeginning  *****/  
        IEstado start();
    
       /***** AwaitTopCard  *****/ 
        IEstado ResolveLine();
        IEstado cardChoose();
        IEstado eventPhase();
        IEstado enemyMovementPhase();
        IEstado avancaPhase();
        
        /***** AwaitEnemyPlayerAction  *****/
        IEstado playerAction(int opcao,int target);
        IEstado checkJogadasDisp();
        
        /***** AwaitEndDayPhase  *****/
        IEstado endDayPhase();
        IEstado winLosePhase();
        IEstado winLoseI();
            
        /***** AwaitEnd *****/ 
        IEstado end();
       
        void addObserver(Observer o);
}
