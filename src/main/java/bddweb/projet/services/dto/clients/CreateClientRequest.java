package bddweb.projet.services.dto.clients;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientRequest {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String telephone;
    private String adressePostale;
}
