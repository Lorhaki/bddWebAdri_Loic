package bddweb.projet.repositories;

import bddweb.projet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    List<Client> findByNomAndPrenom(String nom, String prenom);
}
