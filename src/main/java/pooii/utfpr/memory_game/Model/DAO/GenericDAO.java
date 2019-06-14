/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.DAO;

import java.util.List;

/**
 *
 * @author a1980009
 */
public interface GenericDAO<T> {
    
    void save(T objeto);
    
    T listOne(String pkName, int pkValue, Class clazz);
    
    List listAll(Class clazz);
    
    void update(T objeto);
    
    void delete(T objeto);
    
}
