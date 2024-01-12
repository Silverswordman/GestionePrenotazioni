package giuliasilvestrini.GestionePrenotazioni.entities;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioneList = new ArrayList<>();


    public void addPrenotazione(Prenotazione prenotazione) {
        prenotazioneList.add(prenotazione);
        prenotazione.setPostazione(this);
    }

    public Postazione(TipoPostazione tipoPostazione, String description, int maxSeats, boolean isFree, Edificio edificio) {
        this.tipoPostazione = tipoPostazione;
        this.description = description;
        this.maxSeats = maxSeats;
        this.isFree = isFree;
        this.edificio = edificio;
        this.prenotazioneList = new ArrayList<>();

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
