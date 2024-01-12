package giuliasilvestrini.GestionePrenotazioni.dao;


import giuliasilvestrini.GestionePrenotazioni.entities.Prenotazione;
import giuliasilvestrini.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User save(User user) {
        return userDAO.save(user);
    }

    // check della lista utente?
    public boolean hasPrenotazioneForDay(User user, LocalDate data) {
        List<Prenotazione> prenotazioni = user.getPrenotazioneList();
        if (prenotazioni != null) {
            return prenotazioni.stream()
                    .anyMatch(prenotazione -> data.isEqual(prenotazione.getDataInizio()));
        }
        return false;
    }
}

