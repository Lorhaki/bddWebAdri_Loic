package bddweb.projet.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Compte compte;

    private TypeTransaction typeTransaction;
    private double montant;
    private LocalDateTime dateCreation;
    private TypeSource typeS;
    private int idSource;

}



