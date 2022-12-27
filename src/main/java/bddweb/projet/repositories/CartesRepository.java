package bddweb.projet.repositories;

import bddweb.projet.entities.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartesRepository extends JpaRepository<Carte, Long> {
    List<Carte> findByIban(String iban);
}
