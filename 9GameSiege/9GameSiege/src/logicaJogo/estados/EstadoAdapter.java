/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import logicaJogo.estados.IEstado;
import logicaJogo.DadosJogo;

/**
 *
 * @author jhssi
 */
public class EstadoAdapter implements IEstado {

    DadosJogo dadosJogo;
    
    public EstadoAdapter(DadosJogo dadosJogo){
        this.dadosJogo = dadosJogo;
    }

    public DadosJogo getDadosJogo() {
        return dadosJogo;
    }

    public void setDadosJogo(DadosJogo dadosJogo) {
        this.dadosJogo = dadosJogo;
    }
    
    
    
    @Override
    public IEstado start() {
        return this;
    }

    @Override
    public IEstado ResolveLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEstado cardChoose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public IEstado enemyMovementPhase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEstado playerAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
