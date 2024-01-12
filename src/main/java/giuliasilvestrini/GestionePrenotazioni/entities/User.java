package giuliasilvestrini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String completeName;
    private String mail;



    public User(String username, String completeName, String mail) {
        this.username = username;
        this.completeName = completeName;
        this.mail = mail;

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", completeName='" + completeName + '\'' +
                ", mail='" + mail + '\'';
    }
}
