package com.prav.BancodeDadosPID.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Nome do arquivo HTML na pasta templates
    }
}