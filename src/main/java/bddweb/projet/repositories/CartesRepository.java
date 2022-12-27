package bddweb.projet.repositories;

import bddweb.projet.entities.Compte;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartesRepository {
    List<Compte> findByIban(String iban) ;
}
