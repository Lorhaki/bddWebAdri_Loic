package bddweb.projet.services.dto.comptes;

import bddweb.projet.entities.TypeTransaction;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePaiementResponse {
    private long idTransaction ;
    private double montant ;
    private TypeTransaction TypeT ;
    private LocalDate dateCreation;
}
