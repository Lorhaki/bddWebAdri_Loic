package bddweb.projet.services.dto.virements;


import bddweb.projet.entities.TypeSource;
import bddweb.projet.entities.TypeTransaction;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVirementResponse {
    private long idVirement;
    private LocalDate dateCreation;
    private List<CreateTransactionResponse> transactions;


    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateTransactionResponse {
        private Long id;
        private double montant;
        private TypeTransaction typeT;
        private TypeSource typeS;
        private long idSource;
/*
        public void updatetypeVirement() {
            if (this.getMontant() > 0) {
                this.setTypeTransaction(CREDIT);
            } else this.setTypeTransaction(DEBIT);
        }*/
    }
}
