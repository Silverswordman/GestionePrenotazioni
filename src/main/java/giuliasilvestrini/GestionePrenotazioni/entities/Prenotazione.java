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



    public Prenotazione(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
        this.dataFine = dataInizio.plusDays(1);

    }
}
