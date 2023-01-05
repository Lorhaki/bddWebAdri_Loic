package bddweb.projet.services.dto.virements;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVirementRequest {
    private String ibanCompteEmetteur ;
    private  String ibanCompteBeneficiaire;
    private double montant ;
    private String libelleVirement ;
}
