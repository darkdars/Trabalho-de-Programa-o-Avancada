/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

/**
 *
 * @author jhssi
 */
public interface IEstado {
    IEstado lancaDados();
    IEstado escolheAcao();
    IEstado configurar();
    IEstado saltarEstado();
    IEstado avancar();
    IEstado processarEventos();
    IEstado darCarta();
    
}
