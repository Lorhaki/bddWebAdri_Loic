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
        return clientRepository.findById(id);
    }



    public UpdateClientResponse buildPutClientResponse(Client c){
        return UpdateClientResponse.builder()
                .id((int) c.getId())
                .prenom(c.getPrenom())
                .nom(c.getNom())
                .dateNaissance(c.getDateNaissance())
                .telephone(c.getTelephonne())
                .adressePostale(c.getAdressePostale())
                .dateModification(LocalDate.parse(LocalDateTime.now().toString()))
                .build();
    }

    public UpdateClientResponse modifierClient(UpdateClientRequest client) throws BadRequestException {
        Client nouveau = Client.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .dateNaissance(client.getDateNaissance())
                .adressePostale(client.getAdressePostale())
                .telephonne(client.getTelephone())
                .build();
        return buildUpdateClientResponse(this.clientRepository.save(nouveau));
    }

    private UpdateClientResponse buildUpdateClientResponse(Client client){
        LocalDate d =LocalDate.now();
        return UpdateClientResponse.builder().
                id(client.getId()).
                nom(client.getNom()).
                prenom(client.getPrenom()).
                adressePostale(client.getAdressePostale()).
                dateModification(d).
                dateNaissance(client.getDateNaissance()).
                telephone(client.getTelephonne()).
                build();
    }

}
