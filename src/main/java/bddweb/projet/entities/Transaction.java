package bddweb.projet.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction{
    @Id
    @GeneratedValue
    private int  id;

    private float montant;
    private String typeTransaction;
    private String source;
    private int idSource;
}

