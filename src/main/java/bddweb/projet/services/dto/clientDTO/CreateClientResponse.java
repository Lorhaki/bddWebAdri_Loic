package bddweb.projet.services.dto.clientDTO;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientResponse {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String telephone;
    private String adressePostale;
    private Date dateCreation;
}
