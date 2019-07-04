/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.factory;

import com.sun.prism.impl.BufferUtil;
import java.util.ArrayList;
import java.util.List;
import pooii.utfpr.memory_game.Control.Regras.EstadoBotoes;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.modalidades.DifficultyEnum;
import pooii.utfpr.memory_game.Model.VO.modalidades.*;

/**
 *
 * @author Jece Xavier
 */
public class SimpleModalityFactory {
    
    public static Difficulty createModality(DifficultyEnum nome)
    {
        int flag = 1;
        Difficulty modality = null;
        /*GenericDAO<Modallity> modaDAO = new GenericDAOImpl<>();
        List<Modallity> listaModal = null;
        System.out.println("tamanho lista " + (modaDAO.listAll(Difficulty.class).size()));*/
        
        if (nome.getModality().equals("FORFRESHMEN")){
            
            modality = new ForFreshmen();
            
        }
        if (nome.getModality().equals("EASY")){
           /*for(int i = 0; i < listaModal.size(); i++){
                if(listaModal.get(i).getName().equals("Easy")){
                    flag = 0;
                }
            }*/
           if(flag == 1){
             modality = new Easy();
           }
            
        }
        if(nome.getModality().equals("MIDDLE")){
            
            modality = new Middle();
            
        }
        if(nome.getModality().equals("HARD")){
            
            modality = new Hard();
            
        }
        
        if(nome.getModality().equals("SUPERWAGNER"))
        {
            modality = new SuperWagner();
        }
        
        return modality;
    }
    
}
