package com.stefanini.dto.jogador;

import java.math.BigDecimal;

public class JogadorDTO {

    private final Long id;
    private final String nickname;
    private final BigDecimal saldo;

    public JogadorDTO(Long id, String nickname, String senha, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.saldo = saldo;
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

}
