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
public class EnemyTracks {
    //Ver se existe maneira melhor de declarar isto
    int escada;
    int ariete;
    int torre;
    int trincheiras;
    
    public EnemyTracks(){
        this.escada = 4;
        this.ariete = 4;
        this.torre = 4;
        this.trincheiras = 4;
    }
    
    public EnemyTracks(int escada, int ariete, int torre, int trincheiras){
        this.escada = escada;
        this.ariete = ariete;
        this.torre = torre;
        this.trincheiras = trincheiras;
    }
}
