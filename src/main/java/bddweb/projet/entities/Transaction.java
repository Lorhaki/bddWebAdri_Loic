package bddweb.projet.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Transaction{
    @Id
    @GeneratedValue
    private long idTransaction;

    private TypeTransaction typeT;
    private double montant;
    private LocalDateTime dateCreation;

    @ManyToOne
    private Compte compte;

    private TypeSource typeS;
    private int idSource;

/*
    public void updatetypeVirement() {
        if (this.getMontant() > 0) {
            this.setTypeTransaction(CREDIT);
        } else this.setTypeTransaction(DEBIT);
    }*/
}


