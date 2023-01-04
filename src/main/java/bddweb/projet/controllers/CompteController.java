package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.entities.Client;
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
    private Client client;

    @GetMapping
    private ResponseEntity getComptes(@RequestParam("idClient")Long idClient){
        if(idClient == null){
            return ResponseEntity
                    .badRequest()
                    .body(HttpErreurFonctionnelle.builder().message("l'id du Client est obligatoire").build());
        }
        return ResponseEntity.ok().body(this.compteService.getAllComptes(idClient));
    }

    @PostMapping
    private ResponseEntity<CreateCompteResponse> createCompte(@RequestBody CreateCompteRequest request) throws BadRequestException {
        return ResponseEntity.created(null).body(this.compteService.createCompte(request));
    }

}
