package pooii.utfpr.memory_game.Model.VO;

import javax.persistence.Entity;


public class Easy implements iModality {

    private String name;

    public void play() {
    }

    @Override
    public void newGame(String mode, int quantityPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}