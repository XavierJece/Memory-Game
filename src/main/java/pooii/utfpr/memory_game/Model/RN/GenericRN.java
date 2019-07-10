/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.RN;

import java.util.List;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.DAO.PlayerDAO;
import pooii.utfpr.memory_game.Model.DAO.PlayerDAOImp;
import pooii.utfpr.memory_game.Model.VO.Player;

/**
 *
 * @author Matheus_CRF
 */
public class GenericRN<T> {
    private GenericDAO genericDAO;
    
    public GenericRN(){
        genericDAO = new GenericDAOImpl();
    }
    
    public void save(T objeto){
        genericDAO.save(objeto);
    }
    
    public void delete(T objeto){
        genericDAO.delete(objeto);
    }
    
    public List<T> listAll(Class clazz){
        return genericDAO.listAll(clazz);
    }
    
    public  T findOne(String pkName, String pkValue, Class clazz){
        return (T) genericDAO.listOne(pkName, pkValue, clazz);
    }
    
    public void update(T objeto){
        genericDAO.update(objeto);
    }
    
    public boolean verificaLogin( String nome, String senha){
        return genericDAO.verificaLogin(nome, senha);
    }
    
}
