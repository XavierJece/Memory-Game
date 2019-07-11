///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pooii.utfpr.memory_game.View;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;
//import pooii.utfpr.memory_game.Control.MatchGame;
//import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
//import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
//import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;
//import pooii.utfpr.memory_game.Model.VO.Player;
//import pooii.utfpr.memory_game.Model.VO.Statistics;
//import pooii.utfpr.memory_game.Model.VO.modalidades.Difficulty;
//
//public class Main_test {
//     public static void main(String[] args) {
//        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("POOII.utfpr_Memory-Game_jar_1.0-SNAPSHOTPU");  isso esta sendo feito agora la no DAO ConexaoHibernate
//        //EntityManager manager = factory.createEntityManager();
//       
//       // EntityManager manager = connectionHibernate.getInstance(); // Agora podemos varios dois manager no mesmo local da memoria
//        //EntityManager manager2 = connectionHibernate.getInstance();
//        
//        //PlayerRN playerRN= new PlayerRN();
//        
////        MatchGame match = new MatchGame();
//        Player player1 = new Player("Giuvane");
////        Player player2 = new Player("Goku");
////        Player player3 = new Player("Vidotto");
////        Player player4 = new Player("goku");
////        player4.setEmail("goku@hotail.com");
////        player4.setDateRegister(LocalDate.now());
////                
//        List<Player> players = new ArrayList<Player>();
//        players.add(player1);
////        players.add(player2);
////        players.add(player3);
//         
////         GenericDAO<Player> genericDAOPlayer = new GenericDAOImpl<Player>();
//         
////        List<Player> players2 = genericDAOPlayer.listAll(Player.class);
////        players2.remove(2);
////        players2.remove(1);
////        players2.add(player4);
////        players2.add(player1);
////        
////        MatchGame mg1 = new MatchGame(ModalityEnum.MIDDLE, players2);
////        mg1.getStatidtics().get(0).setBiggerSequence(10);
////        mg1.getStatidtics().get(0).setPontuacao(520);
////        mg1.getStatidtics().get(0).setQuantidadeJogadas(102);
////        mg1.getStatidtics().get(1).setBiggerSequence(52);
////        mg1.getStatidtics().get(1).setPontuacao(426);
////        mg1.getStatidtics().get(1).setQuantidadeJogadas(742);
//
//        
////        
////        MatchGame mg2 = new MatchGame(ModalityEnum.FORFRESHMEN, players);
////        
////        players.add(player4);
////        
//        MatchGame mg3 = new MatchGame(ModalityEnum.EASY, players);
//        
//        
//        //Statistics sta = new Statistics();
//
//        
//        
//        GenericDAO<MatchGame> genericDAOMathGame = new GenericDAOImpl<MatchGame>();
//     
//        
////        genericDAOPlayer.save(player1);
////        genericDAOPlayer.save(player2);
////        genericDAOPlayer.save(player3);
////        genericDAOPlayer.save(player4);
//        
////        genericDAOMathGame.save(mg1);
//        //genericDAOMathGame.delete(mg1);
////        genericDAOMathGame.save(mg2);
//        //playerRN.save(player);
//        genericDAOMathGame.save(mg3);
//        
//        
//        
////        System.out.println("Modalidade: " + mg2.getModallity().getName() );
//
//        
//        // Esta dentro da classe PlayerDAOImp
//       // manager.getTransaction().begin(); //Adiciona na tabela
////        manager.persist(player);
//        //manager.persist(modality);
//        //manager.getTransaction().commit(); //Se nao tiver o commit, não vai persistir o obj no banco, somente no programa
//        
//       //player = playerRN.findOne(3L);
//       //System.out.println(player.getNickName());
//        //Player jogadorRecupera = manager.find(Player.class, 1); //Acho  
//        //Player jogadorRecupera2 = manager.getReference(Player.class, 1); // 1 = pk
//        
//        //playerRN.delete(player);
//        //manager.remove(recoveryPlayer); //Remover da table
//        
//        //Query query = manager.createQuery("SELECT c FROM Player c"); 
//        //List<Player> jogadores = query.getResultList();
//        
////        connectionHibernate.close();
//       // manager.close();
//       // factory.close();
//        
//     }
//}
