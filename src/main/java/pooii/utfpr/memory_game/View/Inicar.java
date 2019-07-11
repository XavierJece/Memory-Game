/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author Jece Xavier
 */
public class Inicar {
    
    
    public static void main(String[] args) {
        
        GenericDAO<Player> playerDAO = new GenericDAOImpl<>();
//        
        Player gamers = (Player) playerDAO.listAll(Player.class).get(0);
        
        TelaDificuldadeSinglePlayer td = new TelaDificuldadeSinglePlayer(gamers);
        td.setVisible(true);
        
    }
}
