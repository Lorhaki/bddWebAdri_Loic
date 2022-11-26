package bddweb.projet.services.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetClientResponse {
    private long id;
    private String nom;
    private String prenom;
    private LocalDate datenaissance;
    private String telephone;
    private String adressePostale;
    private LocalDate dateCreation;
}
