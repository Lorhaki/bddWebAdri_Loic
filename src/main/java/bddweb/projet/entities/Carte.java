package bddweb.projet.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Carte {
    @Id
    private String numeroCarte ;
    private String codeCarte;
    private String dateExpiration;


    @ManyToOne
    private Compte compteCarte;
    @ManyToOne
    private Client titulaireCarte;
}
