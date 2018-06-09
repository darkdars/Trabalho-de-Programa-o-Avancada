/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

import logicaJogo.DadosJogo;

/**
 *
 * @author Andre
 */
public class TrebuchetAttack extends Evento{
    
    public TrebuchetAttack(int actions){
        super("Trebuchet Attack", actions, new String[]{"trebuchet", "trebuchet", "damageT"}, new String[]{"damage-wall", "damage-wall", "damage-wall"}, new String[]{"2","1","1"}, 
                "As Trebuchet preparam-se para atacar (com 3 unidades as muralhas recebem 2 de dano, com duas recebem 1 e com uma unidade recebe 1 no entanto tem a posibilidade de lançar D6 e se sair 4, 5 ou 6 o ataque e evitado).");
    }

    @Override
    public void execute(DadosJogo dadosJogo) {
        if(dadosJogo.getEnemyTracks().getTrincheiras() == 3)
            dadosJogo.getStatusCard().updateMuralha(-2);
        else if(dadosJogo.getEnemyTracks().getTrincheiras() == 2)
            dadosJogo.getStatusCard().updateMuralha(-1);
        else if(dadosJogo.getEnemyTracks().getTrincheiras() == 1 && dadosJogo.rollDiceReturn() > 4)
            dadosJogo.getStatusCard().updateMuralha(-1);
        
        
    }
}
