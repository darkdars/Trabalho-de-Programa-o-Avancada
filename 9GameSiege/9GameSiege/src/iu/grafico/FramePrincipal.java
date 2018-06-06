/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author jhssi
 */
class FramePrincipal extends JFrame {
    
    public FramePrincipal(){
        super();
        
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }
    
}
