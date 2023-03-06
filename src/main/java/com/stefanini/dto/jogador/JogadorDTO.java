package com.stefanini.dto.jogador;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.stefanini.dto.stefamon.StefamonDTO;

import java.math.BigDecimal;
import java.util.List;

public class JogadorDTO {

    private final Long id;
    private final String nickname;
    private final BigDecimal saldo;

    @JsonInclude(Include.NON_NULL)
    private final List<StefamonDTO> stefamons;

    public JogadorDTO(Long id, String nickname, BigDecimal saldo, List<StefamonDTO> stefamons) {
        this.id = id;
        this.nickname = nickname;
        this.saldo = saldo;
        this.stefamons = stefamons;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<StefamonDTO> getStefamons() {
        return stefamons;
    }
}
