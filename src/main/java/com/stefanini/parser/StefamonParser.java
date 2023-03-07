package com.stefanini.parser;

import com.stefanini.dto.stefamon.StefamonDTO;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StefamonParser {

    public StefamonDTO entityToDTO(Stefamon stefamon) {
        return new StefamonDTO(stefamon.getId(), stefamon.getNome(), stefamon.getVida(), stefamon.getAtaque(),
                stefamon.getDefesa(), stefamon.getInteligencia(), stefamon.getPoder(), stefamon.getVelocidade(),
                stefamon.getPreco(), stefamon.getUrlFoto());
    }

    public List<StefamonDTO> entityToDTO(List<Stefamon> stefamons) {
        return stefamons.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
