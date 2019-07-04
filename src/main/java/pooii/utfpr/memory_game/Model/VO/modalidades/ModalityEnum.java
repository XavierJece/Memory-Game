/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO.modalidades;

/**
 *
 * @author Jece Xavier
 */
public enum ModalityEnum {
    FORFRESHMEN("FORFRESHMEN"),
    EASY("EASY"),
    MIDDLE("MIDDLE"),
    HARD("HARD"),
    SUPERWAGNER("SUPERWAGNER");
    
    private String modality;
   
    ModalityEnum(String modality) {
        this.modality = modality;
    }
    
    public String getModality(){
        return modality;
    }
}
