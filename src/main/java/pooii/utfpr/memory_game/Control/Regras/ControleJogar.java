/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Control.Regras;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Jece Xavier
 */
public class ControleJogar {
    
    /*Atributos*/
    private Map<JLabel, JLabel> referenciaPlayer;
    
    /*Contrutor*/
    
    /*Funcoes*/

    public ControleJogar() {
        this.referenciaPlayer = new HashMap<>();
    }
    
    
    /*Gets AND Sets*/

    public Map<JLabel, JLabel> getReferenciaPlayer() {
        return referenciaPlayer;
    }

    public void setReferenciaPlayer(Map<JLabel, JLabel> referenciaPlayer) {
        this.referenciaPlayer = referenciaPlayer;
    }
    
    
}
