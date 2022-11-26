package bddweb.projet.services;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.entities.Client;
import bddweb.projet.entities.Compte;
import bddweb.projet.repositories.ComptesRepository;
//import bddweb.projet.services.dto.GetCompteResponse;
import bddweb.projet.services.dto.CreateClientRequest;
import bddweb.projet.services.dto.CreateClientResponse;
import bddweb.projet.services.dto.comptes.CreateCompteRequest;
import bddweb.projet.services.dto.comptes.CreateCompteResponse;
import bddweb.projet.services.dto.comptes.GetCompteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public CreateCompteResponse createCompte(CreateCompteRequest compteToCreate)throws BadRequestException {
        Compte compteToSave = this.comptesRepository.save(Compte.builder())
                .intituleCompte(compteToCreate.getIntituleCompte())
                .typeCompte(compteToCreate.getTypeCompte())
                .titulaireCompte(compteToCreate.getTitulairesCompte())
                .iban(compteToCreate.getIban())
                .iban(compteToCreate.getIban())
                .build());

        return buildCreateCompteResponse(this.comptesRepository.save(compteToSave));
    }
    private CreateClientResponse buildCreateCompteResponse(Client client){
        return CreateClientResponse.builder().
                id(client.getId()).
                nom(client.getNom()).
                prenom(client.getPrenom()).
                adressePostale(client.getAdressePostale()).
                dateCreation(LocalDate.now()).
                dateNaissance(client.getDateNaissance()).
                telephone(client.getTelephonne()).
                build();
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
