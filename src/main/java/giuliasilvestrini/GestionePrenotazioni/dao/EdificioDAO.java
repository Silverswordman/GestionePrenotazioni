package giuliasilvestrini.GestionePrenotazioni.dao;


import giuliasilvestrini.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioDAO extends JpaRepository <Edificio, Long> {
}
