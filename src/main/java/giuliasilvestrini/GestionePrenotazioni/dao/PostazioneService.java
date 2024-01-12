package giuliasilvestrini.GestionePrenotazioni.dao;


import giuliasilvestrini.GestionePrenotazioni.entities.Postazione;
import giuliasilvestrini.GestionePrenotazioni.entities.Prenotazione;
import giuliasilvestrini.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Random;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneDAO postazioneDAO;

    @Autowired
    private PrenotazioneService prenotazioneService;


    @Autowired
    private UserService userService;

    public Postazione save(Postazione postazione) {
        return postazioneDAO.save(postazione);
    }


    public void prenotaPostazione(User user, Postazione postazione, LocalDate dataInizio) {
        if (user == null) {
            System.out.println("Error: Utente non esistente");
            return;
        }


        if (userService.hasPrenotazioneForDay(user, dataInizio)) {
            System.out.println("Impossibile prenotare più di una postazione nello stesso giorno.");
            return;
        }

        if (isPostazioneFree(postazione, dataInizio)) {
            Prenotazione prenotazione = new Prenotazione(dataInizio, user, postazione);
            prenotazioneService.save(prenotazione);

            postazione.setFree(false);
            postazione.addPrenotazione(prenotazione);
            save(postazione);

            System.out.println("Prenotazione inserita per il " + prenotazione.getDataInizio() + " di tipo " + postazione.getTipoPostazione());
            return;
        }

        System.out.println("Impossibile prenotare la postazione per le date e il luogo inseriti , già occupate");
    }


    // Prima check sulla data
    private boolean isPostazioneBooked(Postazione postazione, LocalDate data) {
        return postazione.getPrenotazioneList().stream()
                .anyMatch(prenotazione -> data.isEqual(prenotazione.getDataInizio()) || data.isEqual(prenotazione.getDataFine()));
    }

    // Check sulla disp
    public boolean isPostazioneFree(Postazione postazione, LocalDate data) {
        return postazione.isFree() && !isPostazioneBooked(postazione, data);
    }
}

