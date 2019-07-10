/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import java.util.List;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.Statistics;
import pooii.utfpr.memory_game.Model.VO.factory.SimpleModalityFactory;
import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;

/**
 *
 * @author Jece Xavier
 */
public class Inicar {
    
    
    public static void main(String[] args) {
        
        GenericDAO<Player> playerDAO = new GenericDAOImpl<>();
        Player p = new Player("Ana Paula");
        playerDAO.save(p);
        
        List<Player> gamers = playerDAO.listAll(Player.class);
        gamers.remove(3);
        gamers.remove(1);
        
        Statistics sta = new Statistics();
        
        Difficulty dif = SimpleModalityFactory.createModality(ModalityEnum.HARD);
        
        TelaPartida tp = new TelaPartida(dif, gamers);
        
    }
}
