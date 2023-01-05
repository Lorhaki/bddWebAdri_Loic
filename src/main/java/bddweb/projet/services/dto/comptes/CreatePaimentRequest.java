package bddweb.projet.services.dto.comptes;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePaimentRequest {
    private double montant ;
    private LocalDate dateCreation;
}
