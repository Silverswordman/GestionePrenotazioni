package giuliasilvestrini.GestionePrenotazioni.dao;


import giuliasilvestrini.GestionePrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}
