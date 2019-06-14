/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import com.sun.org.glassfish.external.statistics.Statistic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;
import pooii.utfpr.memory_game.Model.RN.PlayerRN;
import pooii.utfpr.memory_game.Model.VO.MatchGame;
import pooii.utfpr.memory_game.Model.VO.Modality;
import pooii.utfpr.memory_game.Model.VO.Player;
import pooii.utfpr.memory_game.Model.VO.Statistics;

public class Main_test {
     public static void main(String[] args) {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("POOII.utfpr_Memory-Game_jar_1.0-SNAPSHOTPU");  isso esta sendo feito agora la no DAO ConexaoHibernate
        //EntityManager manager = factory.createEntityManager();
       
       // EntityManager manager = connectionHibernate.getInstance(); // Agora podemos varios dois manager no mesmo local da memoria
        //EntityManager manager2 = connectionHibernate.getInstance();
        
        PlayerRN playerRN= new PlayerRN();
        
        //MatchGame match = new MatchGame();
        Modality modality = new Modality("Wagnao");
        modality.setId_modality(2);
        Player player = new Player("Giuvane");
        Statistics sta = new Statistics();
       
        
        GenericDAO<Statistics> genericDAO2 = new GenericDAOImpl<Statistics>();
        GenericDAO<Player> genericDAO = new GenericDAOImpl<Player>();
        
        sta.setPlayer(player);
        sta.setBiggerSequence(10);
        sta.setMod(modality);
        sta.setBeginTime(0);
        sta.setEndTime(10);
        sta.setTime(10);
        
        genericDAO2.save(sta);
       //genericDAO.save(player);
        
        //playerRN.save(player);
        
        
        //match.createPlayer(player);
        
        
        // Esta dentro da classe PlayerDAOImp
       // manager.getTransaction().begin(); //Adiciona na tabela
//        manager.persist(player);
        //manager.persist(modality);
        //manager.getTransaction().commit(); //Se nao tiver o commit, não vai persistir o obj no banco, somente no programa
        
       player = playerRN.findOne(3L);
       System.out.println(player.getNickName());
        //Player jogadorRecupera = manager.find(Player.class, 1); //Acho  
        //Player jogadorRecupera2 = manager.getReference(Player.class, 1); // 1 = pk
        
        //playerRN.delete(player);
        //manager.remove(recoveryPlayer); //Remover da table
        
        //Query query = manager.createQuery("SELECT c FROM Player c"); 
        //List<Player> jogadores = query.getResultList();
        
        connectionHibernate.close();
       // manager.close();
       // factory.close();
     }
}
