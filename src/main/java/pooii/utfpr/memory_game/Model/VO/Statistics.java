package pooii.utfpr.memory_game.Model.VO;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.stage.Modality;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
public class Statistics {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;
    
    @ManyToOne @JoinColumn(name = "id_modality")
//    @Transient
    private Difficulty mod;

    private int biggerSequence;

    private LocalDate beginTime;
    
    
    private LocalDate endTime;

    public Statistics() {
    }

    void rankTen() {
    }

    void histPlayer() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Duration getTime() {
        
        return Duration.between(this.beginTime, this.endTime);
    }

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

    void histPlayer(Player player) {
    }
}
