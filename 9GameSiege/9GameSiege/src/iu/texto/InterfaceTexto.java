/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import logicaJogo.estados.AwaitBeginning;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJogo.Jogo;
import logicaJogo.estados.AwaitCardSelect;
import logicaJogo.estados.AwaitEnd;
import logicaJogo.estados.AwaitEndDayPhase;
import logicaJogo.estados.AwaitEnemyMovementPhase;
import logicaJogo.estados.AwaitLineCheck;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitWinLosePhase;
import logicaJogo.estados.IEstado;

/**
 *
 * @author jhssi
 */
public class InterfaceTexto {
    
    Scanner scanner;
    private Jogo jogo;
    
    public InterfaceTexto(){
        //inicia novo jogo
        
        scanner = new Scanner(System.in);
    }

    public InterfaceTexto(Jogo j) {
        this();
        this.jogo = j;
    }

    public void runJogo() {
        int i = 1;
        
        if(jogo == null){
            this.jogo = new Jogo();
        }
         
        //Estados
       
        while(i == 1){
           if(jogo.getEstado() instanceof AwaitBeginning)
              mostrarMenuInicial();
           if(jogo.getEstado() instanceof AwaitLineCheck){
              lineCheck();
           }
           if(jogo.getEstado() instanceof AwaitCardSelect){
               cardSelect();
           }
           if(jogo.getEstado() instanceof AwaitEnemyMovementPhase){
               
           }
           if(jogo.getEstado() instanceof AwaitPlayerAction){
               
           }
           if(jogo.getEstado() instanceof AwaitWinLosePhase){
               winLose();
           }
           
           if(jogo.getEstado() instanceof AwaitEndDayPhase){
               
           } 
           if(jogo.getEstado() instanceof AwaitEnd){
               mostrarMenuFinal();
           }
            
        }
    }

    private void mostrarMenuInicial() {
            jogo = null;
       
            while(jogo == null){
            
            System.out.println("Deseja [c]arregar um jogo ou iniciar um [n]ovo?");
        
            switch(leCaracter()){
                case 'c':
                case 'C':
                    mostrarMenuCarregar();
                    break;
                case 'n':
                case 'N':
                    jogo = new Jogo();
                    jogo.CheckStart();
                    break;
                default:
                    
            }
        }
        
        
    }
    
    private void mostrarMenuFinal() {
        System.out.println(jogo.getTextoDadosJogo());
        System.out.println("Fim do JOGO!\n");
        tecla();
    }

    char leCaracter() {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            System.in.read(new byte[System.in.available()]);

            //Le
            char c = (char)System.in.read();
            
            //limpa
            System.in.read(new byte[System.in.available()]);
            
            return c;
        } catch (IOException ex) {
            Logger.getLogger(InterfaceTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
       
    }

    private void mostrarMenuCarregar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void tecla()
    {
        System.out.print(" -> Prima qualquer tecla para avançar para a proxima carta");
        
         try
            {
                System.in.read();
            }  
            catch(IOException e)
            {} 
    }
     
     public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  

    private void lineCheck(){
        System.out.println("Line Check Phase!\n");
        
        int i = jogo.lineCheck();
        
        if(i == 0){
            System.out.println("Nao Existem Inimigos nas EnemyLines!\n");
        }else{
            System.out.println("Existem Inimigos nas EnemyLines!\n");
            
            System.out.println("Resultado do lancamento do dado: " + i);
            
            if(i == 1){
                System.out.println("Inimigos Capturados!\n");
            }else{
                System.out.println("Soldados nao foram detetados!");
            }
            
        }
       
        tecla();
        clearScreen();
        jogo.setEstado(jogo.getEstado().ResolveLine());
    }

    private void cardSelect() {
        jogo.setEstado(jogo.getEstado().cardChoose());
        System.out.println("Carta Selecionada!");
        imprimirInformacaoCarta();
        
    }

    private void winLose() {
        System.out.println("Win or Lose Check!");
        jogo.setEstado(jogo.getEstado().winLosePhase());
    }

    private void imprimirInformacaoCarta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
