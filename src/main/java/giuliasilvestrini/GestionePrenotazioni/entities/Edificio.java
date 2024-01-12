package giuliasilvestrini.GestionePrenotazioni.entities;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
                ", city='" + city + '\''
              ;
    }
}
