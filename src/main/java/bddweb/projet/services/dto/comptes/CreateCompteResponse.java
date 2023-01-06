package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.TypeCompte;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompteResponse {

    private String intituleCompte;
    private TypeCompte typeCompte;
    private List<CreateCompteClientResponse> titulairesCompte;
    private String iban;
    private LocalDate dateCreation;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CreateCompteClientResponse {
        private long idClient;
    }

}
