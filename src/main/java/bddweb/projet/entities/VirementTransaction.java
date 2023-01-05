package bddweb.projet.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("V")
public class VirementTransaction extends Transaction {
    private long idVirement;

    private String libelleVirement;

    public long GetIdVirement() {
        return idVirement;
    }

}
