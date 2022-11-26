package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.entities.Client;
import bddweb.projet.services.ClientService;
import bddweb.projet.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
