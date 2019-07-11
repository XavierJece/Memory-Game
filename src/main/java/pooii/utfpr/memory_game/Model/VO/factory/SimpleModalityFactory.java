/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.factory;

import com.sun.prism.impl.BufferUtil;
import java.util.ArrayList;
import java.util.List;
import pooii.utfpr.memory_game.Model.RN.EstadoBotoes;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;
import pooii.utfpr.memory_game.Model.VO.modalidades.*;

/**
 *
 * @author Jece Xavier
 */
public class SimpleModalityFactory {
    
    public static Difficulty createModality(ModalityEnum nome){
        
        Difficulty modality = null;
        GenericDAO<Difficulty> modalityDAO = new GenericDAOImpl<>();
        
        if (nome.getModality().equals("FORFRESHMEN")){
            
            modality = modalityDAO.listOne("codigo", 1, Difficulty.class);
            
        }else if(nome.getModality().equals("EASY")){
            
            modality = modalityDAO.listOne("codigo", 2, Difficulty.class);
            
        }else if(nome.getModality().equals("MIDDLE")){
            
            modality = modalityDAO.listOne("codigo", 3, Difficulty.class);
            
        }else if(nome.getModality().equals("HARD")){
            
            modality = modalityDAO.listOne("codigo", 4, Difficulty.class);
            
        }else if(nome.getModality().equals("SUPERWAGNER")){
            
            modality = modalityDAO.listOne("codigo", 5, Difficulty.class);
            
        }
        
        
        return modality;
    }
    
}
