package com.stefanini.dto.jogador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class JogadorCadastroDTO {

    @NotBlank
    private final String nickname;

    @NotBlank
    @Size(min = 4, max = 10)
    private final String senha;

    @PositiveOrZero
    private final BigDecimal saldo;

    public JogadorCadastroDTO(String nickname, String senha, BigDecimal saldo) {
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
