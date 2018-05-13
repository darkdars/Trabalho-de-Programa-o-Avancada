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
public class AwaitPlayerAction extends EstadoAdapter{
    
    public AwaitPlayerAction(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado playerAction(int opcao,int target){
            dadosJogo.rollDice();
        switch(opcao){
            case 0:
                return new AwaitWinLosePhase(dadosJogo);
            case 1: // Archers Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! A Escada ja esta na posicao inicial!");
                            return this;
                        }

                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! O ariete ja esta na posicao inicial!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                         if(dadosJogo.getEnemyTracks().getTorre() != 4){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! A Torre ja esta na posicao inicial!");
                            return this;
                        }
                        break;
                }
                break;
            case 2: // Boiling Water Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() == 1){
                            if(dadosJogo.getDice() + 1> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Escada nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() == 1){
                            if(dadosJogo.getDice() + 1> dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Ariete nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                         if(dadosJogo.getEnemyTracks().getTorre() == 1){
                            if(dadosJogo.getDice() + 1> dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Torre nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
                        break;
                }
                break;
            case 3: // Close Combat Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() == 0){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Escada nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() == 0){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Ariete nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                         if(dadosJogo.getEnemyTracks().getTorre() == 0){
                            if(dadosJogo.getDice() > dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Torre nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                       }
                        break;
                }
                break;
            case 4: // Coupure
                if(dadosJogo.getStatusCard().getMuralha() < 4){
                    if(dadosJogo.getDice() > 4){
                        dadosJogo.getStatusCard().updateMuralha(1);
                        dadosJogo.setTexto("A muralha foi reparada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMuralha() + ".");
                    }else{
                        dadosJogo.setTexto("Houve um assidente que levou a falha da recuperacao da muralha.");
                    }
                }else{
                        dadosJogo.setTexto("A muralha encontra-se sem dano.");
                        return this;
                } 
                break;
            case 5: // Rally Trops
                if(dadosJogo.getStatusCard().getMuralha() < 4){
                    if((dadosJogo.getDice() + target) > 4){
                        dadosJogo.getStatusCard().updateMoral(1);
                        dadosJogo.setTexto("A moral foi levantada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMoral()+ ".");
                    }else{
                        dadosJogo.setTexto("O discurso foi mal intrepertado pelo povo, mantendo a moral no mesmo nivel.");
                    }
                }else{
                        dadosJogo.setTexto("A moral encontra-se ao maximo.");
                        return this;
                }
                break;
            case 6: // Tunnel Movement
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Entrar no tunel
                        if(dadosJogo.getStatusCard().getTunel() == 1){
                            dadosJogo.getStatusCard().updateTunel(1);
                            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                        }else{
                                dadosJogo.setTexto("As tropas ja se encontram dentro do tunel.");
                                return this;
                        }
                        break;
                    case 2: // Free Movement
                         if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
                            dadosJogo.getStatusCard().updateTunel(1);
                            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                        }else{
                                dadosJogo.setTexto("As tropas nao se encontram dentro do tunel.");
                        }
                        return this;
                    case 3: // Fast Movement
                         if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
                            if(dadosJogo.getStatusCard().isTunelDir()){
                                dadosJogo.getStatusCard().setTunel(4);
                                dadosJogo.getStatusCard().setTunelDir(false);
                                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                                break;
                            }
                            if(!dadosJogo.getStatusCard().isTunelDir()){
                                dadosJogo.getStatusCard().setTunel(1);
                                dadosJogo.getStatusCard().setTunelDir(true);
                                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                            } 
                        }else{
                                dadosJogo.setTexto("As tropas encontram fora do tunel.");
                                return this;
                        }
                        break;
                }
                break;
            case 7: // Supply Raid
                if(dadosJogo.getStatusCard().getRaidMantimentos() < 2){
                    if(dadosJogo.getDice() > 2 && dadosJogo.getDice() < 6){
                        dadosJogo.getStatusCard().updateMoral(1);
                        dadosJogo.setTexto("A moral foi levantada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMoral()+ ".");
                    }else{
                        dadosJogo.setTexto("O discurso foi mal intrepertado pelo povo, mantendo a moral no mesmo nivel.");
                    }
                }else{
                        dadosJogo.setTexto("A moral encontra-se ao maximo.");
                        return this;
                }
                break;
            case 8: // Sabotage
                break;
        }
        
        dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            
        
        return this;
    }
    
    @Override
    public IEstado checkJogadasDisp(){
        if(dadosJogo.getJogadasDisp() == 0){
                return new AwaitWinLosePhase(dadosJogo);
            }
        return this;
    }
}
