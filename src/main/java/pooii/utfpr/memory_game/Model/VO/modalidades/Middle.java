/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.modalidades;

/**
 *
 * @author Jece Xavier
 */
public class Middle extends Modallity{
    
    //Atributos
    private int time;
    
    //Constructor
    public Middle() {
        this.name = "Middle";
        this.quantityPiece = 10;
        this.description = "Fase...";
        this.time = 30;
    }
    
    //Gets and Sets
    public int getTime() {
        return time;
    }

    protected void setTime(int time) {
        this.time = time;
    }
}
