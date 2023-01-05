package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetCompteResponse {
    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    private List<Client> titulairesCompte;
    private List<Transaction> transactions;

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetTitulairesCompteResponse {
        private long idClient;
    }

        @Builder
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class GetTransactionsCompteResponse {
            private long id;
            private double montant;
            private TypeTransaction typeTransaction;
            private TypeSource source;
            private long idSource;

        }
    }

