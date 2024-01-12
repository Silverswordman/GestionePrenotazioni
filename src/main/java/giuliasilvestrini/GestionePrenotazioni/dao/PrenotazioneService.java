package giuliasilvestrini.GestionePrenotazioni.dao;

import giuliasilvestrini.GestionePrenotazioni.entities.Prenotazione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void save(Prenotazione prenotazione) {
        prenotazioneDAO.save(prenotazione);
        System.out.println("prenotazione salvata");
    }}
