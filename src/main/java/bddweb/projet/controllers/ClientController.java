package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.BadRequestException;
import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.services.ClientService;
import bddweb.projet.services.dto.clientDTO.CreateClientRequest;
import bddweb.projet.services.dto.clientDTO.CreateClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity getCLients(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom){
        if(nom.equals(" ")||nom.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(HttpErreurFonctionnelle.builder().message("le nom est obligatoire").build());
        }
        if(prenom.equals(" ")||prenom.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(HttpErreurFonctionnelle.builder().message("le prenom est obligatoire").build());
        }
        return ResponseEntity.ok().body(this.clientService.getAllClients(nom,prenom));
    }

    @PostMapping
    private ResponseEntity<CreateClientResponse> createClient(@RequestBody CreateClientRequest request) throws BadRequestException {
        return ResponseEntity.created(null).body(this.clientService.createClient(request));
    }



}
