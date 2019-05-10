/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.View;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pooii.utfpr.memory_game.Model.VO.MatchGame;
import pooii.utfpr.memory_game.Model.VO.Modality;
import pooii.utfpr.memory_game.Model.VO.Player;

public class Main_test {
     public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("POOII.utfpr_Memory-Game_jar_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        
        //MatchGame match = new MatchGame();
        Modality modality = new Modality("Wagnao");
        Player player = new Player("jece");
        
        //match.createPlayer(player);
        
        manager.getTransaction().begin(); //Adiciona na tabela
        manager.persist(player);
        manager.persist(modality);
        manager.getTransaction().commit(); //Se nao tiver o commit, não vai persistir o obj no banco, somente no programa
        
        //Player jogadorRecupera = manager.find(Player.class, 1); //Acho  
        //Player jogadorRecupera2 = manager.getReference(Player.class, 1); // 1 = pk
        
        //manager.remove(recoveryPlayer); //Remover da table
        
        //Query query = manager.createQuery("SELECT c FROM Player c"); 
        //List<Player> jogadores = query.getResultList();
        
        manager.close();
        factory.close();
     }
}
