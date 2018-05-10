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
public class SuppliesSpoiled extends Evento{
    
    public SuppliesSpoiled(){
        super("Supplies Spoiled", 2, new String[]{"ladder"}, new String[]{"reduce-supplies"}, new String[]{"1"}, 
                "As escadas avancam uma unidade.\nAlguns suplementos estragaram-se, os suplementos sao reduzidos por 1.");
    }
}
