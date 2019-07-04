/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.factory;

import pooii.utfpr.memory_game.Model.VO.modalidades.ModalityEnum;
import pooii.utfpr.memory_game.Model.VO.modalidades.*;

/**
 *
 * @author Jece Xavier
 */
public class SimpleModalityFactory {
    
    public static Modallity createModality(ModalityEnum nome)
    {
        Modallity modality = null;
        
        if (nome.getModality().equals("FORFRESHMEN")){
            
            modality = new ForFreshmen();
            
        }
        if (nome.getModality().equals("EASY")){
            
            modality = new Easy();
            
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
