/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

/**
 *
 * @author Andre
 */
public class RepairedTrebuchet extends Evento{
    
    public RepairedTrebuchet(){
        super("Repaired Trebuchet", 2, new String[]{"ladder"}, new String[]{"add-Trebuchet", "action-coupure"}, new String[]{"1", "1"}, 
                "O grupo das escadas avancam uma casa.\nAs Trebuchet foi reparadas, o inimigo adiciona uma Trebuchet(da cap no maximo) e a action coupure durante o evento recebe um bonus de 1.");
    }
}
