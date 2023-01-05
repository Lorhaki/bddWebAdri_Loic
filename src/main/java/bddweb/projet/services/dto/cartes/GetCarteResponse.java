package bddweb.projet.services.dto.cartes;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCarteResponse {
    private String numeroCarte;
    private LocalDateTime dateExpiration;
    private List<GetTitulairesCarteResponse> titulaireCarte;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class GetTitulairesCarteResponse {
        private Long idClient;
    }
}
