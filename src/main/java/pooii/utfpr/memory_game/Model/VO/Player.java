package pooii.utfpr.memory_game.Model.VO;

import java.time.LocalDate;

public class Player {

    private int id;

    private String email;

    private String pass;

    private String nickName;

    private LocalDate dateRegister;

    public Player(int id, String email, String pass, String nickName, LocalDate dateRegister) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.nickName = nickName;
        this.dateRegister = dateRegister;
    }

    public Player(String name) {
        this.nickName = name;
    }

    public String updaterNickName(String newName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
