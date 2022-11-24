package bddweb.projet.repositories;

import bddweb.projet.entities.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComptesRepository {
    List<Client> findByIdCompte(int idCompte);
}
