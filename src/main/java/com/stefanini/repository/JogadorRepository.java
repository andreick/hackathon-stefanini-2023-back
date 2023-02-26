package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public Optional<Jogador> findByNickname(String nickname) {
        String query = "SELECT j FROM Jogador j WHERE j.nickname = :nickname";
        return createQuery(query).setParameter("nickname", nickname).getResultList().stream().findFirst();
    }
}
