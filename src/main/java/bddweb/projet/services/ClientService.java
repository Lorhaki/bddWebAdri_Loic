package bddweb.projet.services;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.entities.Client;
import bddweb.projet.repositories.ClientsRepository;
import bddweb.projet.services.dto.clients.CreateClientRequest;
import bddweb.projet.services.dto.clients.CreateClientResponse;
import bddweb.projet.services.dto.clients.GetClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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





}
