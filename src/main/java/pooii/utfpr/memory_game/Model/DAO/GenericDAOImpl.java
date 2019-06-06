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
import pooii.utfpr.memory_game.Model.DAO.connectionHibernate;

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
    public void salvar(T objeto) {
       manager.getTransaction().begin();
       manager.persist(objeto);
       manager.getTransaction().commit();
    }

    @Override
    public T listUm(String pkName, int pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + "t WHERE t." + pkName + "=" + pkValue; //Posso colocar "SELECT t FROM TB_" + ..
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }

    @Override
    public List listTodos(Class clazz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
