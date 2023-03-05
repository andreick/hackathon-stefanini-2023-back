package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public Optional<Jogador> findByNickname(String nickname) {
        String jpql = "SELECT j FROM Jogador j WHERE j.nickname = :nickname";
        return createQuery(jpql).setParameter("nickname", nickname).getResultStream().findFirst();
    }

    public Optional<Jogador> findByIdFetchStefamons(Long id) {
        String jpql = "SELECT j FROM Jogador j LEFT JOIN FETCH j.stefamons WHERE j.id = :id";
        return createQuery(jpql).setParameter("id", id).getResultStream().findFirst();
    }
}
