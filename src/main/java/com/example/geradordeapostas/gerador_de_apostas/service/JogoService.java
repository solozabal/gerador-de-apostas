package com.example.geradordeapostas.gerador_de_apostas.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.geradordeapostas.gerador_de_apostas.model.Jogo;
import com.example.geradordeapostas.gerador_de_apostas.repository.JogoRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo gerarJogo(String tipo, String numerosInput) {
        Set<Integer> numeros;
        Random random = new Random();

        if (numerosInput != null && !numerosInput.isEmpty()) {
            numeros = Arrays.stream(numerosInput.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toSet());
            validarNumeros(tipo, numeros);
        } else {
            numeros = gerarNumerosAleatorios(tipo, random);
        }

        Jogo jogo = new Jogo();
        jogo.setTipo(tipo);
        jogo.setNumeros(numeros.toString());
        return jogoRepository.save(jogo);
    }

    private void validarNumeros(String tipo, Set<Integer> numeros) {
        switch (tipo) {
            case "Mega Sena" -> {
                if (numeros.size() != 6 || numeros.stream().anyMatch(n -> n < 1 || n > 60)) {
                    throw new IllegalArgumentException("Mega Sena requer 6 números entre 1 e 60.");
                }
            }
            case "Quina" -> {
                if (numeros.size() != 5 || numeros.stream().anyMatch(n -> n < 1 || n > 80)) {
                    throw new IllegalArgumentException("Quina requer 5 números entre 1 e 80.");
                }
            }
            case "LotoFácil" -> {
                if (numeros.size() < 15 || numeros.size() > 20 || numeros.stream().anyMatch(n -> n < 1 || n > 25)) {
                    throw new IllegalArgumentException("LotoFácil requer entre 15 e 20 números entre 1 e 25.");
                }
            }
            default -> throw new IllegalArgumentException("Tipo de jogo desconhecido: " + tipo);
        }
    }

    private Set<Integer> gerarNumerosAleatorios(String tipo, Random random) {
        Set<Integer> numeros = new HashSet<>();
        switch (tipo) {
            case "Mega Sena" -> {
                while (numeros.size() < 6) {
                    numeros.add(random.nextInt(60) + 1);
                }
            }
            case "Quina" -> {
                while (numeros.size() < 5) {
                    numeros.add(random.nextInt(80) + 1);
                }
            }
            case "LotoFácil" -> {
                while (numeros.size() < 15) {
                    numeros.add(random.nextInt(25) + 1);
                }
            }
            default -> throw new IllegalArgumentException("Tipo de jogo desconhecido: " + tipo);
        }
        return numeros;
    }
}