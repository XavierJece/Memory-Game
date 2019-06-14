package pooii.utfpr.memory_game.Model.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.eclipse.persistence.annotations.TimeOfDay;

@Entity
public class Statistics {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;
    
    @ManyToOne @JoinColumn(name = "id_modality")
    private Modality mod;
    
    
    private int time;

    private int biggerSequence;

    private int beginTime;
    
    
    private int endTime;

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

    public Modality getMod() {
        return mod;
    }

    public void setMod(Modality mod) {
        this.mod = mod;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getBiggerSequence() {
        return biggerSequence;
    }

    public void setBiggerSequence(int biggerSequence) {
        this.biggerSequence = biggerSequence;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    void histPlayer(Player player) {
    }
}
