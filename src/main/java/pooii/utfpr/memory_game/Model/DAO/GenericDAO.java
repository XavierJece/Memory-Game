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
    
    void salvar(T objeto);
    
    T listUm(String pkName, int pkValue, Class clazz);
    
    List listTodos(Class clazz);
    
    void atualizar(T objeto);
    
    void deletar(T objeto);
    
}
