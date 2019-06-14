package pooii.utfpr.memory_game.Model.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modality {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_modality;
    private String name;
    
    public void newGame(String modo, int quantidadePlayer) {   
    }

    public Modality(String name) {
        this.name = name;
    }

    public long getId_modality() {
        return id_modality;
    }

    public void setId_modality(long id_modality) {
        this.id_modality = id_modality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
