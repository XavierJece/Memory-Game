/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.VO;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jece Xavier
 */
public class Piece {
    
    /* Atributos*/
    

    
    /*Minhas Funções */
    public ImageIcon createImg(String nameImage, int dimesaoBtn){
        
        String pathRaiz = "C:\\Users\\Jece Xavier\\Documents\\NetBeansProjects\\Memory-Game\\src\\main\\resources\\img\\";
        int widthButton = dimesaoBtn + 10;
        int heightButton = dimesaoBtn;
        
        
        ImageIcon img = new ImageIcon(getClass().getResource("/img/" + nameImage + ".jpg")); 
        Image image = img.getImage().getScaledInstance(widthButton, heightButton, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        
        return imageIcon;
    }
    
    public ImageIcon createImg(PieceEnum nameImage, int dimesaoBtn){
        
        //String pathRaiz = "C:\\Users\\Jece Xavier\\Documents\\NetBeansProjects\\Memory-Game\\src\\main\\resources\\img\\";
        int widthButton = dimesaoBtn + 10;
        int heightButton = dimesaoBtn;
        
        ImageIcon img = new ImageIcon(getClass().getResource("/img/" + nameImage.getNameImg() + ".jpg")); 
        Image image = img.getImage().getScaledInstance(widthButton, heightButton, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        
        return imageIcon;
    }
    
}
