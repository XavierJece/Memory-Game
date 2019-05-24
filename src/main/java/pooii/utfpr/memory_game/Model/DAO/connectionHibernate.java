package pooii.utfpr.memory_game.Model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class connectionHibernate {
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    private connectionHibernate(){ }
    
    public static EntityManager getInstance(){
        if (manager == null){
            synchronized (connectionHibernate.class){
                if (manager == null){
                factory = Persistence.createEntityManagerFactory("POOII.utfpr_Memory-Game_jar_1.0-SNAPSHOTPU");
                manager = factory.createEntityManager();
                }
            }
        }
        return manager;
    }
    
    public static void close(){
        manager.close();
        factory.close();
    }
}
