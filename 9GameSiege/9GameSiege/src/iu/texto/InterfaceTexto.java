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
               enemyMovementPhase();
           }
           if(jogo.getEstado() instanceof AwaitPlayerAction){
               playerMovementPhase();
           }
           if(jogo.getEstado() instanceof AwaitWinLosePhase){
               winLose();
           }
           
           if(jogo.getEstado() instanceof AwaitEndDayPhase){
               endDayPhase();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jogo.setEstado(jogo.getEstado().eventPhase());
    }

    private void winLose() {
        System.out.println("Win or Lose Check!");
        jogo.setEstado(jogo.getEstado().winLosePhase());
    }

    private void imprimirInformacaoCarta() {
        System.out.println("\nInformacao da Carta!");
        System.out.println("\nEvento: " +jogo.getDadosJogo().getEventoAtual( ).getNome() + "\n\nAcontecimentos do evento:\n" + jogo.getDadosJogo().getEventoAtual().getInfo() + "\n\nAction Points: " + jogo.getDadosJogo().getEventoAtual().getActionP());
        tecla();
    }

    private void enemyMovementPhase() {
        System.out.println("Enemy Movement Phase!\n");
        jogo.setEstado(jogo.getEstado().enemyMovementPhase());
        //Imprimir cartas e evento
        jogo.setEstado(jogo.getEstado().avancaPhase());
        
    }

    private void playerMovementPhase() {
        System.out.println("Teu turno! Jogadas disponiveis: " + jogo.getDadosJogo().getJogadasDisp());
        
        int opcao = mostrarMenuJogo();
        
        
        switch(opcao){
            case 0:
                jogo.setEstado(jogo.getEstado().playerAction(opcao,0));
            case 1: // Archers Attack
                System.out.println("**** Archers Attack ****");
                
                int target = menuArchersAttack();
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao,target));
                
               
               System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
               System.out.println("" + jogo.getDadosJogo().getTexto());
            case 2: // Boiling Water Attack
                
                if(jogo.getDadosJogo().getOpcoesUtilizadas(1) == 0){
                    System.out.println("Movimento ja utilizado!");
                    break;
                }
                
                System.out.println("**** Boiling Water Attack ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                jogo.getDadosJogo().setOpcoesUtilizadasIndice(1);
                break;
            case 3: // Close Combat Attack
                System.out.println("**** Close Combat Attack ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            case 4: // Coupure
                System.out.println("**** Coupure ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            case 5: // Rally Trops
                System.out.println("**** Rally Trops ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            case 6: // Tunnel Movement
                System.out.println("**** Tunnel Movement ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            case 7: // Supply Raid
                System.out.println("**** Supply Raid ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            case 8: // Sabotage
                System.out.println("**** Sabotage ****");
                
                jogo.setEstado(jogo.getEstado().playerAction(opcao, 0));
                
                System.out.println("Dado Rolado: " + jogo.getDadosJogo().getDice());
                System.out.println("" + jogo.getDadosJogo().getTexto());
                break;
            default:
                System.out.println("Opcao Invalida! Selecione outra opcao!");
        }
        
        jogo.setEstado(jogo.getEstado().checkJogadasDisp());
        tecla();
    }

    private int mostrarMenuJogo() {
        //Imprimir menu de jogo
        int opcao = 0;
        
        System.out.println("******Menu******");
        System.out.println("1 - Archers Attack");
        System.out.println("2 - Boiling Water Attack");
        System.out.println("3 - Close Combat Attack");
        System.out.println("4 - Coupure");
        System.out.println("5 - Rally Trops");
        System.out.println("6 - Tunnel Movement");
        System.out.println("7 - Supply Raid");
        System.out.println("8 - Sabotage");
        
        System.out.print("Opcao: ");
        
        opcao = scanner.nextInt();
        
        return opcao;
    }

    private int menuArchersAttack() {
        int opcao;
        
        do{
           System.out.println("Escolha o alvo!"); 
           System.out.println("1 - Ladders");
           System.out.println("2 - Battering Ram");
           System.out.println("3 - Siege Tower");
           
           System.out.print("Opcao: ");
           opcao = scanner.nextInt();
        }while(opcao <= 0 || opcao >= 4);

        return opcao;
    }

    private void endDayPhase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

}
