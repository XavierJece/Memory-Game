package pooii.utfpr.memory_game.Model.VO;


import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity 

public class MatchGame {
    
    //@Id // tipo deve ser long
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
   //@ElementCollection
    private List<Player> players;

    private Modality mod;

    public void newGame(String modo, int quantidadePlayer) {
    }

    public boolean login() {
        return false;
    }

    public Player createPlayer() {
        return null;
    }

    public boolean login(String nickName, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Player createPlayer(Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
