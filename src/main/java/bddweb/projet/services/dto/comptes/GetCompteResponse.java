package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.Transaction;
import bddweb.projet.entities.TypeCompte;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCompteResponse {
    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    private ArrayList<Client> titulairesCompte ;
    private ArrayList<Transaction> transactions;
}
