package bddweb.projet.services.dto.clients;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientResponse {
    private long id ;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance ;
    private String telephone;
    private String adressePostale ;
    private LocalDate dateModification ;
}
