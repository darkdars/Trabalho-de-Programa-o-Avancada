/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import logicaJogo.DadosJogo;

/**
 *
 * @author Andre
 */
public class AwaitTunnel extends EstadoAdapter{
    
    public AwaitTunnel(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado enterTunnel(){
        dadosJogo.rollDice();
        if(dadosJogo.getStatusCard().getTunel() == 1){
            dadosJogo.getStatusCard().updateTunel(1);
            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("As tropas ja se encontram dentro do tunel.");
        }
        return new AwaitPlayerAction(dadosJogo);
    }
    
        
    @Override
    public IEstado freeMove(){
        dadosJogo.rollDice();
        if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
            dadosJogo.getStatusCard().updateTunel(1);
            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("As tropas nao se encontram dentro do tunel.");
        }
        return new AwaitPlayerAction(dadosJogo);
    }
    
        
    @Override
    public IEstado fastMove(){
        dadosJogo.rollDice();
        if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
            if(dadosJogo.getStatusCard().isTunelDir()){
                dadosJogo.getStatusCard().setTunel(4);
                dadosJogo.getStatusCard().setTunelDir(false);
                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");

            }
            if(!dadosJogo.getStatusCard().isTunelDir()){
                dadosJogo.getStatusCard().setTunel(1);
                dadosJogo.getStatusCard().setTunelDir(true);
                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
            }
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("As tropas encontram fora do tunel.");
                
        }
        return new AwaitPlayerAction(dadosJogo);
    }    
}
