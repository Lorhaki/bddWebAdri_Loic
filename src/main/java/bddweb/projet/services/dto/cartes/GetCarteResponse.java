package bddweb.projet.services.dto.cartes;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCarteResponse {
    private String numeroCarte;
    private String dateExpiration;
    private List<Long> titulaireCarte;
}
