package bddweb.projet.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Carte {

    @Id
    @GeneratedValue
    private long id;
    private String numeroCarte;

    @ManyToMany
    private List<Client> titulaireCarte;
    private LocalDateTime dateExpiration;
    private String codeCarte;

    @ManyToOne
    Compte compte;
}