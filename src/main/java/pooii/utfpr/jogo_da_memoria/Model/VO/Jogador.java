package pooii.utfpr.jogo_da_memoria.Model.VO;

import java.time.LocalDate;

public class Jogador {
    /* Atributos */
    private int id;
    private String email;
    private String pass;
    private String nickName;
    private LocalDate dateRegister;
    
    /* Construtor */
    public Jogador(int id, String email, String pass, String nickName, LocalDate dateRegister) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.nickName = nickName;
        this.dateRegister = dateRegister;
    }
    
    public Jogador(String name){
        this.nickName = name;
    }
    
    /* Metodos */
    public String updaterNickName(String newName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /* Gets and Setts*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }
    
    
}
