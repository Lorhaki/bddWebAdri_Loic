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
@SuperBuilder
public class Transaction {

    @Id
    @GeneratedValue
    private long idTransaction;


    private TypeTransaction typeTransaction;
    private double montant;
    private LocalDateTime dateCreation;

    @ManyToOne
    private Compte compte;
    private TypeSource typeS;
    private int idSource;

}



