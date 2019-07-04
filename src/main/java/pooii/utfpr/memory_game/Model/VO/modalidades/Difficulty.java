/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.modalidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import pooii.utfpr.memory_game.Control.MatchGame;

/**
 *
 * @author Professor Xavier
 */

//@Entity
    public class Difficulty {
    
    //Atributos
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o auto valor do id  
    private Long codigo;
    
//  @Column(unique = true)
    String name;
    int quantityPiece;
    String description;
    
    //Constructor
    
    //My fuctions
    public void playGame(){
        System.out.println("O jogo está iniciado na Modalidade (Dificuldade)... " + this.name);
    }
    
    //Gets and Sets

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityPiece() {
        return quantityPiece;
    }

    public void setQuantityPiece(int quantityPiece) {
        this.quantityPiece = quantityPiece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    

}
