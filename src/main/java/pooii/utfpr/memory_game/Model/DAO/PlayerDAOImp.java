package pooii.utfpr.memory_game.Model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pooii.utfpr.memory_game.Model.VO.Player;

public class PlayerDAOImp implements PlayerDAO {
    EntityManager manager;
    
    public PlayerDAOImp(){
        manager = connectionHibernate.getInstance();
    }
    
    public void save(Player player) {
        manager.getTransaction().begin(); //Adiciona na tabela
        manager.persist(player);
        manager.getTransaction().commit(); //Se nao tiver o commit, não vai persistir o obj no banco, somente no programa
    }

    @Override
    public void delete(Player player) {
        manager.remove(player); //Remover da table
    }

    @Override
    public List<Player> findAll() {
        Query query = manager.createQuery("SELECT c FROM Player c"); 
        List<Player> players = query.getResultList();
        return players;
    }

    @Override
    public Player findOne(Long id) {
       Player player = manager.find(Player.class, id);
        return player;
    }

    @Override
    public void update(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
