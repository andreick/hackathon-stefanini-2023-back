package com.stefanini.dto.jogador;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class JogadorAtualizacaoDTO {

    @NotNull
    @PositiveOrZero
    private final BigDecimal saldo;

    public JogadorAtualizacaoDTO(String nickname, String senha, BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
