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
        this.mantimentosRoubados = 0;
        this.tunel = 1;
    }
    
    public StatusCard(int muralha,int moral, int mantimentos, int mantimentosR, int tunel){
        this.muralha = muralha;
        this.moral = moral;
        this.mantimentosRoubados = mantimentosR;
        this.tunel = tunel;
    }

    public int getMuralha() {
        return muralha;
    }

    public void setMuralha(int muralha) {
        this.muralha = muralha;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getMantimentos() {
        return mantimentos;
    }

    public void setMantimentos(int mantimentos) {
        this.mantimentos = mantimentos;
    }

    public int getMantimentosRoubados() {
        return mantimentosRoubados;
    }

    public void setMantimentosRoubados(int mantimentosRoubados) {
        this.mantimentosRoubados = mantimentosRoubados;
    }

    public int getTunel() {
        return tunel;
    }
    
    public String getTunelString(){
        if(this.tunel == 1)
            return "Castle";
        if(this.tunel == 2)
            return "Inicio do Tunel";
        if(this.tunel == 3)
            return "Fim do Tunel";
        if(this.tunel == 4)
            return "Linhas Inimigas";
        
    }

    public void setTunel(int tunel) {
        this.tunel = tunel;
    }
    
    
}


