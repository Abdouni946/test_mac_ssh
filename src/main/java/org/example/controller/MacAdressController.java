package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.util.macadress;

@RestController
public class MacAdressController {

    @GetMapping("/mac")
    public String getMacAddress() {

        return "Adresse MAC principale: " + macadress.getMacAddress();
    }



    @GetMapping("/")
    public String home() {
        return "Application d'affichage d'adresse MAC. Utilisez /mac pour voir l'adresse MAC principale";
    }
}