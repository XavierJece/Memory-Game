/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Control;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;
import pooii.utfpr.memory_game.Model.VO.modalidades.Modallity;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.factory.SimpleModalityFactory;

/** Classe respontavél por organizar, controlar os dados das partidas.
 *
 * @author Jece Xavier
 * @author Matheus Ferreira
 * @author Lucas Vidotto
 */

@Entity
public class MathGame {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o auto valor do id
    private long codigo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Player> gamers;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Modallity modallity;
    
    private int biggerSequence; 
    private LocalDate timeBegin;
    private LocalDate timeEnd;
    
    //Constructor
    
    public MathGame(){
    }
    
    /**Construtor para instanciar a modalidade da partidade que está sendo iniciada. Recomendado quanto terá apenas um jogador na partida.
    * @author Professor Xavier
    * @author Matheus Ferreira
    * @author Lucas Vidotto
    * @param mode ModalityEnum - O nome (tipo) de modalidade (dificuldade) que será criado.
    * @return Modallity - instancia de uma modalidade expecifica
    */
    public MathGame(ModalityEnum mode) {
       this.modallity = SimpleModalityFactory.createModality(mode);
        
    }
    
    /**Contrutor para instanciar a modalidade da partidade que está sendo iniciada. Recomendado quanto terá mais um jogador na partida.
    * @author Professor Xavier
    * @author Matheus Ferreira
    * @author Lucas Vidotto
    * @param mode ModalityEnum - O nome (tipo) de modalidade (dificuldade) que será criado.
    * @param gamers List<String> - Lista dos nomes (nikName) dos jogadores.
    * @return Modallity - instancia de uma modalidade expecifica
    */
    public MathGame(ModalityEnum mode, List<Player> gamers) {
        
        //Caso a lista estiver com também 0, como fazer para não ser criada?
        
        this.gamers = gamers;
        this.modallity = SimpleModalityFactory.createModality(mode);
        
    }
    
    
    //My Functions
    public void playGame(){
        System.out.println("O jogo está iniciado na Modalidade (Dificuldade)... " + this.modallity.getName());
    }
    
    public int getQuantityGamers(){
        return gamers.size();
    }
    
    public void listGamers(){
        for (int i = 0; i < this.getQuantityGamers(); i++) {
            System.out.println((i + 1) + "º Jogador: " + gamers.get(i));
        }
    }
    
    
    //Gets and Sets

    public long getId() {
        return codigo;
    }

    public void setId(long id) {
        this.codigo = id;
    }

    public List<Player> getGamers() {
        return gamers;
    }

    public void setGamers(List<Player> gamers) {
        this.gamers = gamers;
    }

    public Modallity getModallity() {
        return modallity;
    }

    public void setModallity(Modallity modallity) {
        this.modallity = modallity;
    }

    public LocalDate getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalDate timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalDate getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDate timeEnd) {
        this.timeEnd = timeEnd;
    }
    
    
}
