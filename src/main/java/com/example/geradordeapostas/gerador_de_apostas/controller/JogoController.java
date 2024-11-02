package com.example.geradordeapostas.gerador_de_apostas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.geradordeapostas.gerador_de_apostas.model.Jogo;
import com.example.geradordeapostas.gerador_de_apostas.service.JogoService;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping("/gerar")
    public Jogo gerarJogo(@RequestParam String tipo, @RequestParam(required = false) String numeros) {
        return jogoService.gerarJogo(tipo, numeros);
    }
}