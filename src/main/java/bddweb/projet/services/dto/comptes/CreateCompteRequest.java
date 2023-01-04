package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.Transaction;
import bddweb.projet.entities.TypeCompte;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompteRequest {
    private String intituleCompte;
    private TypeCompte typeCompte;
    private List<Client> titulairesCompte ;
}
