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
    public void save(T objeto) {
       manager.getTransaction().begin();
       manager.persist(objeto);
       manager.getTransaction().commit();
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
    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " AS t WHERE t." + pkName + " = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }
    
    /*@Override
    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE " + pkName + "=" + pkValue; //Posso colocar "SELECT t FROM TB_" + ..
        
        try {
            Query query = this.manager.createQuery(jpql);
            Object obj = query.getSingleResult();
            
            return (T) obj;
        } catch (Exception e) {
            connectionHibernate.close();
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        
        return null;
    }*/

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
     * @param nome o nikcName do usuario
     * @param senha o nikcName do usuario
     * @return true para existe o login, false para não existe.
     */
    @Override
    public boolean verificaLogin( String nome, String senha){
        try {
             Player p = (Player) this.listOne("nickName", nome, Player.class);
            
            
            if(!p.getPass().equals(senha)){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            connectionHibernate.close();
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
            return false;
        }
        
        
    } 
}
