package giuliasilvestrini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor


public class Postazione {
    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo_Postazione")
    private TipoPostazione tipoPostazione;

    private String description;
    private int maxSeats;
    private boolean isFree;



    public Postazione(TipoPostazione tipoPostazione, String description, int maxSeats, boolean isFree) {
        this.tipoPostazione = tipoPostazione;
        this.description = description;
        this.maxSeats = maxSeats;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", tipoPostazione=" + tipoPostazione +
                ", description='" + description + '\'' +
                ", maxSeats=" + maxSeats +
                ", isFree=" + isFree +
                '}';
    }
}
