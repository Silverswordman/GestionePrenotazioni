package giuliasilvestrini.GestionePrenotazioni.dao;




import giuliasilvestrini.GestionePrenotazioni.entities.Postazione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneDAO postazioneDAO;

    public void save(Postazione postazione) {
        postazioneDAO.save(postazione);
        System.out.println("Postazione di tipo "+ postazione.getTipoPostazione() +" salvata" );
    }
}
