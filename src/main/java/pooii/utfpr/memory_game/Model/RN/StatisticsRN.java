/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.RN;

import java.util.List;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.Statistics;

/**
 *
 * @author a1980009
 */
public class StatisticsRN {
     private GenericDAO statisticsDAO;
    
    public StatisticsRN(){
        statisticsDAO = new GenericDAOImpl();
    }
    
    public void save(Statistics statistics){
        statisticsDAO.save(statistics);
    }
    
    public void delete(Statistics statistics){
        statisticsDAO.delete(statistics);
    }
    
    public List<Statistics> findAll(){
        return statisticsDAO.listAll(statisticsDAO.getClass());
    }
    
    public  Statistics findOne(String id, int cod, Class clazz){
        return (Statistics)statisticsDAO.listOne(id, cod, clazz);
    }
    
    public void update(Statistics statistics){
        statisticsDAO.update(statistics);
    }
}
