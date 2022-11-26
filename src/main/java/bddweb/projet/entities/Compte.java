package bddweb.projet.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Compte {
    @Id
    @GeneratedValue
    private Long id ;

    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    private ArrayList<Client> titulairesCompte ;
    private ArrayList<Transaction> transactions;
}
