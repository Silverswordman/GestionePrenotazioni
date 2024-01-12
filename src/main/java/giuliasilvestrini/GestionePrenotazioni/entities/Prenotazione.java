package giuliasilvestrini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter

@NoArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate dataInizio;
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    public Prenotazione(LocalDate dataInizio, User user, Postazione postazione) {
        this.dataInizio = dataInizio;
        this.dataFine = dataInizio.plusDays(1);
        this.user = user;
        this.postazione = postazione;
    }


    // setter per la postazione in prenot
    public void setPostazione(Postazione postazione) {
    }
}

