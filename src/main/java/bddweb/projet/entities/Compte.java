package bddweb.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class
Compte {
    @Id
    @GeneratedValue
    private long id ;
    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    @ManyToMany
    private List<Client> titulairesComptes;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compte")
    private List<Carte> cartes;
    private LocalDate dateCreation;
}
