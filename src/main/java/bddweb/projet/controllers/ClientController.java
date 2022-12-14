package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.controllers.communs.MessageErreurRequest;
import bddweb.projet.services.ClientService;
import bddweb.projet.services.dto.clients.CreateClientRequest;
import bddweb.projet.services.dto.clients.UpdateClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity getClient(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        try {
            if (nom.equals(" ") || nom.isEmpty()) {
                return ResponseEntity
                        .badRequest()//400
                        .body(HttpErreurFonctionnelle.builder().message("le nom est obligatoire").build());
            }
            if (prenom.equals(" ") || prenom.isEmpty()) {
                return ResponseEntity
                        .badRequest()//400
                        .body(HttpErreurFonctionnelle.builder().message("le prenom est obligatoire").build());
            }
            if (this.clientService.getAllClients(nom, prenom).isEmpty()) {
                return ResponseEntity
                        .noContent()//204
                        .build();
            }
            return ResponseEntity.ok().body(this.clientService.getAllClients(nom, prenom));

        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()//500
                    .body(HttpErreurFonctionnelle.builder().message("Erreur serveur").build());
        }

    }

    @PostMapping
    private ResponseEntity createClient(@RequestBody CreateClientRequest request) throws BadRequestException {
        try {
            if (!request.getAdressePostale().isBlank() && request.getPrenom() != null && request.getNom() != null && request.getDateNaissance() != null && request.getTelephone() != null && request.getAdressePostale() != null && !request.getPrenom().isBlank() && !request.getNom().isBlank()) {
                return ResponseEntity
                        .created(null)//201
                        .body(this.clientService.createClient(request));
            }
            return ResponseEntity.
                    badRequest()//400
                    .body(new HttpErreurFonctionnelle("Impossible de cr??er un client avec des donn??es vides"));

        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()//500
                    .body(HttpErreurFonctionnelle.builder().message("Erreur serveur").build());
        }


    }

    @PutMapping
    public ResponseEntity modifierClient(@RequestBody UpdateClientRequest client) {

        try {
            if(clientService.existeId(client.getId()) == null)
            {
                return ResponseEntity
                        .badRequest()//400
                        .body(new HttpErreurFonctionnelle("Impossible de trouver un client avec cette id"));
            }
            if(client.getPrenom() == null || client.getNom() == null || client.getDateNaissance() == null || client.getTelephone() == null || client.getAdressePostale() == null || client.getPrenom().isBlank() || client.getNom().isBlank())
            {
                return ResponseEntity
                        .badRequest()
                        .body(new HttpErreurFonctionnelle("Un des param??tres poss??de une erreur"));//400
            }
            return ResponseEntity.ok().body(this.clientService.modifierClient(client));
        } catch (BadRequestException e) {
            return ResponseEntity
                    .internalServerError()//500
                    .body(new MessageErreurRequest("Erreur serveur."));
        }

    }
}