package giuliasilvestrini.GestionePrenotazioni;

import giuliasilvestrini.GestionePrenotazioni.dao.EdificioService;
import giuliasilvestrini.GestionePrenotazioni.dao.PostazioneService;
import giuliasilvestrini.GestionePrenotazioni.dao.PrenotazioneService;
import giuliasilvestrini.GestionePrenotazioni.dao.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import giuliasilvestrini.GestionePrenotazioni.entities.*;

import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.Random;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    UserService userService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String[] args) throws Exception {
        Edificio edificio1 = new Edificio("La Nuvola", "Via Roma 2", "Milano");
        Edificio edificio2 = new Edificio("Palazzo Strozzi", "Via Fratelli Colabona 5", "Roma");
        edificioService.save(edificio1);
        edificioService.save(edificio2);

        Postazione postazione1 = new Postazione(TipoPostazione.Privato, "vista mare", 3, true, edificio2);
        Postazione postazione2 = new Postazione(TipoPostazione.Sala_Riunioni, "molti posti", 20, false, edificio1);
        postazioneService.save(postazione1);
        postazioneService.save(postazione2);

        User user1 = new User("Ciccio", "Francesco Totti", "francescototti@gmail.com");
        User user2 = new User("Ale", "Alessandro Totti", "cicciobaciccio@hotmail.");
        userService.save(user1);
        userService.save(user2);

        Random random = new Random();

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.of(random.nextInt(2000, 2010), random.nextInt(1, 12), random.nextInt(1, 28)), user1, postazione1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.of(random.nextInt(2000, 2010), random.nextInt(1, 12), random.nextInt(1, 28)), user2, postazione1);
        prenotazioneService.save(prenotazione1);
        prenotazioneService.save(prenotazione2);
    }
}
