package com.stefanini.service;

import com.stefanini.dto.stefamon.StefamonDTO;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.stefamon.StefamonNotFoundException;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    public List<StefamonDTO> listarTodosComPreco() {
        return repository.listAllWithPrice();
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon = repository.findById(id);
        if (Objects.isNull(stefamon)) {
            throw new StefamonNotFoundException(id);
        }
        return stefamon;
    }

    public StefamonDTO pegarPorIdComPreco(Long id) {
        return repository.findByIdWithPrice(id).orElseThrow(() -> new StefamonNotFoundException(id));
    }

    public List<StefamonDTO> listarStefamonsIniciaisComPreco() {
        return repository.listByPrice(5400.0);
    }
}
