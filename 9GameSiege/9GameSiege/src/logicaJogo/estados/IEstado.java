/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

/**
 *
 * @author jhssi
 */
public interface IEstado {

    
      /***** AwaitBeginning  *****/  
    
        IEstado start();
    
        /***** AwaitLineCheck
     * @return  *******/
        
        IEstado ResolveLine();
        
         /***** AwaitCardSelect  *****/  
       
        IEstado cardChoose();
        IEstado eventPhase();
        
        /***** AwaitEnemyMovementPhase  *****/ 
        IEstado enemyMovementPhase();
        
        /***** AwaitEnemyPlayerAction  *****/
        IEstado playerAction();
        
        /***** AwaitCheck  *****/ 
        
        /***** AwaitWinLosePhase  *****/ 
        IEstado winLosePhase();
        IEstado winLoseI();

        /***** AwaitEnd *****/ 
        IEstado end();
        
        
        
}
