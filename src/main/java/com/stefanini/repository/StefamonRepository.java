package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class StefamonRepository extends GenericDAO<Stefamon, Long> {

    public List<Stefamon> listByPrice(BigDecimal price) {
        return listByPrice(price, 0);
    }

    public List<Stefamon> listByPrice(BigDecimal price, int limit) {
        String jpql = "SELECT s from Stefamon s WHERE s.preco = :price";
        var query = getEntityManager().createQuery(jpql, Stefamon.class)
                .setParameter("price", price);
        if (limit > 0) {
            query.setMaxResults(limit);
        }
        return query.getResultList();
    }
}
