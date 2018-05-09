package logicaJogo.Cartas.Eventos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
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
        this.enemy = new ArrayList<>();
        this.evento = new ArrayList<>();
        this.valores = new ArrayList<>();
        this.enemy.addAll(Arrays.asList(enemy));
        this.evento.addAll(Arrays.asList(evento));
        this.valores.addAll(Arrays.asList(valores));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getActionP() {
        return actionP;
    }

    public void setActionP(int actionP) {
        this.actionP = actionP;
    }

    public List<String> getEnemy() {
        return enemy;
    }

    public void setEnemy(List<String> enemy) {
        this.enemy = enemy;
    }

    public List<String> getEvento() {
        return evento;
    }

    public void setEvento(List<String> evento) {
        this.evento = evento;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
    
    
}
