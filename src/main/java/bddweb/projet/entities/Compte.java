package bddweb.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compte {
    @Id
    @GeneratedValue
    private long id ;
    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    @ManyToMany
    private List<Client> titulairesComptes;
    @OneToMany
    private List<Transaction> transactions;
    @OneToMany
    private List<Carte> cartes;
    private LocalDate dateCreation;
}
