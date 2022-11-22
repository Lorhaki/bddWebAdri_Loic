package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService cLientService;

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
        return ResponseEntity.ok().body(this.cLientService.getAllClients(nom,prenom));
    }



}
