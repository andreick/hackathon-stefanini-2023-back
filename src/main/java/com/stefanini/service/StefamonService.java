package com.stefanini.service;

import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.dto.stefamon.StefamonComPreco;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    public List<StefamonComPreco> listarTodosComPreco() {
        return repository.listAllWithPrice();
    }

    public StefamonComPreco pegarPorId(Long id) {
        return repository.findByIdWithPrice(id).orElseThrow(() -> new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND));
    }

}
