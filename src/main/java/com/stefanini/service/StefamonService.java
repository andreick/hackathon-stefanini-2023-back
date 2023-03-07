package com.stefanini.service;

import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.stefamon.StefamonNotFoundException;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    public List<Stefamon> listarTodos() {
        return repository.listAll();
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon = repository.findById(id);
        if (Objects.isNull(stefamon)) {
            throw new StefamonNotFoundException(id);
        }
        return stefamon;
    }

    public List<Stefamon> listarStefamonsIniciais() {
        return repository.listByPrice(new BigDecimal(5400));
    }
}
