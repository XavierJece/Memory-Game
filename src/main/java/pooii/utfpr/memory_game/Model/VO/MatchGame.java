package pooii.utfpr.memory_game.Model.VO;

import java.util.List;

public class MatchGame {

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
