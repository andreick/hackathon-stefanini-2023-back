package com.stefanini.parser;

import com.stefanini.dto.jogador.JogadorAtualizacaoDTO;
import com.stefanini.dto.jogador.JogadorCadastroDTO;
import com.stefanini.dto.jogador.JogadorDTO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceUtil;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class JogadorParser {

    @Inject
    private PersistenceUtil persistenceUtil;

    public Jogador dtoToEntity(JogadorCadastroDTO dto) {
        return new Jogador(null, dto.getNickname(), dto.getSenha());
    }

    public Jogador dtoToEntity(JogadorAtualizacaoDTO dto) {
        return new Jogador(null, null, null, dto.getSaldo());
    }

    public JogadorDTO entityToDto(Jogador jogador) {
        return new JogadorDTO(jogador.getId(), jogador.getNickname(), jogador.getSaldo(),
                persistenceUtil.isLoaded(jogador, "stefamons") ? jogador.getStefamons() : null);
    }

    public List<JogadorDTO> entityToDto(List<Jogador> jogadores) {
        return jogadores.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
