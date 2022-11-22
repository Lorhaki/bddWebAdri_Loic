package bddweb.projet.entities;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
@Getter
@Setter
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
    private Date dateNaissance;
    private String adressePostale;
    private Date dateCreation;

    ArrayList<Carte> listeCarte = new ArrayList<>();
}
