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

    public int getEscada() {
        return escada;
    }

    public void setEscada(int escada) {
        this.escada = escada;
    }

    public int getAriete() {
        return ariete;
    }

    public void setAriete(int ariete) {
        this.ariete = ariete;
    }

    public int getTorre() {
        return torre;
    }

    public void setTorre(int torre) {
        this.torre = torre;
    }

    public int getTrincheiras() {
        return trincheiras;
    }

    public void setTrincheiras(int trincheiras) {
        this.trincheiras = trincheiras;
    }
 
}
