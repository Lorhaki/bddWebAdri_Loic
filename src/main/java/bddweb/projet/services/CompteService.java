package bddweb.projet.services;

import bddweb.projet.entities.Compte;
import bddweb.projet.repositories.ComptesRepository;
//import bddweb.projet.services.dto.GetCompteResponse;
import bddweb.projet.services.dto.comptes.GetCompteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteService {

    @Autowired
    private ComptesRepository comptesRepository;

    public List<GetCompteResponse> getAllComptes(Long idClient) {
        return this.comptesRepository
                .findByClientId(idClient)
                .stream()
                .map(this::buildGetComptesResponse)
                .collect(Collectors.toList());
    }

    private GetCompteResponse buildGetComptesResponse(Compte compte) {
        return GetCompteResponse.builder().
                iban(compte.getIban()).
                solde(compte.getSolde()).
                intituleCompte(compte.getIntituleCompte()).
                typeCompte(compte.getTypeCompte()).
                titulairesCompte(compte.getTitulairesCompte()).
                transactions(compte.getTransactions()).
                build();
    }


}
