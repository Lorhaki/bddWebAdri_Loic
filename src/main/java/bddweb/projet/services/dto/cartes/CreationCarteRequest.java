package bddweb.projet.services.dto.cartes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreationCarteRequest {
    private String titulaireCarte ;
    private int code ;
}
