/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logicaJogo.Cartas.Card;

/**
 *
 * @author jhssi
 */
public class DadosJogo {
    
    public int dia;
    public int dice;
    public EnemyTracks enemyTracks;
    public StatusCard statusCard;
    public List<Card> cartas;
    public int listaCards; // Vai de 0 a 6 // 7 cartas
    public String texto;
    

    public DadosJogo(){
        dia = 1;
        enemyTracks = new EnemyTracks();
        statusCard = new StatusCard();
        texto="";
        
        cartas = new ArrayList<>();
        
    }
    
    public void baralhaCartas(){
        //Collections.shuffle(cartas);
        System.out.println("Falta implementar! ESTOU NO DADOSJOGO BARALHA CARTAS!\n");
    }
    
    /**Funcao para fazer EnemyLineCheck
     * @return */
    public int enemyLineCheck(){
        if(statusCard.getTunel() == 2 || statusCard.getTunel() == 3){
            return 1;
        }
        
        return 0;
    }
    
    //Lancar dados
    public void rollDice(){
        setDice((int)(6 * Math.random()) + 1);
    }
    
    //Set EnemyLineSpace
    public void setEnemyLineSpace(int line){
        statusCard.setTunel(line);
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getSupliesS() {
        return statusCard.getMantimentosRoubados();
    }

    public void setSuplies(int i) {
        statusCard.setMantimentosRoubados(i);
    }

    public void reduceMoral(int i) {
        statusCard.setMoral(statusCard.getMoral() - 1);
    }

    public int checkEnemyCloseCombat() { // Checka numero de inimigos em closecombat
        int x = 0;
        
        if(enemyTracks.getEscada() == 0)
            x++;
       
        if(enemyTracks.getTorre() == 0)
            x++;
                    
        if(enemyTracks.getTrincheiras() == 0)
            x++;
        
        return x;
    }

    public boolean check0SpaceStatusTrack() {
        
        if(statusCard.getMoral() == 0 || statusCard.getMantimentos() == 0 || statusCard.getMuralha() == 0)
            return true;
        
        return false;
    }
    
}
