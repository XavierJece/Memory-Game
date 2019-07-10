package pooii.utfpr.memory_game.Model.VO;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.stage.Modality;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import pooii.utfpr.memory_game.Control.MatchGame;

@Entity
public class Statistics {
    
    
    /*Atributos*/
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Player player;
    
    private int biggerSequence;
    
    private int pontuacao;
    
    private int quantidadeJogadas;

    private LocalDate beginTime;
    private LocalDate endTime;

    
    /*Contrutor*/
    public Statistics() {
    }

    public Statistics(Player player) {
        this.player = player;
    }
    
    



    /*My Functions*/
    public Duration getTime() {
        
        return Duration.between(this.beginTime, this.endTime);
    }
    
    /*Gets and Sets*/
    public int getBiggerSequence() {
        return biggerSequence;
    }

    public void setBiggerSequence(int biggerSequence) {
        this.biggerSequence = biggerSequence;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQuantidadeJogadas() {
        return quantidadeJogadas;
    }

    public void setQuantidadeJogadas(int quantidadeJogadas) {
        this.quantidadeJogadas = quantidadeJogadas;
    }
    
    

}
