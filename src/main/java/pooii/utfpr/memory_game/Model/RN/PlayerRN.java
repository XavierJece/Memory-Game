/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.RN;

import java.util.List;
import pooii.utfpr.memory_game.Model.DAO.PlayerDAOImp;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.DAO.PlayerDAO;

/**
 *
 * @author a1980009
 */
public class PlayerRN {
    private PlayerDAO playerDAO;
    
    public PlayerRN(){
        playerDAO = new PlayerDAOImp();
    }
    
    public void save(Player player){
        playerDAO.save(player);
    }
    
    public void delete(Player player){
        playerDAO.delete(player);
    }
    
    public List<Player> findAll(){
        return playerDAO.findAll();
    }
    
    public  Player findOne(Long id){
        return playerDAO.findOne(id);
    }
    
    public void update(Player player){
        playerDAO.update(player);
    }
}
