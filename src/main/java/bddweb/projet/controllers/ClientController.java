package bddweb.projet.controllers;

import bddweb.projet.controllers.communs.HttpErreurFonctionnelle;
import bddweb.projet.services.CLientService;
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
    private CLientService cLientService;

    @GetMapping
    private ResponseEntity getCLients(@RequestParam("nom") String nom){
        if(nom==""||nom==null){
            return ResponseEntity
                    .badRequest()
                    .body(HttpErreurFonctionnelle.builder().message("idAuteur est obligatoire").build());
        }
        return ResponseEntity.ok().body(this)
    }

}