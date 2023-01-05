package bddweb.projet.services;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.entities.Client;
import bddweb.projet.entities.Compte;
import bddweb.projet.repositories.ComptesRepository;
//import bddweb.projet.services.dto.GetCompteResponse;
import bddweb.projet.services.dto.comptes.CreateCompteRequest;
import bddweb.projet.services.dto.comptes.CreateCompteResponse;
import bddweb.projet.services.dto.comptes.GetCompteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

@Service
public class CompteService {


    @Autowired
    private ComptesRepository comptesRepository;

    public List<GetCompteResponse> getAllComptes(long idClient) {
        return this.comptesRepository
                .findByTitulairesCompteId(idClient)
                .stream()
                .map(this::buildGetComptesResponse)
                .collect(Collectors.toList());
    }

    public CreateCompteResponse createCompte(CreateCompteRequest compteToCreate)throws BadRequestException {
        Compte compteToSave = Compte.builder()
                .intituleCompte(compteToCreate.getIntituleCompte())
                .typeCompte(compteToCreate.getTypeCompte())
                .titulairesComptes(compteToCreate.getTitulairesCompte())
                .build();

        return buildCreateCompteResponse(this.comptesRepository.save(compteToSave));
    }
    private CreateCompteResponse buildCreateCompteResponse(Compte compte){
        return CreateCompteResponse.builder().
                intituleCompte(compte.getIntituleCompte()).
                typeCompte(compte.getTypeCompte()).
                titulairesCompte((List<Client>) compte.getTitulairesComptes()).
                iban(compte.getIban()).
                dateCreation(LocalDate.now()).
                build();
    }

    private GetCompteResponse buildGetComptesResponse(Compte compte) {
        return GetCompteResponse.builder()
                .iban(compte.getIban())
                .solde(compte.getSolde())
                .intituleCompte(compte.getIntituleCompte())
                .typeCompte(compte.getTypeCompte())
                .transactions(compte.getTransactions()
                        .stream()
                        .map(GTC -> GetCompteResponse.GetTransactionsCompteResponse
                                .builder()
                                .id(GTC.getIdTransaction())
                                .source(GTC.getTypeS())
                                .idSource((long) GTC.getIdSource())
                                .montant(abs(GTC.getMontant()))
                                .typeTransaction(GTC.getTypeT())
                                .build())
                        .collect(Collectors.toList())
                        .titulairesComptes(compte.getTitulairesComptes()
                        .stream()
                        .map(CPR -> GetCompteResponse.GetTitulairesCompteResponse
                                .builder()
                                .idClient(CPR.getIdClient())
                                .build())
                        .collect(Collectors.toList()))
                .build());
    }


}
