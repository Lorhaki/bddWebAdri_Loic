package bddweb.projet.services;

import bddweb.projet.entities.Client;
import bddweb.projet.repositories.ClientsRepository;
import bddweb.projet.services.dto.GetClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class CLientService {
    @Autowired
    private ClientsRepository clientRepository;

    public List<GetClientResponse> getAllClients(String nom, String prenom) {
        return this.clientRepository
                .findByNomAndPrenom(nom,prenom)
                .stream()
                .map(this::buildGetClientsResponse)
                .collect(Collectors.toList());
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



}
