package bddweb.projet.repositories;

import bddweb.projet.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction,Long> {
    Transaction findByCompteId(int numeroCompte);

}
