package bddweb.projet.repositories;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComptesRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByClientId(Long id) ;


}
