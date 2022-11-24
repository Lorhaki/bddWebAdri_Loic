package bddweb.projet.services;

import bddweb.projet.entities.Client;
import bddweb.projet.entities.Compte;
import bddweb.projet.repositories.ComptesRepository;
import bddweb.projet.services.dto.GetClientResponse;
import bddweb.projet.services.dto.GetCompteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteService {
    @Autowired
    private ComptesRepository comptesRepository;

    public List<GetCompteResponse> getAllComptes(int idCompte) {
        return this.compteRepository
                .findByIdCompte(idCompte)
                .stream()
                .map(this::buildGetComptesResponse)
                .collect(Collectors.toList());
    }

    private GetClientResponse buildGetComptesResponse(Compte compte) {
        return GetClientResponse.builder().
                id(client.getId()).
                nom(client.getNom()).
                prenom(client.getPrenom()).
                adressePostale(client.getAdressePostale()).
                dateCreation(client.getDateCreation()).
                datenaissance(client.getDateNaissance()).
                telephone(client.getTelephonne()).
                build();
    }


}
