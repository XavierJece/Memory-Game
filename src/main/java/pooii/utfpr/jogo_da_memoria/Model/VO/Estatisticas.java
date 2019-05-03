package pooii.utfpr.jogo_da_memoria.Model.VO;

public class Estatisticas {
    /* Atributos */
    private Jogador player;
    private Modalidade mod;
    private int time;
    private int biggerSequence;
    private int beginTime;
    private int endTime;
    
    /*Construtor*/
    public Estatisticas(){
        
    }
    
    /*Metodos*/
    void rankTen(){
        
    }
    void histPlayer(){
        
    }
    
    /*Gets and Setters*/
    public Jogador getPlayer() {
        return player;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }

    public Modalidade getMod() {
        return mod;
    }

    public void setMod(Modalidade mod) {
        this.mod = mod;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getBiggerSequence() {
        return biggerSequence;
    }

    public void setBiggerSequence(int biggerSequence) {
        this.biggerSequence = biggerSequence;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    
    
}
