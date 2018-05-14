package logicaJogo.Cartas.Eventos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import logicaJogo.DadosJogo;

/**
 *
 * @author Andre
 */
public abstract class Evento {
    private String nome;
    private String info;
    private int actionP;
    private List<String> enemy;
    private List<String> evento;
    private List<String> valores;
    
    public Evento(){
        
    }
    
    public Evento(String nome, int actionP, String[] enemy, String[] evento, String[] valores, String info){
        this.nome = nome;
        this.actionP = actionP;
        this.enemy = new ArrayList<>();
        this.evento = new ArrayList<>();
        this.valores = new ArrayList<>();
        this.enemy.addAll(Arrays.asList(enemy));
        this.evento.addAll(Arrays.asList(evento));
        this.valores.addAll(Arrays.asList(valores));
        this.info = info; 
    }
    
    public String getEnemyString(int i){
        return this.enemy.get(i);
    }
    
    public int getEnemySize(){
        return this.enemy.size();
    }
    
    public String getInfo(){
        return info;
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
    
    public String getEventoString(int i){
        return this.evento.get(i);
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
    
    public String getValoresString(int i){
        return this.valores.get(i);
    }
    
    public void prepare(DadosJogo dadosJogo){
        for(int i = 0; i < enemy.size(); i++){
            String[] evento = this.evento.get(i).split("-");
            if(evento[0].equals("attack")){
                if(evento[1].equals("circle")){
                    dadosJogo.setBonusEnemy(0, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("tower")){
                    dadosJogo.setBonusEnemy(1, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("ram")){
                    dadosJogo.setBonusEnemy(2, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("ladder")){
                    dadosJogo.setBonusEnemy(3, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("all")){
                    dadosJogo.setBonusEnemy(0, Integer.parseInt(this.valores.get(i)));
                    dadosJogo.setBonusEnemy(1, Integer.parseInt(this.valores.get(i)));
                    dadosJogo.setBonusEnemy(2, Integer.parseInt(this.valores.get(i)));
                    dadosJogo.setBonusEnemy(3, Integer.parseInt(this.valores.get(i)));
                }
            }else if(evento[0].equals("actions")){
                if(evento[1].equals("archer")){
                    dadosJogo.setBonusEvent(0, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("boiling")){
                    dadosJogo.setBonusEvent(1, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("close")){
                    dadosJogo.setBonusEvent(2, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("coupure")){
                    dadosJogo.setBonusEvent(3, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("rally")){
                    dadosJogo.setBonusEvent(4, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("tunnel")){
                    dadosJogo.setBonusEvent(5, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("raid")){
                    dadosJogo.setBonusEvent(6, Integer.parseInt(this.valores.get(i)));
                }else if(evento[1].equals("sabotage")){
                    dadosJogo.setBonusEvent(7, Integer.parseInt(this.valores.get(i)));
                }
            }else if(evento[0].equals("add")){
                if(evento[1].equals("Trebuchet")){
                    dadosJogo.getEnemyTracks().updateTrincheiras(1);
                }
            }
        }
    }
    
    public abstract void execute(DadosJogo dadosJogo);
    
}
