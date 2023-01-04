package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<Client> titulairesCompte;
    private List<Transaction> transactions;

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class GetTitulairesCompteResponse {
        private long idClient;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class GetTransactionsCompteResponse{
        private long id;
        private double montant;
        private TypeTransaction typeTransaction;
        private TypeSource typeSource;
        private long idSource;
    }
}
