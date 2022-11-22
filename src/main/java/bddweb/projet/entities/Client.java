package bddweb.projet.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;

    private String nom ;
    private String prenom ;
    private int age ;
    private String telephonne;
    private String mail ;
    private String codeBanque ;
    private String codeGuichet ;
    private LocalDate dateNaissance;
    private String adressePostale;
    private LocalDate dateCreation;

}
