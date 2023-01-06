package bddweb.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class
Compte {
    @Id
    @GeneratedValue
    private long id ;
    private String iban;
    private float solde ;
    private String intituleCompte;
    private TypeCompte typeCompte;
    @ManyToMany
    private List<Client> titulairesCompte;

    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compte")
    private List<Carte> cartes;
    private LocalDate dateCreation;

    public void creerIban()
    {
        //String s = "";
        int rand;
        int numCompte = 0;
        for(int i=0;i<11;i++)
        {
            rand= (int) (((int)(Math.random()*9)) * Math.pow(10, i));
            //System.out.println("rand =" + rand);
            numCompte += rand;
            //System.out.println("numcompte=" + numCompte);
        }
        int rib =97 - (89 * 30003 + 15 * 20549 + 3 * numCompte) % 97;
        String s = "FR76 " + "30003 " + "02054 " + numCompte + " " + rib;
        //System.out.println(s);
        this.iban = s;
    }
}
