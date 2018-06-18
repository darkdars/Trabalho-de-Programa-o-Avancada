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
        IEstado skipCard();
        IEstado archerAttck();
        IEstado boilingWater();
        IEstado closeCombat();
        IEstado rally();
        IEstado tunnel();
        
        /***** AwaitArchersAttack/  AwaitBoilingWatter / AwaitCloseCombat *****/
        IEstado tower();
        IEstado ariete();
        IEstado escadas();
        
        /***** AwaitRally  *****/
        IEstado normalRally();
        IEstado superRally();
        
        /***** AwaitTunnel  *****/
        IEstado enterTunnel();
        IEstado freeMove();
        IEstado fastMove();
        
        /***** AwaitEndDayPhase  *****/
        IEstado endDayPhase();
        IEstado winLosePhase();
        IEstado winLoseI();
            
        /***** AwaitEnd *****/ 
        IEstado end();
        IEstado opcaoArchersAttack(int target);
        IEstado opcaoCloseCombat(int target);
        IEstado opcaoBoilingWatter(int target);
       
        void addObserver(Observer o);
}
