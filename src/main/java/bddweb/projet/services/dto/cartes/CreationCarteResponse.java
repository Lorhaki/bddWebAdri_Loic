package bddweb.projet.services.dto.cartes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreationCarteResponse {
    private String titulaireCarte ;
    private String numeroCarte;
    private String dateExpiration ;
}
