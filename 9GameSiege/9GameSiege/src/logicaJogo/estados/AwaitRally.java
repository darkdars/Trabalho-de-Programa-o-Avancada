/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import logicaJogo.DadosJogo;

/**
 *
 * @author jhssi
 */
public class AwaitRally extends EstadoAdapter{
    
    public AwaitRally(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    @Override
    public IEstado normalRally(){
        dadosJogo.rollDice();
        if(dadosJogo.getStatusCard().getMoral() < 4){
            if((dadosJogo.getDice() + dadosJogo.getBonusEvent(4)) > 4){
                dadosJogo.getStatusCard().updateMoral(1);
                dadosJogo.setTexto("A moral foi levantada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMoral()+ ".");
            }else{
                dadosJogo.setTexto("O discurso foi mal intrepertado pelo povo, mantendo a moral no mesmo nivel.");
            }
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("A moral encontra-se ao maximo.");
        }
        return new AwaitPlayerAction(dadosJogo);
    }
    
    @Override
    public IEstado superRally(){
        dadosJogo.rollDice();
        if(dadosJogo.getStatusCard().getMantimentosRoubados() < 0)
            return new AwaitPlayerAction(dadosJogo);
        
        if(dadosJogo.getStatusCard().getMoral() < 4){
            if((dadosJogo.getDice() + dadosJogo.getBonusEvent(4)) > 4){
                dadosJogo.getStatusCard().updateMoral(1);
                dadosJogo.setTexto("A moral foi levantada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMoral()+ ".");
            }else{
                dadosJogo.setTexto("O discurso foi mal intrepertado pelo povo, mantendo a moral no mesmo nivel.");
            }   
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("A moral encontra-se ao maximo.");
        }
        return new AwaitPlayerAction(dadosJogo);
    }
    
    @Override
    public IEstado cancel() {
        return new AwaitPlayerAction(dadosJogo);
    }
                
    
}
