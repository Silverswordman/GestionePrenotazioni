package giuliasilvestrini.GestionePrenotazioni.entities;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Edificio {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioneList;


    public Edificio(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postazioneList=" + postazioneList +
                '}';
    }
}
