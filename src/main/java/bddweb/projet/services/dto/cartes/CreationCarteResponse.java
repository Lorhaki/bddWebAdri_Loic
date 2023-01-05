package bddweb.projet.services.dto.cartes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreationCarteResponse {
    private Long titulaireCarte ;
    private String numeroCarte;
    private String dateExpiration ;

}
