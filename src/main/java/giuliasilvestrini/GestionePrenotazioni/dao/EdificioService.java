package giuliasilvestrini.GestionePrenotazioni.dao;

import giuliasilvestrini.GestionePrenotazioni.entities.Edificio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioDAO edificioDAO;

    public void save(Edificio edificio) {
        edificioDAO.save(edificio);
        System.out.println("edificio " +edificio.getName()+ " salvato nella città " +edificio.getCity());
    }
}