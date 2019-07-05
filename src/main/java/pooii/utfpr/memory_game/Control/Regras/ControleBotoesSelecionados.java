/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii.utfpr.memory_game.Control.Regras;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import pooii.utfpr.memory_game.Model.VO.Piece;
import pooii.utfpr.memory_game.Model.VO.PieceEnum;

/**
 *
 * @author Jece Xavier
 */
public class ControleBotoesSelecionados {
    
    
   private String imgFrenteBotao;
   private String imgCostasBotao;
   private Map<JButton, EstadoBotoes> referenciaBotoes;
   
   /*Atributo de controle*/
   private Piece piece;

   /*Contrutor*/
    public ControleBotoesSelecionados() {
        this.referenciaBotoes = new HashMap<>();
        this.piece = new Piece();
    }
   
   /*Funções*/
    public void executarAcaoBtn(JButton btn, EstadoBotoes estado){
        this.alterarSelecao(btn, estado);
        
        if (this.isTodasSelecionadas()) {
            this.alterarEstadoTodosBtn(EstadoBotoes.ENCONTRADO);
        }else{
            this.alterarVisualizacaoBtn(btn);
        }
    }
    
    private void alterarEstadoTodosBtn(EstadoBotoes estado){
        for(JButton btn: this.referenciaBotoes.keySet()){
            this.alterarSelecao(btn, estado);
            this.alterarVisualizacaoBtn(btn);
        }
    }
    
   public void addBtn(JButton btn){
       this.referenciaBotoes.put(btn, EstadoBotoes.OCULTO);
   }
   
   public void alterarSelecao(JButton btn, EstadoBotoes selecionado){
       this.referenciaBotoes.put(btn, selecionado);
       
       
   }
   
   private void alterarVisualizacaoBtn(JButton btn){
       EstadoBotoes selecionado = this.referenciaBotoes.get(btn);
       
       switch(selecionado){
           case OCULTO: //Não exibir nada
               btn.setBackground(null);
               btn.setIcon(this.piece.createImg(PieceEnum.IMAGEM_COSTAS, btn.getWidth()));
           break;
           case SELECIONADO: //Exibir
//             btn.setEnabled(Boolean.FALSE);
               btn.setIcon(this.piece.createImg(this.imgFrenteBotao, btn.getWidth()));
           break;
           case ENCONTRADO:
               btn.setIcon(this.piece.createImg(this.imgFrenteBotao, btn.getWidth()));
               btn.setEnabled(Boolean.FALSE);
           break;
       }
   }
   
   
   public void zerarSelecoes(){
       this.alterarEstadoTodosBtn(EstadoBotoes.OCULTO);
   }
   
   public Boolean isTodasSelecionadas(){
       for(EstadoBotoes b: this.referenciaBotoes.values()){
           if(b != EstadoBotoes.SELECIONADO){
               //Não foram todos selecionados
               return false;
           }
       }
       return true;
   }
   
   
   
   
   /*Gets and Sets*/
   public String getImgCostasBotao() {
        return imgCostasBotao;
    }

    public void setImgCostasBotao(String imgCostasBotao) {
        this.imgCostasBotao = imgCostasBotao;
    }
   
    public String getImgFrenteBotao() {
        return imgFrenteBotao;
    }

    public void setImgFrenteBotao(String img) {
        this.imgFrenteBotao = img;
    }
    
    public void setImgFrenteBotao(PieceEnum img) {
        this.imgFrenteBotao = img.getNameImg();
    }

    public Map<JButton, EstadoBotoes> getReferenciaBotoes() {
        return referenciaBotoes;
    }

    public void setReferenciaBotoes(Map<JButton, EstadoBotoes> referenciaBotoes) {
        this.referenciaBotoes = referenciaBotoes;
    }
   
   
    
}
