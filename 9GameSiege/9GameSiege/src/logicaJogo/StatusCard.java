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
public class StatusCard {
    int muralha;
    int moral;
    int mantimentos;
    int mantimentosRoubados;
    int tunel;
    
    public StatusCard(){
        this.muralha = 4;
        this.moral = 4;
        this.mantimentos = 4;
        this.mantimentosRoubados = 4;
        this.tunel = 0;
    }
    
    public StatusCard(int muralha,int moral, int mantimentos, int mantimentosR, int tunel){
        this.muralha = muralha;
        this.moral = moral;
        this.mantimentosRoubados = mantimentosR;
        this.tunel = tunel;
    }
}


