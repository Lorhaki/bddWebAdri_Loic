package bddweb.projet.services.dto;

import jdk.jshell.Snippet;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateClientResponse {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String telephone;
    private String adressePostale;
    private LocalDate dateModification;

}
