package com.stefanini.service;

import com.stefanini.dto.stefamon.StefamonDTO;
import com.stefanini.exceptions.stefamon.StefamonNotFoundException;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    public List<StefamonDTO> listarTodosComPreco() {
        return repository.listAllWithPrice();
    }

    public StefamonDTO pegarPorId(Long id) {
        return repository.findByIdWithPrice(id).orElseThrow(() -> new StefamonNotFoundException(id));
    }
}
