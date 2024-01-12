package giuliasilvestrini.GestionePrenotazioni.dao;


import giuliasilvestrini.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void save(User user) {
        userDAO.save(user);
        System.out.println("Utente " + user.getCompleteName() + " salvato");
    }
}
