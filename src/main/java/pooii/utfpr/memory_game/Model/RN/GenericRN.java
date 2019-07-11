/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Model.RN;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import pooii.utfpr.memory_game.Model.DAO.GenericDAO;
import pooii.utfpr.memory_game.Model.DAO.GenericDAOImpl;
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
    
    public boolean save(T objeto){
        return genericDAO.save(objeto);
    }
    
    public void delete(T objeto){
        genericDAO.delete(objeto);
    }
    
    public List<T> listAll(Class clazz){
        return genericDAO.listAll(clazz);
    }
    
    public List listAll(Class clazz, String order, int limite, String column){
        return genericDAO.listAll(clazz, order, limite, column);
    }
    
    public  T findOne(String pkName, String pkValue, Class clazz){
        return (T) genericDAO.listOne(pkName, pkValue, clazz);
    }
    
    public  T findOne(String pkName, String pkValue, Class clazz, String pkName2, String pkValue2){
        return (T) genericDAO.listOne(pkName, pkValue, clazz, pkName2, pkValue2);
    }
    
    public void update(T objeto){
        genericDAO.update(objeto);
    }
    
    public Player verificaLogin( String email, String senha){
        if( (validarEmail(email)) || (validarSenha(senha))){
            return genericDAO.verificaLogin(email, cripitografarSenha(senha, email));
        }
        
        return null;
        
    }
    
    private static boolean validarEmail(String email){
        if ((email == null) || (email.trim().length() == 0))
            return false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
        
    }
    
    private static boolean validarSenha(String senha){
        if((senha == null) || (senha.equals("")) || (senha.length() < 6)){
            return false;
        }else{
            return true;   
        }
    }
    
    public static String cripitografarSenha(String senha, String email){
       
        senha += email + senha;
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "ERROR :" + ex);
        }
        
        md.update(senha.getBytes());        
        byte digest[] = md.digest();
        StringBuffer sb = new StringBuffer();
        
        for(byte b: digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
                
        senha = sb.toString();
        return senha;
    }
    
    public boolean cadastro(Player p){
        if( (validarEmail(p.getEmail())) && (validarSenha(p.getPass())) && (p.getNickName().length() > 0) ){
            
            p.setPass(cripitografarSenha(p.getPass(), p.getEmail()));
            p.setDateRegister(LocalDate.now());
            return genericDAO.save(p);
        
        }else{
            return false;
        }
    }
    
}
