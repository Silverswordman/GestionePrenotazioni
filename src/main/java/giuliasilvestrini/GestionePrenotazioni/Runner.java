package giuliasilvestrini.GestionePrenotazioni;


import com.github.javafaker.Faker;
import giuliasilvestrini.GestionePrenotazioni.dao.EdificioService;
import giuliasilvestrini.GestionePrenotazioni.dao.PostazioneService;
import giuliasilvestrini.GestionePrenotazioni.dao.PrenotazioneService;
import giuliasilvestrini.GestionePrenotazioni.dao.UserService;
import giuliasilvestrini.GestionePrenotazioni.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Faker fake = new Faker();

        // Creazione edifici
        Edificio edificio1 = new Edificio(fake.company().name(), fake.address().streetAddress(), fake.address().city());
        Edificio edificio2 = new Edificio(fake.company().name(), fake.address().streetAddress(), fake.address().city());
        Edificio edificio3 = new Edificio(fake.company().name(), fake.address().streetAddress(), fake.address().city());
        Edificio edificio4 = new Edificio(fake.company().name(), fake.address().streetAddress(), fake.address().city());
        edificioService.save(edificio1);
        edificioService.save(edificio2);
        edificioService.save(edificio3);
        edificioService.save(edificio4);

        // Creazioni postazioni già inserite

        Postazione postazione1 = new Postazione(TipoPostazione.Open_Space, "vista mare", 3, true, edificio2);
        Postazione postazione2 = new Postazione(TipoPostazione.Sala_Riunioni, "molti posti", 20, false, edificio1);
        Postazione postazione3 = new Postazione(TipoPostazione.Privato, "sala quiet room", 1, false, edificio2);
        Postazione postazione4 = new Postazione(TipoPostazione.Sala_Riunioni, "possibilità di schermo e webcam", 6, false, edificio1);
        postazioneService.save(postazione1);
        postazioneService.save(postazione2);
        postazioneService.save(postazione3);
        postazioneService.save(postazione4);

        //Creazione utenti già inseriti

        User user1 = new User(fake.name().username(), fake.name().firstName() + fake.name().lastName(), fake.internet().emailAddress());
        User user2 = new User(fake.name().username(), fake.name().firstName() + fake.name().lastName(), fake.internet().emailAddress());
        User user3 = new User(fake.name().username(), fake.name().firstName() + fake.name().lastName(), fake.internet().emailAddress());
        User user4 = new User(fake.name().username(), fake.name().firstName() + fake.name().lastName(), fake.internet().emailAddress());
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);


        // aggiunta due prenotazioni db iniziale

        Random random = new Random();

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.of(random.nextInt(2000, 2010), random.nextInt(1, 12), random.nextInt(1, 28)), user1, postazione1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.of(random.nextInt(2000, 2010), random.nextInt(1, 12), random.nextInt(1, 28)), user2, postazione1);
        prenotazioneService.save(prenotazione1);
        prenotazioneService.save(prenotazione2);

        // per creare prenotazioni

        Edificio edificio5 = new Edificio("Nome compagnia", "Via Roma 3", "Milano");
        edificioService.save(edificio5);
        Postazione postazione5 = new Postazione(TipoPostazione.Open_Space, "check postazione", 3, true, edificio5);
        postazioneService.save(postazione5);
        User user5 = new User("nickname", "Francesco Totti", "francescototti@gmail.com");
        userService.save(user5);


        //esempio conflitto?
        postazioneService.prenotaPostazione(user5, postazione5, LocalDate.of(2024, 1, 12));
        postazioneService.prenotaPostazione(user1, postazione5, LocalDate.of(2024, 1, 12));


    }
}
