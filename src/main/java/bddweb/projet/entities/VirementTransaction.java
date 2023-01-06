package bddweb.projet.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("V")
public class VirementTransaction extends Transaction {
    @Id
    @GeneratedValue
    private long idVirement;

    private String libelleVirement;

    public long GetIdVirement() {
        return idVirement;
    }

}
