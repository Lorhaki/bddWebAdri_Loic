package bddweb.projet.services.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetClientResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String telephone;
    private String adressePostale;
    private String dateCreation;
}
