package bddweb.projet.services;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.entities.Client;
import bddweb.projet.repositories.ClientsRepository;
import bddweb.projet.services.dto.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientsRepository clientRepository;

    public List<GetClientResponse> getAllClients(String nom, String prenom) {
        return this.clientRepository
                .findByNomAndPrenom(nom,prenom)
                .stream()
                .map(this::buildGetClientsResponse)
                .collect(Collectors.toList());
    }

    public CreateClientResponse createClient(CreateClientRequest clientToCreate)throws BadRequestException {
        Client clientToSave = this.clientRepository.save(Client.builder()
                .nom(clientToCreate.getNom())
                .prenom(clientToCreate.getPrenom())
                .dateNaissance(clientToCreate.getDateNaissance())
                .adressePostale(clientToCreate.getAdressePostale())
                .telephonne(clientToCreate.getTelephone())
                .build());

        return buildCreateClientResponse(this.clientRepository.save(clientToSave));
    }

    private GetClientResponse buildGetClientsResponse(Client client) {
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
    private CreateClientResponse buildCreateClientResponse(Client client){
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

//permet de savoir si au moins un client avec un certain id existe
    public Client existeId(long id)
    {
        System.out.println("bonjour");
        return clientRepository.findById(id);
    }



    public PutClientResponse buildPutClientResponse(Client c){
        return PutClientResponse.builder()
                .idClient((int) c.getId())
                .prenom(c.getPrenom())
                .nom(c.getNom())
                .dateNaissance(c.getDateNaissance())
                .telephone(c.getTelephonne())
                .adressePostale(c.getAdressePostale())
                .dateModification(LocalDate.parse(LocalDateTime.now().toString()))
                .build();
    }

    public PutClientResponse modifierClient(PutClientRequest request) throws BadRequestException {
        if (request.getIdClient() == null){
            throw new BadRequestException("Attention l'id du Client n'est pas renseigné.");
        } else if (request.getPrenom() == null){
            throw new BadRequestException("Attention aucun prénom n'est renseigné.");
        } else if (request.getNom() == null){
            throw new BadRequestException("Attention aucun nom est renseigné.");
        } else if (request.getDateNaissance() == null){
            throw new BadRequestException("Attention aucune date de naissance  est renseignée.");
        } else if (request.getTelephone() == null){
            throw new BadRequestException("Attention aucun numéro de téléphone est renseigné.");
        } else if (request.getAdressePostale() == null){
            throw new BadRequestException("Attention aucune adresse postale est renseignée.");
        } else if (request.getPrenom().matches(".*\\d.*")){
            throw new BadRequestException("Attention le prénom ne posséde pas le bon format.");
        } else if (request.getNom().matches(".*\\d.*")){
            throw new BadRequestException("Attention le nom ne posséde pas le bon format.");
        } else if (!request.getTelephone().matches("(0|\\+33|0033)[1-9][0-9]{8}")){
            throw new BadRequestException("Attention le numéro de téléphone ne posséde pas le bon format.");
        }

        Client clientOpt = this.clientRepository.findById(request.getIdClient().longValue());
        if (clientOpt==null){
            throw new BadRequestException("Aucun client ne correspond à l'id renseigné.");
        }

        Client c = clientOpt;
        Client toSave = Client.builder()
                .id(c.getId())
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .dateNaissance(request.getDateNaissance())
                .telephonne(request.getTelephone())
                .adressePostale(request.getAdressePostale())
                .dateCreation(c.getDateCreation())
                .comptes(c.getComptes())
                .cartes(c.getCartes())
                .codeBanque(c.getCodeBanque())
                .codeGuichet(c.getCodeGuichet())
                .build();

        return buildPutClientResponse(this.clientRepository.save(toSave));
    }

}
