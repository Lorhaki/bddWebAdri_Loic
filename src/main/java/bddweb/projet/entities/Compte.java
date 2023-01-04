package bddweb.projet.entities;

import lombok.*;

import javax.persistence.*;
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
    @ManyToMany
    private List<Client> titulairesCompte;
    @ManyToMany
    private List<Transaction> transactions;
    @ManyToOne
    private List<Carte> cartes;
    private LocalDate dateCreation;
}
