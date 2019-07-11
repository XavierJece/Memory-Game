 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.DAO;

import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author a1980009
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
   
    EntityManager manager;
    
    public GenericDAOImpl(){
        manager = connectionHibernate.getInstance();
    }

    @Override
    public boolean save(T objeto) {
        try {
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
            return false;
        }
    }

    @Override
    public T listOne(String pkName, int pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + pkName + "=" + pkValue; //Posso colocar "SELECT t FROM TB_" + ..
        
        try {
            Query query = this.manager.createQuery(jpql);
            Object obj = query.getSingleResult();
            
            return (T) obj;
        } catch (Exception e) {
            connectionHibernate.close();
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        
        return null;
    }
    
    @Override
    public T listOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + pkName + " = :value1 AND t." + pkName2 + " = :value2";
        Query query = this.manager.createQuery(jpql);
        query.setParameter("value1", pkValue);
        query.setParameter("value2", pkValue2);

        Object obj = query.getSingleResult();
        return (T) obj;
    }
    
    @Override
    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " AS t WHERE t." + pkName + " = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }
    


    @Override
    public List listAll(Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t";
        Query query = manager.createQuery(jpql); 
        List<T> obj = query.getResultList();
        return obj;
    }

    @Override
    public void update(T objeto) {
        manager.getTransaction().begin();
        manager.merge(objeto);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(T objeto) {
       manager.getTransaction().begin();
       manager.remove(objeto);
       manager.getTransaction().commit();
    }
    
    /**Função para rerificar se o usuario tem cadastro ou não.
     *
     * @param email o Email do usuario
     * @param senha o senha do usuario
     * @return true para existe o login, false para não existe.
     */
    @Override
    public Player verificaLogin( String email, String senha){
        try {
            String jpql =  "SELECT t FROM Player t WHERE t.email = :email AND t.pass = :senha";
            Query query = this.manager.createQuery(jpql);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            
            Player p = ((query.getResultList().size() != 1) ? new Player("ErRoR") : ((Player) query.getResultList().get(0)) ); //     

            return p;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
    @Override
    public List listAll(Class clazz, String order, int limite, String column){
        
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t ORDER BY  t." + column + " " + order;
        Query query = manager.createQuery(jpql); 
        List<T> obj = query.getResultList();
        return obj;
    }
    
}
