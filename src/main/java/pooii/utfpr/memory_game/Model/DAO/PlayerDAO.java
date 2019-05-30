/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.DAO;

import java.util.List;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author a1980009
 */
public interface PlayerDAO {
    public void save(Player player);
    
    public void delete(Player player);
    
    public List<Player> findAll();
    
    public  Player findOne(Long id);
    
    public void update(Player player);
    
}
