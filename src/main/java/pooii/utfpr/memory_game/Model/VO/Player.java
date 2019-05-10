package pooii.utfpr.memory_game.Model.VO;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Cria uma tabela no meu Banco de Dadoss

//@Table muda o nome da tabela
//@Table(name = "tb_categoria")
public class Player {
    @Id // tipo deve ser long
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o auto valor do id
    private int id_player;

    private String email;

    private String pass;

    private String nickName;

    private LocalDate dateRegister;
  
    

    public Player(int id, String email, String pass, String nickName, LocalDate dateRegister) {
        this.id_player = id;
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
        return id_player;
    }

    public void setId(int id) {
        this.id_player = id;
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
