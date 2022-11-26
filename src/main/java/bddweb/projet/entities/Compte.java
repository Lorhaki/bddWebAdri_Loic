package bddweb.projet.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Compte {
    @Id
    @GeneratedValue
    private long id ;

    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    private List<Client> titulairesCompte ;
    private List<Transaction> transactions;
    private LocalDate dateCreation;
}
