package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.TypeCompte;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompteResponse {
    private String iban;
    private String intituleCompte;
    private TypeCompte typeCompte;
    private ArrayList<Client> titulairesCompte = new ArrayList<Client>();
    private LocalDate dateCreation;

}
