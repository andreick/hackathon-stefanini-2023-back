package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.stefamon.StefamonComPreco;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StefamonRepository extends GenericDAO<Stefamon, Long> {

    private static final String PRICE = "ROUND((s.vida + s.ataque + s.defesa + s.inteligencia + s.poder + s.velocidade) / 6.0, 0) * 100 AS s_preco";
    private static final String SELECT_STEFAMON_WITH_PRICE = "SELECT NEW " + StefamonComPreco.class.getName() + "(s, " + PRICE + ") FROM Stefamon s";

    public List<StefamonComPreco> listAllWithPrice() {
        return getEntityManager().createQuery(SELECT_STEFAMON_WITH_PRICE, StefamonComPreco.class).getResultList();
    }

    public Optional<StefamonComPreco> findByIdWithPrice(Long id) {
        String jpql = SELECT_STEFAMON_WITH_PRICE + " WHERE s.id = :id";
        return getEntityManager().createQuery(jpql, StefamonComPreco.class)
                .setParameter("id", id)
                .getResultStream().findFirst();
    }
}
