package bddweb.projet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCarte extends Transaction {

    @ManyToOne
    Carte carte;
}