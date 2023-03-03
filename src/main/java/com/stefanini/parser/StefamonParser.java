package com.stefanini.parser;

import com.stefanini.dto.stefamon.StefamonDTO;
import com.stefanini.entity.Stefamon;
import com.stefanini.dto.stefamon.StefamonComPreco;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StefamonParser {

    public Stefamon dtoToEntity(StefamonDTO dto) {
        Stefamon stefamon = new Stefamon();
        return stefamon;
    }

    public StefamonDTO entityToDTO(StefamonComPreco stefamonComPreco) {
        var stefamon = stefamonComPreco.getStefamon();
        return new StefamonDTO(stefamon.getId(), stefamon.getNome(), stefamon.getVida(), stefamon.getAtaque(),
                stefamon.getDefesa(), stefamon.getInteligencia(), stefamon.getPoder(), stefamon.getVelocidade(),
                stefamon.getUrlFoto(), stefamonComPreco.getPreco());
    }

    public List<StefamonDTO> entityToDTO(List<StefamonComPreco> stefamonsComPreco) {
        return stefamonsComPreco.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
