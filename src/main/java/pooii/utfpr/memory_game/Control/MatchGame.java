/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Control;

import java.time.LocalDate;
import java.util.ArrayList;
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
import javax.persistence.Transient;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.Statistics;
import pooii.utfpr.memory_game.Model.VO.factory.SimpleModalityFactory;
import pooii.utfpr.memory_game.View.TelaPartida;

/** Classe respontavél por organizar, controlar os dados das partidas.
 *
 * @author Jece Xavier
 * @author Matheus Ferreira
 * @author Lucas Vidotto
 */

@Entity
public class MatchGame {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o auto valor do id
    private long codigo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Player> gamers;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Difficulty difficulty;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Statistics > statistics;
    
    private boolean mutiplayer;
    
//    @Transient
//    TelaPartida tp;
    
    //Constructor
    
    public MatchGame(){
    }
    
    /**Construtor para instanciar a modalidade da partidade que está sendo iniciada. Recomendado quanto terá apenas um jogador na partida.
    * @author Professor Xavier
    * @author Matheus Ferreira
    * @author Lucas Vidotto
    * @param mode ModalityEnum - O nome (tipo) de modalidade (dificuldade) que será criado.
    * @return Difficulty - instancia de uma modalidade expecifica
    */
    public MatchGame(ModalityEnum mode) {
       this.difficulty = SimpleModalityFactory.createModality(mode);
       
//       this.tp = new TelaPartida(this);
        
    }
    
    /**Contrutor para instanciar a modalidade da partidade que está sendo iniciada. Recomendado quanto terá mais um jogador na partida.
    * @author Professor Xavier
    * @author Matheus Ferreira
    * @author Lucas Vidotto
    * @param mode ModalityEnum - O nome (tipo) de modalidade (dificuldade) que será criado.
    * @param gamers List<String> - Lista dos nomes (nikName) dos jogadores.
    * @return Difficulty - instancia de uma modalidade expecifica
    */
    public MatchGame(ModalityEnum mode, List<Player> gamers) {
        

        this.mutiplayer = ((gamers.size() == 1) ? Boolean.FALSE : Boolean.TRUE);
        
//        if(gamers.size() == 1){
//            this.mutiplayer = Boolean.FALSE;
//        }else{
//            this.mutiplayer = Boolean.TRUE;
//        }
        
        this.statistics = new ArrayList<>();
        for (int i = 0; i < gamers.size(); i++) {
            this.statistics.add(new Statistics(gamers.get(i)));
        }
        
        this.gamers = gamers;
        
        this.difficulty = SimpleModalityFactory.createModality(mode); 
        System.out.println("Chegou aqui");
//        this.tp = new TelaPartida(this.);
        System.out.println("Chegou aqui2");
        
    }
    
    
    //My Functions
    public void playGame(){
        System.out.println("O jogo está iniciado na Modalidade (Dificuldade)... " + this.difficulty.getName());
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

    public Difficulty getModallity() {
        return difficulty;
    }

    public void setModallity(Difficulty modallity) {
        this.difficulty = modallity;
    }

    public List<Statistics> getStatidtics() {
        return statistics;
    }

    public void setStatidtics(List<Statistics> statidtics) {
        this.statistics = statidtics;
    }
    
    
    
    
}
