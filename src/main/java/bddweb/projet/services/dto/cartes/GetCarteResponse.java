package bddweb.projet.services.dto.cartes;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCarteResponse {
    private String numeroCarte;
    private String dateExpiration;
    private ArrayList<Long> titulaireCarte;
}
