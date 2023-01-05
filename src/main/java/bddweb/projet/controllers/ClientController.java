package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.controllers.communs.MessageErreurRequest;
import bddweb.projet.services.ClientService;
import bddweb.projet.services.dto.clients.CreateClientRequest;
import bddweb.projet.services.dto.clients.PutClientRequest;
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
                    .body(new HttpErreurFonctionnelle("Impossible de créer un client avec des données vides"));

        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()//500
                    .body(HttpErreurFonctionnelle.builder().message("Erreur serveur").build());
        }


    }

    @PutMapping
    public ResponseEntity modifierClient(@RequestBody PutClientRequest request) {
        try {
            return ResponseEntity.ok().body(this.clientService.modifierClient(request));
        } catch (BadRequestException b) {
            return ResponseEntity.badRequest().body(new MessageErreurRequest(b.getMessage()));
        } catch (Exception b) {
            return ResponseEntity.internalServerError().body(new MessageErreurRequest("Le probléme viens du serveur."));
        }
    }
}