package bddweb.projet.services.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateClientRequest {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate datenaissance;
    private String telephone;
    private String adressePostale;
}
