/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logicaJogo.Cartas.Card;
import logicaJogo.Cartas.Eventos.BadWeather;
import logicaJogo.Cartas.Eventos.BoilingOil;
import logicaJogo.Cartas.Eventos.Collapsed;
import logicaJogo.Cartas.Eventos.CoverDarkness;
import logicaJogo.Cartas.Eventos.DeathLeader;
import logicaJogo.Cartas.Eventos.DeterminedEnemy;
import logicaJogo.Cartas.Eventos.EnemyFatigue;
import logicaJogo.Cartas.Eventos.Evento;
import logicaJogo.Cartas.Eventos.Faith;
import logicaJogo.Cartas.Eventos.FlamingArrows;
import logicaJogo.Cartas.Eventos.GateFortified;
import logicaJogo.Cartas.Eventos.GuardsDistracted;
import logicaJogo.Cartas.Eventos.Illness;
import logicaJogo.Cartas.Eventos.IronShields;
import logicaJogo.Cartas.Eventos.Rally;
import logicaJogo.Cartas.Eventos.RepairedTrebuchet;
import logicaJogo.Cartas.Eventos.SuppliesSpoiled;
import logicaJogo.Cartas.Eventos.TrebuchetAttack;
import logicaJogo.Cartas.Eventos.VolleyArrows;

/**
 *
 * @author jhssi
 */
public class DadosJogo {
    
    private int dia;
    private int dice;
    private EnemyTracks enemyTracks;
    private StatusCard statusCard;
    private List<Card> cartas;
    private Card cartaSelecionada;
    
    private Evento eventoAtual;
    private int listaCards; // Vai de 0 a 6 // 7 cartas
    private String texto;
    

    public DadosJogo(){
        dia = 1;
        enemyTracks = new EnemyTracks();
        statusCard = new StatusCard();
        texto="";
        listaCards = 0;
        
        cartas = new ArrayList<>();
        cartas.add(new Card(1, new TrebuchetAttack(3), new TrebuchetAttack(2), new TrebuchetAttack(1)));
        cartas.add(new Card(2, new Illness(), new GuardsDistracted(), new TrebuchetAttack(1)));
        cartas.add(new Card(3, new SuppliesSpoiled(), new BadWeather(), new BoilingOil()));
        cartas.add(new Card(4, new DeathLeader(), new GateFortified(), new FlamingArrows()));
        cartas.add(new Card(5, new VolleyArrows(), new Collapsed(), new RepairedTrebuchet()));
        cartas.add(new Card(6, new CoverDarkness(), new EnemyFatigue(), new Rally()));
        cartas.add(new Card(7, new DeterminedEnemy(), new IronShields(), new Faith()));
    }
    
    public void baralhaCartas(){
        Collections.shuffle(cartas);
      //  System.out.println(cartas.get(0).getEventos(0).getNome());
    }
    
    /**Funcao para fazer EnemyLineCheck
     * @return */
    public int enemyLineCheck(){
        if(statusCard.getTunel() == 2 || statusCard.getTunel() == 3){
            return 1;
        }
        
        return 0;
    }
    
    //Lancar dados
    public void rollDice(){
        setDice((int)(6 * Math.random()) + 1);
    }
    
    //Set EnemyLineSpace
    public void setEnemyLineSpace(int line){
        statusCard.setTunel(line);
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getSupliesS() {
        return statusCard.getMantimentosRoubados();
    }

    public void setSuplies(int i) {
        statusCard.setMantimentosRoubados(i);
    }

    public void reduceMoral(int i) {
        statusCard.setMoral(statusCard.getMoral() - 1);
    }

    public int checkEnemyCloseCombat() { // Checka numero de inimigos em closecombat
        int x = 0;
        
        if(enemyTracks.getEscada() == 0)
            x++;
       
        if(enemyTracks.getTorre() == 0)
            x++;
                    
        if(enemyTracks.getTrincheiras() == 0)
            x++;
        
        return x;
    }

    public int check0SpaceStatusTrack() {
        int x = 0;
        
        if(statusCard.getMoral() == 0)
            x++;
        
         if(statusCard.getMantimentos() == 0)
             x++;
         
         if(statusCard.getMuralha() == 0)
            x++;
         
        
        return x;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Card getCartaSelecionada() {
        return cartaSelecionada;
    }

    public void setCartaSelecionada(Card cartaSelecionada) {
        this.cartaSelecionada = cartaSelecionada;
    }

    public int getListaCards() {
        return listaCards;
    }

    public void setListaCards(int listaCards) {
        this.listaCards = listaCards;
    }

    public List<Card> getCartas() {
        return cartas;
    }

    public void setCartas(List<Card> cartas) {
        this.cartas = cartas;
    }
    
    public Card getCard(int n){
        return this.cartas.get(n);
    }

    public Evento getEventoAtual() {
        return eventoAtual;
    }

    public void setEventoAtual(Evento eventoAtual) {
        this.eventoAtual = eventoAtual;
    }
    
     public void updateEventoAtual() {
        this.eventoAtual = cartaSelecionada.getEventos(dia);
     }
    
    
}
