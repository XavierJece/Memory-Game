/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO;

/**
 *
 * @author Jece Xavier
 */
public enum PieceEnum {

    /**
     *
     */
    IMAGEM_COSTAS("Img_0"),
    IMAGEM_01("Img_1"),
    IMAGEM_02("Img_2"),
    IMAGEM_03("Img_3"),
    IMAGEM_04("Img_4"),
    IMAGEM_05("Img_5"),
    IMAGEM_06("Img_6"),
    IMAGEM_07("Img_7"),
    IMAGEM_08("Img_8"),
    IMAGEM_09("Img_9"),
    IMAGEM_10("Img_10"),
    IMAGEM_11("Img_11"),
    IMAGEM_12("Img_12"),
    IMAGEM_13("Img_13"),
    IMAGEM_14("Img_14"),
    IMAGEM_15("Img_15"),
    IMAGEM_16("Img_16"),
    IMAGEM_17("Img_17"),
    IMAGEM_18("Img_18"),
    IMAGEM_19("Img_19"),
    IMAGEM_20("Img_20"),
    IMAGEM_21("Img_21"),
    IMAGEM_22("Img_22"),
    IMAGEM_23("Img_23"),
    IMAGEM_24("Img_24"),
    IMAGEM_25("Img_25"),
    IMAGEM_26("Img_26"),
    IMAGEM_27("Img_27"),
    IMAGEM_28("Img_28"),
    IMAGEM_29("Img_29"),
    IMAGEM_30("Img_30");
    
    private String nameImg;
   
    PieceEnum(String nameImg) {
        this.nameImg = nameImg;
    }
    
    public String getNameImg(){
        return nameImg;
    }
}
