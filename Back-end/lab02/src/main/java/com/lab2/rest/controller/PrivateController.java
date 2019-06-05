package com.lab2.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {

    @GetMapping("/private")
    public String privateMsg() {
        return "[MENSAGEM DISPONIVEL APENAS PARA MACACO GOLD]";
    }

    @GetMapping("/public")
    public String publicMsg() {
        return "[MENSAGEM DISPONIVEL PARA OS semSKIN]";
    }

}
