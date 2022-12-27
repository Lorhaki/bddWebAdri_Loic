package bddweb.projet.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carte {
    private int idCard;
    private String dateExpiration;
    private String titulaireCarte;
    private String numeroCarte ;
    private int code ;
}
