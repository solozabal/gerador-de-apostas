package com.example.geradordeapostas.gerador_de_apostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.geradordeapostas.gerador_de_apostas.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}