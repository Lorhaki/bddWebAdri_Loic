package bddweb.projet.services.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetClientResponse {
    private Long id;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String telephone;
    private String adressePostale;
    private Date dateCreation;
}
