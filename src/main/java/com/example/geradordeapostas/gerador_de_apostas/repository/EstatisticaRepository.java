package com.example.geradordeapostas.gerador_de_apostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.geradordeapostas.gerador_de_apostas.model.Estatistica;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}