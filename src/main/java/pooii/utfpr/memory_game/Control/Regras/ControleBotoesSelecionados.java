/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Control.Regras;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import pooii.utfpr.memory_game.Model.VO.PieceEnum;

/**
 *
 * @author Jece Xavier
 */
public class ControleBotoesSelecionados {
    
    
   private String imgFrenteBotao;
   private Map<JButton, Boolean> referenciaBotoes;

   /*Contrutor*/
    public ControleBotoesSelecionados() {
        this.referenciaBotoes = new HashMap<>();
    }
   
   /*Funções*/
   public void addBtn(JButton btn){
       this.referenciaBotoes.put(btn, Boolean.FALSE);
   }
   
   public void alterarSelecao(JButton btn, Boolean selecionado){
       Boolean b = this.referenciaBotoes.get(btn);
       b = selecionado ;
   }
   
   public void zerarSelecoes(){
       for(Boolean b: this.referenciaBotoes.values()){
           b = Boolean.FALSE;
       }
   }
   
   public Boolean isTodasSelecionadas(){
       for(Boolean b: this.referenciaBotoes.values()){
           if(!b){
               //Não foram todos selecionados
               return false;
           }
       }
       return true;
   }
   
   
   
   
   /*Gets and Sets*/
    public String getImgFrenteBotao() {
        return imgFrenteBotao;
    }

    public void setImgFrenteBotao(String img) {
        this.imgFrenteBotao = img;
    }
    
    public void setImgFrenteBotao(PieceEnum img) {
        this.imgFrenteBotao = img.getNameImg();
    }

    public Map<JButton, Boolean> getReferenciaBotoes() {
        return referenciaBotoes;
    }

    public void setReferenciaBotoes(Map<JButton, Boolean> referenciaBotoes) {
        this.referenciaBotoes = referenciaBotoes;
    }
   
   
    
}
