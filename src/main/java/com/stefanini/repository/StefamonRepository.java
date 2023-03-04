package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.stefamon.StefamonDTO;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StefamonRepository extends GenericDAO<Stefamon, Long> {

    private static final String PRICE = "ROUND((s.vida + s.ataque + s.defesa + s.inteligencia + s.poder + s.velocidade) / 6.0, 0) * 100";
    private static final String SELECT_STEFAMON_WITH_PRICE = "SELECT NEW " + StefamonDTO.class.getName() +
            "(s.id, s.nome, s.vida, s.ataque, s.defesa, s.inteligencia, s.poder, s.velocidade, s.urlFoto, " + PRICE + ") FROM Stefamon s";

    public List<StefamonDTO> listAllWithPrice() {
        return getEntityManager().createQuery(SELECT_STEFAMON_WITH_PRICE, StefamonDTO.class).getResultList();
    }

    public Optional<StefamonDTO> findByIdWithPrice(Long id) {
        String jpql = SELECT_STEFAMON_WITH_PRICE + " WHERE s.id = :id";
        return getEntityManager().createQuery(jpql, StefamonDTO.class)
                .setParameter("id", id)
                .getResultStream().findFirst();
    }

    public List<StefamonDTO> listByPrice(Double price) {
        return listByPrice(price, 0);
    }

    public List<StefamonDTO> listByPrice(Double price, int limit) {
        String jpql = SELECT_STEFAMON_WITH_PRICE + " WHERE " + PRICE + " = :price";
        var query = getEntityManager().createQuery(jpql, StefamonDTO.class)
                .setParameter("price", price);
        if (limit > 0) {
            query.setMaxResults(limit);
        }
        return query.getResultList();
    }
}
