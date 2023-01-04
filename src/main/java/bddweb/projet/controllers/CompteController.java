package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.entities.Client;
import bddweb.projet.services.ClientService;
import bddweb.projet.services.CompteService;
import bddweb.projet.services.dto.comptes.CreateCompteRequest;
import bddweb.projet.services.dto.comptes.CreateCompteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    private ClientService clientService;
    private Client client;

    @GetMapping
    private ResponseEntity getComptes(@RequestParam("idClient")Long idClient){
        try{
            if(idClient == null|| idClient.equals("")){
                return ResponseEntity
                        .badRequest()//400
                        .body(HttpErreurFonctionnelle.builder().message("l'id du Client est obligatoire").build());
            }
            if(!this.clientService.existeId(idClient)){
                return ResponseEntity
                        .noContent()//204
                        .build();
            }
            return ResponseEntity.ok().body(this.compteService.getAllComptes(idClient));
        }catch (Exception e)
        {
            return ResponseEntity
                    .internalServerError()//500
                    .body(HttpErreurFonctionnelle.builder().message("Erreur serveur").build());
        }

    }

    @PostMapping
    private ResponseEntity createCompte(@RequestBody CreateCompteRequest request) throws BadRequestException {
        try{
            if(request.getIntituleCompte().isEmpty() || request.getTypeCompte()==null || request.getTitulairesCompte().isEmpty()) {
                return ResponseEntity.
                        badRequest()//400
                        .body(new HttpErreurFonctionnelle("Impossible de créer un client avec des données vides"));
            }
            return ResponseEntity
                    .created(null)
                    .body(this.compteService.createCompte(request));

        }catch (Exception e){
            return ResponseEntity
                    .internalServerError()//500
                    .body(HttpErreurFonctionnelle.builder().message("Erreur serveur").build());
        }

    }

}
