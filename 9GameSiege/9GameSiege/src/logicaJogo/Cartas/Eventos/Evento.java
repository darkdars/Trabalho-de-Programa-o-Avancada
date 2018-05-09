package logicaJogo.Cartas.Eventos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Evento {
    private String nome;
    private int actionP;
    private List<String> enemy;
    private List<String> evento;
    private List<String> valores;
    
    public Evento(){
        
    }
    
    public Evento(String nome, int actionP, String[] enemy, String[] evento, String[] valores){
        this.nome = nome;
        this.actionP = actionP;
        this.enemy.addAll(Arrays.asList(enemy));
        this.evento.addAll(Arrays.asList(evento));
        this.valores.addAll(Arrays.asList(valores));
    }
    
}
