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
    int closeCombatStrengh = 4;
    int escadaStrengh = 2;
    int arieteStrengh = 3;
    int torreStrengh = 4;
    
    
    public EnemyTracks(){
        this.escada = 4;
        this.ariete = 4;
        this.torre = 4;
        this.trincheiras = 1;
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
    
    public void updateEscada(int escada) {
        this.escada += escada;
    }

    public int getAriete() {
        return ariete;
    }

    public void setAriete(int ariete) {
        this.ariete = ariete;
    }
    
    public void updateAriete(int ariete) {
        this.ariete += ariete;
    }

    public int getTorre() {
        return torre;
    }

    public void setTorre(int torre) {
        this.torre = torre;
    }
    
    public void updateTorre(int torre) {
        this.torre += torre;
    }

    public int getTrincheiras() {
        return trincheiras;
    }

    public void setTrincheiras(int trincheiras) {
        this.trincheiras = trincheiras;
    }
    
    public void updateTrincheiras(int trincheiras) {
        this.trincheiras += trincheiras;
    }

    public int getCloseCombatStrengh() {
        return closeCombatStrengh;
    }

    public void setCloseCombatStrengh(int closeCombatStrengh) {
        this.closeCombatStrengh = closeCombatStrengh;
    }

    public int getEscadaStrengh() {
        return escadaStrengh;
    }

    public void setEscadaStrengh(int escadaStrengh) {
        this.escadaStrengh = escadaStrengh;
    }

    public int getArieteStrengh() {
        return arieteStrengh;
    }

    public void setArieteStrengh(int arieteStrengh) {
        this.arieteStrengh = arieteStrengh;
    }

    public int getTorreStrengh() {
        return torreStrengh;
    }

    public void setTorreStrengh(int torreStrengh) {
        this.torreStrengh = torreStrengh;
    }
 
    
}
