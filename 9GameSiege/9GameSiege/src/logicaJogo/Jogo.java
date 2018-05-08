/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import logicaJogo.estados.AwaitBeginning;
import logicaJogo.estados.IEstado;
import java.util.List;

/**
 *
 * @author jhssi
 */



public class Jogo {

    private DadosJogo dadosJogo;
    private IEstado estado;
    
    public Jogo(){
     dadosJogo = new DadosJogo();
     estado = new AwaitBeginning(dadosJogo);      
    }
    
    public void CheckStart(){
        setEstado(getEstado().start());
    }

    public DadosJogo getDadosJogo() {
        return dadosJogo;
    }

    public void setDadosJogo(DadosJogo dadosJogo) {
        this.dadosJogo = dadosJogo;
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    
  
    

   

    
    
    
    
        
}
